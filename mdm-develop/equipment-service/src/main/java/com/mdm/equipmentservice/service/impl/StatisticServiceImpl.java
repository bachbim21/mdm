package com.mdm.equipmentservice.service.impl;

import com.mdm.equipmentservice.model.dto.base.StatisticDashboardDto;
import com.mdm.equipmentservice.model.entity.Department;
import com.mdm.equipmentservice.model.entity.EquipmentStatus;
import com.mdm.equipmentservice.model.entity.RiskLevel;
import com.mdm.equipmentservice.model.repository.DepartmentRepository;
import com.mdm.equipmentservice.model.repository.EquipmentRepository;
import com.mdm.equipmentservice.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static com.mdm.equipmentservice.query.predicate.EquipmentPredicate.*;

@Service
public class StatisticServiceImpl implements StatisticService {
    private final EquipmentRepository equipmentRepository;

    private final DepartmentRepository departmentRepository;

    @Autowired
    public StatisticServiceImpl(EquipmentRepository equipmentRepository, DepartmentRepository departmentRepository) {
        this.equipmentRepository = equipmentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public StatisticDashboardDto getStatisticDashboard() {
        StatisticDashboardDto statisticDashboardDto = new StatisticDashboardDto();
        List<StatisticDashboardDto.CountByDepartment> countEquipmentByDepartmentList = new ArrayList<>();
        List<StatisticDashboardDto.CountByRiskLevel> countEquipmentByRiskLevelList = new ArrayList<>();
        List<StatisticDashboardDto.CountByEquipmentStatus> countEquipmentByStatusList = new ArrayList<>();
        List<StatisticDashboardDto.CountByDepartment> countRepairingByDepartmentList = new ArrayList<>();
        List<StatisticDashboardDto.CountByDepartment> countBrokenByDepartmentList = new ArrayList<>();
        List<Department> allDepartments = departmentRepository.findAll();
        CompletableFuture<Void> countEquipmentByDepartmentFuture = CompletableFuture.runAsync(() -> allDepartments.parallelStream().forEach(department -> {
            //count equipment in each department
            countEquipmentByDepartmentList.add(new StatisticDashboardDto.CountByDepartment(
                    department.getId(),
                    department.getName(),
                    equipmentRepository.count(Objects.requireNonNull(matchDepartmentId(department.getId())))
            ));
            //count equipment that has REPAIRING status in each department
            countRepairingByDepartmentList.add(new StatisticDashboardDto.CountByDepartment(
                    department.getId(),
                    department.getName(),
                    equipmentRepository.count(matchDepartmentId(department.getId()).and(matchStatus(EquipmentStatus.REPAIRING)))
            ));
            //count equipment that has BROKEN status in each department
            countBrokenByDepartmentList.add(new StatisticDashboardDto.CountByDepartment(
                    department.getId(),
                    department.getName(),
                    equipmentRepository.count(matchDepartmentId(department.getId()).and(matchStatus(EquipmentStatus.BROKEN)))
            ));
        }));
//        CompletableFuture<Void> countEquipmentByRiskLevelFuture = CompletableFuture.runAsync(() -> Arrays.stream(RiskLevel.values()).forEach(riskLevel -> {
//            //count equipment by risk level
//            countEquipmentByRiskLevelList.add(new StatisticDashboardDto.CountByRiskLevel(riskLevel, equipmentRepository.count(matchRiskLevel(riskLevel))));
//        }));
        CompletableFuture<Void> countEquipmentByStatusFuture = CompletableFuture.runAsync(() -> Arrays.stream(EquipmentStatus.values())
                .forEach(equipmentStatus -> {
                    //do not statistic equipment that has these statuses
                    if (statusNotIn(equipmentStatus)) {
                        return;
                    }
                    //count equipment by status
                    countEquipmentByStatusList.add(new StatisticDashboardDto.CountByEquipmentStatus(
                            equipmentStatus,
                            equipmentRepository.count(matchStatus(equipmentStatus))
                    ));
                }));
//        CompletableFuture.allOf(countEquipmentByDepartmentFuture, countEquipmentByRiskLevelFuture, countEquipmentByStatusFuture).join();
        statisticDashboardDto.setCountBrokenByDepartment(countBrokenByDepartmentList);
        statisticDashboardDto.setCountRepairingByDepartment(countRepairingByDepartmentList);
        statisticDashboardDto.setCountByDepartment(countEquipmentByDepartmentList);
//        statisticDashboardDto.setCountByRiskLevels(countEquipmentByRiskLevelList);
        statisticDashboardDto.setCountByEquipmentStatuses(countEquipmentByStatusList);
        return statisticDashboardDto;
    }

    /**
     * Check if equipment status is not in these statuses
     */
    public static boolean statusNotIn(EquipmentStatus equipmentStatus) {
        return equipmentStatus.equals(EquipmentStatus.PENDING_HANDOVER) || equipmentStatus.equals(EquipmentStatus.PENDING_TRANSFER) ||
                equipmentStatus.equals(EquipmentStatus.PENDING_REPORT_BROKEN) || equipmentStatus.equals(EquipmentStatus.PENDING_ACCEPT_REPAIR) ||
                equipmentStatus.equals(EquipmentStatus.PENDING_ACCEPT_LIQUIDATION) || equipmentStatus.equals(EquipmentStatus.PENDING_ACCEPTANCE_TESTING) ||
                equipmentStatus.equals(EquipmentStatus.UNDER_MAINTENANCE) || equipmentStatus.equals(EquipmentStatus.PENDING_ACCEPT_MAINTENANCE) ||
                equipmentStatus.equals(EquipmentStatus.PENDING_ACCEPT_INSPECTION) || equipmentStatus.equals(EquipmentStatus.UNDER_INSPECTION);
    }
}
