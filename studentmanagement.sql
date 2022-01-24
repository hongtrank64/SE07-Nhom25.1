-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2022 at 07:25 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `studentID` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `root` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`studentID`, `username`, `password`, `root`) VALUES
('19000385', '19000385', '19000385', 2),
('19000390', '19000390', '19000390', 2),
('19000392', '19000392', '19000392', 2),
('19000394', '19000394', '19000394', 2),
('19000398', '19000398', '19000398', 2),
('19000402', '19000402', '19000402', 2),
('19000407', '19000407', '19000407', 2),
('19000412', '19000412', '19000412', 2),
('19000414', '19000414', '19000414', 2),
('19000416', '19000416', '19000416', 2),
('19000418', '19000418', '19000418', 2),
('19000421', '19000421', '19000421', 2),
('19000423', '19000423', '19000423', 2),
('19000425', '19000425', '19000425', 2),
('19000430', '19000430', '19000430', 2),
('19000432', '19000432', '19000432', 2),
('19000434', '19000434', '19000434', 2),
('19000437', '19000437', '19000437', 2),
('19000439', '19000439', '19000439', 2),
('19000441', '19000441', '19000441', 2),
('19000443', '19000443', '19000443', 2),
('19000446', '19000446', '19000446', 2),
('19000448', '19000448', '19000448', 2),
('19000450', '19000450', '19000450', 2),
('19000452', '19000452', '19000452', 2),
('19000454', '19000454', '19000454', 2),
('19000456', '19000456', '19000456', 2),
('19000458', '19000458', '19000458', 2),
('19000460', '19000460', '19000460', 2),
('19000462', '19000462', '19000462', 2),
('19000464', '19000464', '19000464', 2),
('19000466', '19000466', '19000466', 2),
('19000468', '19000468', '19000468', 2),
('19000471', '19000471', '19000471', 2),
('19000473', '19000473', '19000473', 2),
('19000475', '19000475', '19000475', 2),
('19000479', '19000479', '19000479', 2),
('19000484', '19000484', '19000484', 2),
('19000486', '19000486', '19000486', 2),
('19000488', '19000488', '19000488', 2),
('19000490', '19000490', '19000490', 2),
('19000492', '19000492', '19000492', 2),
('19000493', '19000493', '19000493', 2),
('19000496', '19000496', '19000496', 2),
('19000498 ', '19000498 ', '19000498 ', 2),
('19000501', '19000501', '19000501', 2),
('GV_123', 'admin', 'admin', 1);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `eventID` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `eventName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `timeStart` datetime NOT NULL,
  `timeEnd` datetime NOT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `requirement` tinyint(1) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`eventID`, `eventName`, `timeStart`, `timeEnd`, `address`, `requirement`, `status`) VALUES
('EV0001', 'Lớp tôi là số 1', '2021-02-10 10:30:28', '2021-03-15 20:30:28', 'Đại học Khoa học Tự Nhiên', 50, 1),
('EV0002', 'Sinh viên 5 tốt', '2021-09-20 08:00:00', '2021-12-20 23:59:59', 'Đại học Khoa học Tự Nhiên', 70, 0),
('EV0003', 'Cuộc thi tìm hiểu về biển đảo Việt Nam', '2020-03-26 07:00:00', '2020-04-10 23:59:59', 'Đại học Khoa học Tự Nhiên', 100, 0),
('EV0004', 'Cùng Hội Rèn luyện mỗi ngày', '2022-01-21 07:00:00', '2022-04-28 23:59:59', 'Đại học Khoa học Tự Nhiên', 50, 1),
('EV0005', 'Tìm hiểu Quy chế thi', '2022-01-14 07:00:00', '2022-01-25 23:59:59', 'Đại học Khoa học Tự Nhiên', 60, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentID` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `classroom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `GPA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentID`, `fullname`, `gender`, `birthday`, `address`, `classroom`, `email`, `phone`, `GPA`) VALUES
('19000385', 'Dương Tùng Anh', 'Nam', '2001-08-08', 'Hưng Yên', 'K64A4', 'duongtunganh_t64@hus.edu.vn', '0988489173', 1.6),
('19000390', 'Nguyễn Thị Hải Anh', 'Nữ', '2001-11-18', 'Hà Nội', 'K64A4', 'nguyenthihaianh_t64@hus.edu.vn', '0968847917', 2.6),
('19000392', 'Phạm Thị Lan Anh', 'Nữ', '2001-09-05', 'Thanh Hóa', 'K64A4', 'phamthilananh_t64@hus.edu.vn', '0389258110', 2.5),
('19000394', 'Nguyễn Ngọc Ánh', 'Nam', '2001-10-04', 'Phú Thọ', 'K64A4', 'nguyenngocanh_t64@hus.edu.vn', '0869949233', 2.9),
('19000398', 'Nguyễn Xuân Bình', 'Nam', '2001-02-22', 'Hải Dương', 'K64A4', 'nguyenxuanbinh_t64@hus.edu.vn', '0348342321', 2.1),
('19000402', 'Nguyễn Hà Doanh', 'Nam', '2001-08-04', 'Hà Nội', 'K64A4', 'nguyenhadoanh_t64@hus.edu.vn', '0852848555', 1.8),
('19000407', 'Nguyễn Ngọc Dũng', 'Nam', '2001-11-04', 'Sơn La', 'K64A4', 'nguyenngocdung_t64@hus.edu.vn', '0345678921', 2.4),
('19000412', 'Nguyễn Văn Đoàn', 'Nam', '2001-03-07', 'Nam Định', 'K64A4', 'nguyenvandoan_t64@hus.edu.vn', '0846818518', 2.3),
('19000414', 'Nguyễn Minh Đức', 'Nam', '2001-03-27', 'Thanh Hóa', 'K64A4', 'nguyenminhduc2_t64@hus.edu.vn', '0845661236', 2.7),
('19000416', 'Nguyễn Quốc Gia', 'Nam', '2001-01-05', 'Gia Lai', 'K64A4', 'nguyenquocgia_t64@hus.edu.vn', '0359659424', 2.3),
('19000418', 'Đinh Thị Hà', 'Nữ', '2001-10-01', 'Nghệ An', 'K64A4', 'dinhthiha_t64@hus.edu.vn', '0869622471', 2.4),
('19000421', 'Bùi Văn Hậu', 'Nam', '2001-12-18', 'Thái Bình', 'K64A4', 'buivanhau_t64@hus.edu.vn', '0979461201', 2.3),
('19000423', 'Nguyễn Long Hiệp', 'Nam', '2001-01-07', 'Phú Thọ', 'K64A4', 'nguyenlonghiep_t64@hus.edu.vn', '0397058319', 1.9),
('19000425', 'Vũ Đại Hiệp', 'Nam', '2001-07-26', 'Nam Định', 'K64A4', 'vudaihiep_t64@hus.edu.vn', '0944279858', 2),
('19000430', 'Nguyễn Minh Hoàng', 'Nam', '2001-10-18', 'Hưng Yên', 'K64A4', 'nguyenminhhoang_t64@hus.edu.vn', '0904072925', 2.6),
('19000432', 'Trần Thị Hồng', 'Nữ', '2001-06-23', 'Thái Nguyên', 'K64A4', 'tranthihong_t64@hus.edu.vn', '0396424058', 3.9),
('19000434', 'Lê Phạm Quang Huy', 'Nam', '2001-05-29', 'Hà Nội', 'K64A4', 'lephamquanghuy_t64@hus.edu.vn', '0582827794', 2.7),
('19000437', 'Võ Văn Huy', 'Nam', '2001-09-26', 'Hải Phòng', 'K64A4', 'vovanhuy_t64@hus.edu.vn', '0886831327', 2.8),
('19000439', 'Lương Thị Thu Hương', 'Nữ', '2001-12-24', 'Thái Bình', 'K64A4', 'luongthithuhuong_t64@hus.edu.vn', '0853216568', 2.6),
('19000441', 'Trần Quang Khai', 'Nam', '2001-06-07', 'Hưng Yên', 'K64A4', 'tranquangkhai_t64@hus.edu.vn', '0325576675', 2.8),
('19000443', 'Trần Hồng Lâm', 'Nam', '2001-06-20', 'Thanh Hóa', 'K64A4', 'tranhonglam_t64@hus.edu.vn', '0986717066', 2.8),
('19000446', 'Nguyễn Đức Lộc', 'Nam', '2001-05-08', 'Hải Dương', 'K64A4', 'nguyenducloc_t64@hus.edu.vn', '0392576167', 3.5),
('19000448', 'Đỗ Xuân Mạnh', 'Nam', '2001-01-29', 'Vĩnh Phúc', 'K64A4', 'doxuanmanh_t64@hus.edu.vn', '0354137873', 2.4),
('19000450', 'Đặng Đức Minh', 'Nam', '2001-06-15', 'Hưng Yên', 'K64A4', 'dangducminh_t64@hus.edu.vn ', '0984186215', 2.7),
('19000452', 'Nguyễn Hoài Nam', 'Nam', '0000-00-00', 'Hưng Yên', 'K64A4', 'nguyenhoainam_t64@hus.edu.vn', '0835290901', 2.1),
('19000454', 'Đặng Thị Kim Ngân', 'Nữ', '2001-08-31', 'Thái Bình', 'K64A4', 'dangthikimngan_t64@hus.edu.vn', '0982996740', 2.4),
('19000456', 'Vũ Thanh Ngọc', 'Nam', '2001-09-20', 'Thái Bình', 'K64A4', 'vuthanhngoc_t64@hus.edu.vn', '0865392409', 2.1),
('19000458', 'Nguyễn Anh Nguyễn', 'Nam', '2001-07-03', 'Hải Dương', 'K64A4', 'nguyenanhnguyen_t64@hus.edu.vn', '0365061470', 2.5),
('19000460', 'Hoàng Nghĩa Phong', 'Nam', '2001-07-01', 'Hà Nội', 'K64A4', 'hoangnghiaphong_t64@hus.edu.vn', '0983952421', 2.7),
('19000462', 'Đinh Trọng Phúc', 'Nam', '2001-07-26', 'Thái Bình', 'K64A4', 'dinhtrongphuc_t64@hus.edu.vn', '0384966335', 2.2),
('19000464', 'Đinh Hà Phương', 'Nữ', '2001-04-12', 'Bắc Giang', 'K64A4', 'dinhhaphuong_t64@hus.edu.vn', '0858799555', 2.5),
('19000466', 'Dương Văn Quang', 'Nam', '2001-02-20', 'Bắc Giang', 'K64A4', 'duongvanquang_t64@hus.edu.vn', '0375862154', 2.3),
('19000468', 'Nguyễn Minh Quang', 'Nam', '2001-01-24', 'Hưng Yên', 'K64A4', 'nguyenminhquang1_t64@hus.edu.vn', '0352531054', 2.6),
('19000471', 'Tạ Anh Quân', 'Nam', '2001-03-30', 'Hà Nội', 'K64A4', 'taanhquan_t64@hus.edu.vn', '0902034224', 2.5),
('19000473', 'Nguyễn Đức Sơn', 'Nam', '2001-01-29', 'Hải Dương', 'K64A4', 'tranducson_t64@hus.edu.vn', '0343131785', 2.1),
('19000475', 'Trần Thái Sơn', 'Nam', '2001-01-18', 'Hà Nội', 'K64A4', 'tranthaison_t64@hus.edu.vn', '0326115632', 3.4),
('19000479', 'Phan Anh Tiến', 'Nam', '2001-11-17', 'Hà Nội', 'K64A4', 'phananhtien_t64@hus.edu.vn', '0214555824', 1.7),
('19000484', 'Phan Anh Tùng', 'Nam', '2001-01-24', 'Hà Nội', 'K64A4', 'phananhtung_t64@hus.edu.vn', '0356485558', 1.8),
('19000486', 'Đỗ Ánh Tuyết', 'Nữ', '2001-01-06', 'Hà Nội', 'K64A4', 'doanhtuyet_t64@hus.edu.vn', '0858383316', 2.8),
('19000488', 'Ngô Phương Thảo', 'Nữ', '2001-10-14', 'Thái Bình', 'K64A4', 'ngophuongthao_t64@hus.edu.vn', '0838806829', 2.4),
('19000490', 'Đặng Thị Phương Thúy', 'Nữ', '2001-11-14', 'Bắc Giang', 'K64A4', 'dangthiphuongthuy_t64@hus.edu.vn', '0396934105', 2.6),
('19000492', 'Phạm Xuân Thường', 'Nam', '2001-08-31', 'Hà Nam', 'K64A4', 'phamxuanthuong_t64@hus.edu.vn', '0348342321', 2.1),
('19000493', 'Nguyễn Thị Tháo Trang', 'Nữ', '2001-09-07', 'Bắc Giang', 'K64A4', 'nguyenthithaotrang_t64@hus.edu.vn', '0398635001', 2),
('19000496', 'Đỗ Bảo Trung', 'Nam', '2001-10-28', 'Nam Định', 'K64A4', 'dobaotrung_t64@hus.edu.vn', '0961339458', 2.3),
('19000498', 'Nguyễn Quang Trường', 'Nam', '2001-12-06', 'Quảng Ninh', 'K64A4', 'nguyenquangtruong_t64@hus.edu.vn', '0327905386', 2);

-- --------------------------------------------------------

--
-- Table structure for table `studentsubject`
--

CREATE TABLE `studentsubject` (
  `studentID` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `subjectCode` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `studentsubject`
--

INSERT INTO `studentsubject` (`studentID`, `subjectCode`, `status`) VALUES
('19000385', 'MAT3543', 1),
('19000385', 'MAT3550E', 1),
('19000385', 'MAT3553E', 1),
('19000385', 'MAT3559', 0),
('19000390', 'MAT2034', 1),
('19000390', 'MAT3376', 0),
('19000390', 'MAT3543', 1),
('19000390', 'MAT3553E', 1),
('19000390', 'PES1015', 0),
('19000392', 'MAT2034', 1),
('19000392', 'MAT3376', 0),
('19000392', 'MAT3541E', 1),
('19000392', 'MAT3553E', 1),
('19000394', 'MAT3376', 0),
('19000394', 'MAT3543', 1),
('19000394', 'MAT3550E', 1),
('19000394', 'MAT3559', 0),
('19000394', 'PES1015', 0),
('19000398', 'MAT2034', 1),
('19000398', 'MAT3541E', 1),
('19000398', 'MAT3543', 1),
('19000398', 'PES1015', 0),
('19000402', 'MAT2034', 1),
('19000402', 'MAT3376', 0),
('19000402', 'MAT3543', 1),
('19000402', 'MAT3553E', 1),
('19000402', 'PES1015', 0),
('19000407', 'MAT2034', 1),
('19000407', 'MAT3376', 0),
('19000407', 'MAT3543', 1),
('19000407', 'MAT3550E', 1),
('19000407', 'PES1015', 0),
('19000412', 'MAT3541E', 1),
('19000412', 'MAT3543', 1),
('19000412', 'MAT3553E', 1),
('19000414', 'MAT3376', 0),
('19000414', 'MAT3543', 1),
('19000414', 'MAT3550E', 1),
('19000414', 'MAT3553E', 1),
('19000414', 'MAT3559', 0),
('19000416', 'MAT3541E', 1),
('19000416', 'PES1015', 0);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subjectCode` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `subjectTitle` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `credits` int(11) NOT NULL,
  `teacherName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `room` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `timeStart` int(11) NOT NULL,
  `timeEnd` int(11) NOT NULL,
  `day` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `semester` int(11) NOT NULL,
  `year` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subjectCode`, `subjectTitle`, `credits`, `teacherName`, `type`, `room`, `timeStart`, `timeEnd`, `day`, `semester`, `year`) VALUES
