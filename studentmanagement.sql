-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2022 at 03:50 PM
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
  `timeStart` date NOT NULL,
  `timeEnd` date NOT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `requirement` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`eventID`, `eventName`, `timeStart`, `timeEnd`, `address`, `requirement`, `status`) VALUES
('EV0001', 'L???p t??i l?? s??? 1', '2021-02-10', '2021-03-15', '?????i h???c Khoa h???c T??? Nhi??n', 50, 1),
('EV0002', 'Sinh vi??n 5 t???t', '2021-09-20', '2021-12-20', '?????i h???c Khoa h???c T??? Nhi??n', 70, 0),
('EV0003', 'Cu???c thi t??m hi???u v??? bi???n ?????o Vi???t Nam', '2020-03-26', '2020-04-10', '?????i h???c Khoa h???c T??? Nhi??n', 100, 0),
('EV0004', 'C??ng H???i R??n luy???n m???i ng??y', '2022-01-21', '2022-04-28', '?????i h???c Khoa h???c T??? Nhi??n', 50, 1),
('EV0005', 'T??m hi???u Quy ch??? thi', '2022-01-14', '2022-01-25', '?????i h???c Khoa h???c T??? Nhi??n', 60, 0),
('EV0006', 'K??? ho???ch A+', '2021-12-15', '2022-01-25', '?????i h???c Khoa h???c T??? Nhi??n', 40, 0);

-- --------------------------------------------------------

--
-- Table structure for table `money`
--

CREATE TABLE `money` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `money` double NOT NULL,
  `root` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `money`
--

