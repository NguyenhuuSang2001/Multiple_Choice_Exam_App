-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 29, 2021 lúc 02:07 PM
-- Phiên bản máy phục vụ: 10.1.36-MariaDB
-- Phiên bản PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `app_choose`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `answer`
--

CREATE TABLE `answer` (
  `ID` int(11) NOT NULL,
  `QuestionID` int(11) NOT NULL,
  `Content` text NOT NULL,
  `IsCorrect` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `answer`
--

INSERT INTO `answer` (`ID`, `QuestionID`, `Content`, `IsCorrect`) VALUES
(24, 5, '-1', 1),
(25, 5, '2', 0),
(26, 5, '3', 0),
(27, 5, '4', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `history`
--

CREATE TABLE `history` (
  `ID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `TestID` int(11) NOT NULL,
  `DateFinish` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Point` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `history`
--

INSERT INTO `history` (`ID`, `UserID`, `TestID`, `DateFinish`, `Point`) VALUES
(3, 5, 8, '2021-11-27 18:51:42', 10),
(4, 4, 1, '2021-11-27 18:52:03', 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `infortest`
--

CREATE TABLE `infortest` (
  `ID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Topic` varchar(50) NOT NULL,
  `Publish` tinyint(1) NOT NULL DEFAULT '1',
  `DateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `infortest`
--

INSERT INTO `infortest` (`ID`, `UserID`, `Name`, `Topic`, `Publish`, `DateCreate`) VALUES
(1, 3, 'kt 1 tiết ', 'Toán', 1, '2021-11-24 19:01:00'),
(2, 3, 'Kt 30 phút ', 'Văn ', 1, '2021-11-24 19:01:43'),
(3, 4, 'kt 1 tiết ', 'Toán', 1, '2021-11-24 19:02:17'),
(7, 5, 'kt 1 tiet', 'english', 1, '2021-11-27 18:41:06'),
(8, 5, 'kt', 'e', 1, '2021-11-27 18:43:08'),
(9, 4, 'kt1 ', 'n', 1, '2021-11-27 19:34:55'),
(10, 4, 'Kt 30 phút ', 'Văn ', 0, '2021-11-29 03:53:43');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `question`
--

CREATE TABLE `question` (
  `ID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `Topic` varchar(50) NOT NULL,
  `Content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `question`
--

INSERT INTO `question` (`ID`, `UserID`, `Topic`, `Content`) VALUES
(2, 3, 'Toán', '3+4'),
(5, 5, 'Toan', '4-5');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `testdetail`
--

CREATE TABLE `testdetail` (
  `TestID` int(11) NOT NULL,
  `QuestionID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `testdetail`
--

INSERT INTO `testdetail` (`TestID`, `QuestionID`) VALUES
(1, 5),
(2, 5),
(1, 2),
(7, 5),
(8, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Pass` varchar(50) NOT NULL,
  `IsAdmin` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`ID`, `Name`, `Pass`, `IsAdmin`) VALUES
(1, 'huyen', '12345', 1),
(2, 'sang', '123456a@', 1),
(3, 'bong', '1234', 0),
(4, 'hang', '123', 0),
(5, 'h', '123', 0),
(11, 'hu', '123', 0),
(13, 'ha', '123', 0),
(14, 'trang', '123', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `QuestionID` (`QuestionID`);

--
-- Chỉ mục cho bảng `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TestID` (`TestID`),
  ADD KEY `UserID` (`UserID`);

--
-- Chỉ mục cho bảng `infortest`
--
ALTER TABLE `infortest`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `UserID` (`UserID`);

--
-- Chỉ mục cho bảng `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `UserID` (`UserID`);

--
-- Chỉ mục cho bảng `testdetail`
--
ALTER TABLE `testdetail`
  ADD KEY `QuestionID` (`QuestionID`),
  ADD KEY `TestID` (`TestID`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`,`Name`),
  ADD UNIQUE KEY `Name` (`Name`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `answer`
--
ALTER TABLE `answer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT cho bảng `history`
--
ALTER TABLE `history`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `infortest`
--
ALTER TABLE `infortest`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `question`
--
ALTER TABLE `question`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`QuestionID`) REFERENCES `question` (`ID`);

--
-- Các ràng buộc cho bảng `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`TestID`) REFERENCES `infortest` (`ID`),
  ADD CONSTRAINT `history_ibfk_3` FOREIGN KEY (`UserID`) REFERENCES `user` (`ID`);

--
-- Các ràng buộc cho bảng `infortest`
--
ALTER TABLE `infortest`
  ADD CONSTRAINT `inforTest_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`ID`);

--
-- Các ràng buộc cho bảng `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`ID`);

--
-- Các ràng buộc cho bảng `testdetail`
--
ALTER TABLE `testdetail`
  ADD CONSTRAINT `testDetail_ibfk_1` FOREIGN KEY (`QuestionID`) REFERENCES `question` (`ID`),
  ADD CONSTRAINT `testDetail_ibfk_2` FOREIGN KEY (`TestID`) REFERENCES `infortest` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
