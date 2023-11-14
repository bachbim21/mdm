package com.mdm.equipmentservice;

public class SeedEquipmentCategory {
    public static void main(String[] args) {
        String data = """
                INSERT INTO `equipment_categories` (`id`, `name`, `alias`, `group_id`, `note`) VALUES
                	(1, 'Thiết bị phụ trợ chẩn đoán hình ảnh', 'PTCĐHA', 1, ''),
                	(2, 'Máy X Quang', 'MXQ', 1, ''),
                	(3, 'Máy siêu âm', 'MSA', 1, ''),
                	(4, 'Hệ thống chụp mạch số hóa xóa nền (DSA)', 'DSA', 1, ''),
                	(5, 'Hệ thống chụp Cộng hưởng từ', 'CHT', 1, ''),
                	(6, 'Hệ thống CT - Scanner', 'CT/SCANNER', 1, ''),
                	(7, 'Hệ thống/ Thiết bị hồi sức khác', 'HT/TBK', 2, ''),
                	(8, 'Máy hút dịch', 'MHD', 2, ''),
                	(9, 'Máy thở', 'MT', 2, ''),
                	(10, 'Máy khí dung', 'MKD', 2, ''),
                	(11, 'Máy theo dõi bệnh nhân', 'MTDBN', 2, ''),
                	(13, 'Máy phá rung tim', 'PRT', 2, ''),
                	(14, 'Bơm tiêm điện', 'BTĐ', 2, ''),
                	(15, 'Giường cấp cứu hồi sức', 'GCCHS', 2, ''),
                	(16, 'Hệ thống tuần hoàn ngoài cơ thể ECMO', 'ECMO', 3, ''),
                	(17, 'Máy lọc màng bụng', 'MLMB', 3, ''),
                	(18, 'Máy lọc HDF online', 'HDF', 3, ''),
                	(19, 'Máy siêu lọc máu liên tục', 'MSLMLT', 3, ''),
                	(20, 'Máy thận nhân tạo', 'MTNT', 3, ''),
                	(21, 'Đèn mổ', 'ĐM', 4, ''),
                	(22, 'Máy đốt khối u', 'MĐKU', 4, ''),
                	(23, 'Kính hiển vi phẫu thuật', 'KHVPT', 4, ''),
                	(24, 'Hệ thống/Thiết bị khác', 'HT/TBK', 4, ''),
                	(25, 'Máy tán sỏi', 'MTS', 4, ''),
                	(26, 'Máy gây mê', 'MGM', 4, ''),
                	(27, 'Dao mổ', 'DM', 4, ''),
                	(28, 'Hệ thống phẫu thuật nội soi', 'HTPTNS', 4, ''),
                	(29, 'Bàn mổ', 'BM', 4, ''),
                	(30, 'Hệ thống gia tốc tuyến tính', 'HTGTTT', 5, ''),
                	(31, 'Hệ thống/ Thiết bị khác', 'HT/TBK', 5, ''),
                	(32, 'Hệ thống SPECT/CT', 'SPECT/CT', 5, ''),
                	(33, 'Thiết bị chuyên khoa Mắt', 'TBCKM', 6, ''),
                	(34, 'Thiết bị chuyên khoa Răng Hàm Mặt', 'TBCKRHM', 6, ''),
                	(35, 'Thiết bị chuyên khoa Tai Mũi Họng', 'TBCKTMH', 6, ''),
                	(36, 'Thiết bị phụ trợ', 'TBPT', 7, ''),
                	(37, 'Hệ thống/ Thiết bị khác', 'HT/TBK', 7, ''),
                	(38, 'Máy sắc ký', 'MSK', 7, ''),
                	(39, 'Kính hiển vi', 'KHV', 7, ''),
                	(40, 'Máy quang phổ', 'MQP', 7, ''),
                	(41, 'Thiết bị hỗ trợ sinh sản + Bảo quản mô', 'HTSS/BQM', 7, ''),
                	(42, 'Máy xét nghiệm huyết học', 'MXNHH', 7, ''),
                	(43, 'Thiết bị xét nghiệm vi sinh + sinh học phân tử + di truyền', 'XNVS/SH/DT', 7, ''),
                	(44, 'Máy ly tâm', 'MTL', 7, ''),
                	(45, 'Hệ thống Elisa', 'ELISA', 7, ''),
                	(46, 'Máy điện di', 'MĐD', 7, ''),
                	(47, 'Máy bảo quản lạnh', 'MBQL', 7, ''),
                	(48, 'Máy xét nghiệm sinh hóa, miễn dịch', 'XNSH/MD', 7, ''),
                	(49, 'Giải phẫu bệnh', 'GPB', 7, ''),
                	(50, 'Máy hấp tiệt trùng', 'MHTT', 8, ''),
                	(51, 'Máy tiệt trùng nhiệt độ thấp', 'MTTNDT', 8, ''),
                	(52, 'Hệ thống rửa khử khuẩn xe, giường Bệnh nhân', 'HTRKKXG', 8, ''),
                	(53, 'Hệ thống lọc nước RO', 'HTLNRO', 8, ''),
                	(54, 'Máy rửa khử khuẩn ống nội soi', 'RKKNS', 8, ''),
                	(55, 'Máy phun dung dịch khử khuẩn', 'MPDDKK', 8, ''),
                	(56, 'Máy rửa, khử khuẩn dụng cụ', 'MRKKDC', 8, ''),
                	(57, 'Máy rửa ống nội soi', 'MRNS', 8, ''),
                	(58, 'Máy sấy đồ vải', 'MSĐV', 8, ''),
                	(59, 'Máy lọc khử khuẩn không khí', 'MLKKKK', 8, ''),
                	(60, 'Máy giặt, vắt công nghiệp', 'MGVCN', 8, ''),
                	(61, 'Máy là quần áo', 'MLQA', 8, ''),
                	(62, 'Bể rửa dụng cụ bằng sóng siêu âm', 'RDCSSA', 8, ''),
                	(63, 'Tủ sấy dụng cụ', 'TSDC', 8, ''),
                	(64, 'Máy là ga công nghiệp', 'MLGCN', 8, ''),
                	(65, 'Bồn rửa tay vô trùng', 'BRTVT', 8, ''),
                	(66, 'Máy đóng gói, niêm phong túi', 'MĐG-NPT', 8, ''),
                	(67, 'Máy theo dõi sản khoa', 'MTDSK', 9, ''),
                	(68, 'Bàn đẻ', 'BĐ', 9, ''),
                	(69, 'Máy cắt đốt cổ tử cung', 'MCĐCTC', 9, ''),
                	(70, 'Máy áp lạnh cổ tử cung', 'MALCTC', 9, ''),
                	(71, 'Máy sưởi ấm trẻ sơ sinh', 'MSATSS', 9, ''),
                	(72, 'Giường hồi sức cấp cứu sơ sinh', 'GHSCCSS', 9, ''),
                	(73, 'Đèn chiếu vàng da', 'DĐCVD', 9, ''),
                	(74, 'Lồng ấp', 'LA', 9, ''),
                	(75, 'Lồng ấp di động', 'LADĐ', 9, ''),
                	(76, 'Bàn khám sản phụ khoa', 'BKSPK', 9, ''),
                	(77, 'Máy soi cổ tử cung', 'MSCTC', 9, ''),
                	(78, 'Máy đo huyết áp', 'MĐHA', 10, ''),
                	(79, 'Máy điện cơ', 'MĐC', 10, ''),
                	(80, 'Máy đo chức năng hô hấp', 'MĐCNHH', 10, ''),
                	(81, 'Máy điện tim gắng sức', 'MĐTGS', 10, ''),
                	(82, 'Máy đo huyết động xâm lấn', 'MĐHĐXL', 10, ''),
                	(83, 'Máy đo huyết động không xâm lấn', 'MĐHĐKXL', 10, ''),
                	(84, 'Máy thể tích ký toàn thân', 'MTTKTT', 10, ''),
                	(85, 'Máy Holter 24/24h (điện tim + huyết áp)', 'HOLTER', 10, ''),
                	(86, 'Máy đo niệu động học', 'MĐNĐH', 10, ''),
                	(87, 'Máy đo lưu huyết não', 'MĐLHN', 10, ''),
                	(88, 'Máy điện não', 'MĐN', 10, ''),
                	(89, 'Máy điện tim', 'MĐT', 10, ''),
                	(90, 'Máy đo chỉ số ABI và tốc độ sóng lan truyền', 'ABI&TĐSLT', 10, ''),
                	(91, 'Máy đo áp lực hậu môn trực tràng', 'MĐALHMTT', 10, ''),
                	(92, 'Nội soi chẩn đoán', 'NSCĐ', 11, ''),
                	(93, 'Bơm truyền dịch', 'BTD', 11, ''),
                	(94, 'Thiết bị phục hồi chức năng', 'TBPHCN', 12, ''),
                	(95, 'Hệ thống/ thiết bị khác', 'HT/TBK', 12, ''),
                	(96, 'Thiết bị vật lý trị liệu', 'TBVLTL', 12, ''),
                	(97, 'Hệ thống/ thiết bị khác', 'HT/TBK', 13, ''),
                	(98, 'Thiết bị nội thất bệnh viện', 'TBNVBT', 13, ''),
                	(99, 'Thiết bị phòng khám', 'TBPK', 14, '');
                                                """;
    }
}