INSERT INTO `money` (`id`, `name`, `money`, `root`) VALUES
(1, 'Q??y l???p', 1000000, 0),
(2, 'Th?????ng', 200000, 0),
(3, 'Mua hoa 20/11', 500000, 1),
(4, '???ng h??? thi??n tai', 100000, 1);

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
  `GPA` float NOT NULL,
  `position` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentID`, `fullname`, `gender`, `birthday`, `address`, `classroom`, `email`, `phone`, `GPA`, `position`) VALUES
('19000385', 'D????ng T??ng Anh', 'Nam', '2001-08-08', 'H??ng Y??n', 'K64A4', 'duongtunganh_t64@hus.edu.vn', '0988489173', 1.6, 0),
('19000390', 'Nguy???n Th??? H???i Anh', 'N???', '2001-11-18', 'H?? N???i', 'K64A4', 'nguyenthihaianh_t64@hus.edu.vn', '0968847917', 2.6, 1),
('19000392', 'Ph???m Th??? Lan Anh', 'N???', '2001-09-05', 'Thanh H??a', 'K64A4', 'phamthilananh_t64@hus.edu.vn', '0389258110', 2.5, 0),
('19000394', 'Nguy???n Ng???c ??nh', 'Nam', '2001-10-04', 'Ph?? Th???', 'K64A4', 'nguyenngocanh_t64@hus.edu.vn', '0869949233', 2.9, 0),
('19000398', 'Nguy???n Xu??n B??nh', 'Nam', '2001-02-22', 'H???i D????ng', 'K64A4', 'nguyenxuanbinh_t64@hus.edu.vn', '0348342321', 2.1, 0),
('19000402', 'Nguy???n H?? Doanh', 'Nam', '2001-08-04', 'H?? N???i', 'K64A4', 'nguyenhadoanh_t64@hus.edu.vn', '0852848555', 1.8, 0),
('19000407', 'Nguy???n Ng???c D??ng', 'Nam', '2001-11-04', 'S??n La', 'K64A4', 'nguyenngocdung_t64@hus.edu.vn', '0345678921', 2.4, 0),
('19000412', 'Nguy???n V??n ??o??n', 'Nam', '2001-03-07', 'Nam ?????nh', 'K64A4', 'nguyenvandoan_t64@hus.edu.vn', '0846818518', 2.3, 0),
('19000414', 'Nguy???n Minh ?????c', 'Nam', '2001-03-27', 'Thanh H??a', 'K64A4', 'nguyenminhduc2_t64@hus.edu.vn', '0845661236', 2.7, 0),
('19000416', 'Nguy???n Qu???c Gia', 'Nam', '2001-01-05', 'Gia Lai', 'K64A4', 'nguyenquocgia_t64@hus.edu.vn', '0359659424', 2.3, 0),
('19000418', '??inh Th??? H??', 'N???', '2001-10-01', 'Ngh??? An', 'K64A4', 'dinhthiha_t64@hus.edu.vn', '0869622471', 2.4, 0),
('19000421', 'B??i V??n H???u', 'Nam', '2001-12-18', 'Th??i B??nh', 'K64A4', 'buivanhau_t64@hus.edu.vn', '0979461201', 2.3, 0),
('19000423', 'Nguy???n Long Hi???p', 'Nam', '2001-01-07', 'Ph?? Th???', 'K64A4', 'nguyenlonghiep_t64@hus.edu.vn', '0397058319', 1.9, 0),
('19000425', 'V?? ?????i Hi???p', 'Nam', '2001-07-26', 'Nam ?????nh', 'K64A4', 'vudaihiep_t64@hus.edu.vn', '0944279858', 2, 0),
('19000430', 'Nguy???n Minh Ho??ng', 'Nam', '2001-10-18', 'H??ng Y??n', 'K64A4', 'nguyenminhhoang_t64@hus.edu.vn', '0904072925', 2.6, 0),
('19000432', 'Tr???n Th??? H???ng', 'N???', '2001-06-23', 'Th??i Nguy??n', 'K64A4', 'tranthihong_t64@hus.edu.vn', '0396424058', 3.9, 0),
('19000434', 'L?? Ph???m Quang Huy', 'Nam', '2001-05-29', 'H?? N???i', 'K64A4', 'lephamquanghuy_t64@hus.edu.vn', '0582827794', 2.7, 0),
('19000437', 'V?? V??n Huy', 'Nam', '2001-09-26', 'H???i Ph??ng', 'K64A4', 'vovanhuy_t64@hus.edu.vn', '0886831327', 2.8, 0),
('19000439', 'L????ng Th??? Thu H????ng', 'N???', '2001-12-24', 'Th??i B??nh', 'K64A4', 'luongthithuhuong_t64@hus.edu.vn', '0853216568', 2.6, 0),
('19000441', 'Tr???n Quang Khai', 'Nam', '2001-06-07', 'H??ng Y??n', 'K64A4', 'tranquangkhai_t64@hus.edu.vn', '0325576675', 2.8, 0),
('19000443', 'Tr???n H???ng L??m', 'Nam', '2001-06-20', 'Thanh H??a', 'K64A4', 'tranhonglam_t64@hus.edu.vn', '0986717066', 2.8, 0),
('19000446', 'Nguy???n ?????c L???c', 'Nam', '2001-05-08', 'H???i D????ng', 'K64A4', 'nguyenducloc_t64@hus.edu.vn', '0392576167', 3.5, 0),
('19000448', '????? Xu??n M???nh', 'Nam', '2001-01-29', 'V??nh Ph??c', 'K64A4', 'doxuanmanh_t64@hus.edu.vn', '0354137873', 2.4, 0),
('19000450', '?????ng ?????c Minh', 'Nam', '2001-06-15', 'H??ng Y??n', 'K64A4', 'dangducminh_t64@hus.edu.vn ', '0984186215', 2.7, 0),
('19000452', 'Nguy???n Ho??i Nam', 'Nam', '0000-00-00', 'H??ng Y??n', 'K64A4', 'nguyenhoainam_t64@hus.edu.vn', '0835290901', 2.1, 0),
('19000454', '?????ng Th??? Kim Ng??n', 'N???', '2001-08-31', 'Th??i B??nh', 'K64A4', 'dangthikimngan_t64@hus.edu.vn', '0982996740', 2.4, 2),
('19000456', 'V?? Thanh Ng???c', 'Nam', '2001-09-20', 'Th??i B??nh', 'K64A4', 'vuthanhngoc_t64@hus.edu.vn', '0865392409', 2.1, 0),
('19000458', 'Nguy???n Anh Nguy???n', 'Nam', '2001-07-03', 'H???i D????ng', 'K64A4', 'nguyenanhnguyen_t64@hus.edu.vn', '0365061470', 2.5, 0),
('19000460', 'Ho??ng Ngh??a Phong', 'Nam', '2001-07-01', 'H?? N???i', 'K64A4', 'hoangnghiaphong_t64@hus.edu.vn', '0983952421', 2.7, 0),
('19000462', '??inh Tr???ng Ph??c', 'Nam', '2001-07-26', 'Th??i B??nh', 'K64A4', 'dinhtrongphuc_t64@hus.edu.vn', '0384966335', 2.2, 0),
('19000464', '??inh H?? Ph????ng', 'N???', '2001-04-12', 'B???c Giang', 'K64A4', 'dinhhaphuong_t64@hus.edu.vn', '0858799555', 2.5, 0),
('19000466', 'D????ng V??n Quang', 'Nam', '2001-02-20', 'B???c Giang', 'K64A4', 'duongvanquang_t64@hus.edu.vn', '0375862154', 2.3, 0),
('19000468', 'Nguy???n Minh Quang', 'Nam', '2001-01-24', 'H??ng Y??n', 'K64A4', 'nguyenminhquang1_t64@hus.edu.vn', '0352531054', 2.6, 0),
('19000471', 'T??? Anh Qu??n', 'Nam', '2001-03-30', 'H?? N???i', 'K64A4', 'taanhquan_t64@hus.edu.vn', '0902034224', 2.5, 0),
('19000473', 'Nguy???n ?????c S??n', 'Nam', '2001-01-29', 'H???i D????ng', 'K64A4', 'tranducson_t64@hus.edu.vn', '0343131785', 2.1, 0),
('19000475', 'Tr???n Th??i S??n', 'Nam', '2001-01-18', 'H?? N???i', 'K64A4', 'tranthaison_t64@hus.edu.vn', '0326115632', 3.4, 0),
('19000479', 'Phan Anh Ti???n', 'Nam', '2001-11-17', 'H?? N???i', 'K64A4', 'phananhtien_t64@hus.edu.vn', '0214555824', 1.7, 0),
('19000484', 'Phan Anh T??ng', 'Nam', '2001-01-24', 'H?? N???i', 'K64A4', 'phananhtung_t64@hus.edu.vn', '0356485558', 1.8, 0),
('19000486', '????? ??nh Tuy???t', 'N???', '2001-01-06', 'H?? N???i', 'K64A4', 'doanhtuyet_t64@hus.edu.vn', '0858383316', 2.8, 0),
('19000488', 'Ng?? Ph????ng Th???o', 'N???', '2001-10-14', 'Th??i B??nh', 'K64A4', 'ngophuongthao_t64@hus.edu.vn', '0838806829', 2.4, 0),
('19000490', '?????ng Th??? Ph????ng Th??y', 'N???', '2001-11-14', 'B???c Giang', 'K64A4', 'dangthiphuongthuy_t64@hus.edu.vn', '0396934105', 2.6, 0),
('19000492', 'Ph???m Xu??n Th?????ng', 'Nam', '2001-08-31', 'H?? Nam', 'K64A4', 'phamxuanthuong_t64@hus.edu.vn', '0348342321', 2.1, 0),
('19000493', 'Nguy???n Th??? Th??o Trang', 'N???', '2001-09-07', 'B???c Giang', 'K64A4', 'nguyenthithaotrang_t64@hus.edu.vn', '0398635001', 2, 0),
('19000496', '????? B???o Trung', 'Nam', '2001-10-28', 'Nam ?????nh', 'K64A4', 'dobaotrung_t64@hus.edu.vn', '0961339458', 2.3, 0),
('19000498', 'Nguy???n Quang Tr?????ng', 'Nam', '2001-12-06', 'Qu???ng Ninh', 'K64A4', 'nguyenquangtruong_t64@hus.edu.vn', '0327905386', 2, 0);

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
('MAT2034', 'Gi???i t??ch s???', 3, 'Nguy???n Trung Hi???u', '1', '302T5', 1, 2, 'T6', 1, '3'),
('MAT3376', 'L???p tr??nh n??ng cao', 2, 'Ng?? Th??? Quy???n', '0', '513T5', 6, 7, 'T4', 1, '3'),
('MAT3541E', 'Nguy??n l?? c??c ng??n ng??? l???p tr??nh', 3, 'Nguy???n Th??? Minh Huy???n', '1', '513T4', 9, 10, 'T5', 1, '3'),
('MAT3543', 'C??ng ngh??? ph???n m???m', 3, 'B??i S??? Nguy??n', '1', '302T5', 4, 5, 'T3', 1, '3'),
('MAT3550E', 'Nguy??n l?? H??? ??i???u h??nh', 4, 'Ho??ng Qu???c H??ng', '1', '508T5', 1, 2, 'T2', 1, '3'),
('MAT3553E', 'Nh???p m??n Tr?? tu??? nh??n t???o', 4, '????? Trung Tu???n', '1', '512T4', 1, 2, 'T4', 1, '3'),
('MAT3559', 'X??y d???ng h??? th???ng nh??ng', 2, 'L?? Quang Th???o', 'V???t l??', '108T3', 6, 8, 'T3', 1, '3'),
('PES1015', 'B??ng chuy???n 1', 1, 'Nguy???n Th??? Kim Chi', 'Th??? ch???t', 'KTX M??? Tr??', 6, 8, 'T6', 1, '3');

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
-- Indexes for table `money`
--
ALTER TABLE `money`
  ADD PRIMARY KEY (`id`);

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