('MAT2034', 'Giải tích số', 3, 'Nguyễn Trung Hiếu', '1', '302T5', 1, 2, 'T6', 1, '3'),
('MAT3376', 'Lập trình nâng cao', 2, 'Ngô Thế Quyền', '0', '513T5', 6, 7, 'T4', 1, '3'),
('MAT3541E', 'Nguyên lí các ngôn ngữ lập trình', 3, 'Nguyễn Thị Minh Huyền', '1', '513T4', 9, 10, 'T5', 1, '3'),
('MAT3543', 'Công nghệ phần mềm', 3, 'Bùi Sỹ Nguyên', '1', '302T5', 4, 5, 'T3', 1, '3'),
('MAT3550E', 'Nguyên lí Hệ điều hành', 4, 'Hoàng Quốc Hùng', '1', '508T5', 1, 2, 'T2', 1, '3'),
('MAT3553E', 'Nhập môn Trí tuệ nhân tạo', 4, 'Đỗ Trung Tuấn', '1', '512T4', 1, 2, 'T4', 1, '3'),
('MAT3559', 'Xây dựng hệ thống nhúng', 2, 'Lê Quang Thảo', 'Vật lí', '108T3', 6, 8, 'T3', 1, '3'),
('PES1015', 'Bóng chuyền 1', 1, 'Nguyễn Thị Kim Chi', 'Thể chất', 'KTX Mễ Trì', 6, 8, 'T6', 1, '3');

