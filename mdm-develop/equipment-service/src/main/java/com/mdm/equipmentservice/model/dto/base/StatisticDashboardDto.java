package com.mdm.equipmentservice.model.dto.base;

import com.mdm.equipmentservice.model.entity.EquipmentStatus;
import com.mdm.equipmentservice.model.entity.RiskLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class StatisticDashboardDto {
    private List<CountByDepartment> countByDepartment;

    private List<CountByRiskLevel> countByRiskLevels;

    private List<CountByEquipmentStatus> countByEquipmentStatuses;

    private List<CountByDepartment> countRepairingByDepartment;

    private List<CountByDepartment> countBrokenByDepartment;

    @Data
    @AllArgsConstructor
    public static class CountByDepartment {
        private Long departmentId;

        private String departmentName;

        private Long count;
    }

    @AllArgsConstructor
    @Data
    public static class CountByRiskLevel {
        private RiskLevel riskLevel;

        private Long count;
    }

    @AllArgsConstructor
    @Data
    public static class CountByEquipmentStatus {
        private EquipmentStatus status;

        private Long count;
    }
}