-- --------------------------------------------------------

--
-- Table structure for table `trainingscores`
--

CREATE TABLE `trainingscores` (
  `studentID` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `sem_year` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `scores` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `trainingscores`
--

INSERT INTO `trainingscores` (`studentID`, `sem_year`, `scores`) VALUES
('19000385', '2019_1', 78),
('19000385', '2019_2', 76),
('19000385', '2020_1', 74),
('19000385', '2020_2', 80),
('19000390', '2019_1', 92),
('19000390', '2019_2', 94),
('19000390', '2020_1', 94),
('19000390', '2020_2', 94),
('19000392', '2019_1', 82),
('19000392', '2019_2', 85),
('19000392', '2020_1', 78),
('19000392', '2020_2', 81),
('19000394', '2019_1', 76),
('19000394', '2019_2', 82),
('19000394', '2020_1', 79),
('19000394', '2020_2', 80),
('19000398', '2019_1', 85),
('19000398', '2019_2', 84),
('19000398', '2020_1', 82),
('19000398', '2020_2', 94);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`studentID`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`eventID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentID`);

--
-- Indexes for table `studentsubject`
--
ALTER TABLE `studentsubject`
  ADD PRIMARY KEY (`studentID`,`subjectCode`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subjectCode`);

--
-- Indexes for table `trainingscores`
--
ALTER TABLE `trainingscores`
  ADD PRIMARY KEY (`studentID`,`sem_year`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`studentID`) REFERENCES `account` (`studentID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
