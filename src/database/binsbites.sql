-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2025 at 06:02 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `binsbites`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `c_id` int(11) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `c_number` varchar(255) NOT NULL,
  `cpass` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `profile_picture` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`c_id`, `fname`, `lname`, `email`, `c_number`, `cpass`, `type`, `status`, `profile_picture`) VALUES
(1, 'afsfasf', 'asfagSF', 'ASFAS@TASF', '12312312312', '123456789', 'Customer', 'Pending', ''),
(2, 'Louigie', 'Borja', 'Admin', '0985512345', 'Admin123', 'Admin', 'Active', ''),
(3, 'Arl', 'Unlan', 'Arl@gmail.com', '12312312312', '1234567890', 'Customer', 'Active', 'user_data/pfpimage/1747744601589_screenshot 2025-04-10 083107.png'),
(4, 'asdsdasf', 'asfasfaf', 'Hehe@gmail.com', '12312312312', '123456789', 'Customer', 'Pending', ''),
(5, 'Arl', 'Sison', 'Arlnaygams@gmail.com', '123456789', '123456789', 'Customer', 'Pending', ''),
(6, 'arl', 'la', 'arlnaygams@gmail.coo', '1234567890', '123456789', 'Customer', 'Pending', ''),
(7, 'arl', 'arl', 'arl@gmail.com', '123123123123', '123456789', 'Customer', 'Pending', 'user_data/pfpimage/1747744601589_screenshot 2025-04-10 083107.png'),
(8, 'asdasd', 'asdasd', 'arl@gmail.com', '123', '123123123', 'Customer', 'Pending', 'user_data/pfpimage/1747744601589_screenshot 2025-04-10 083107.png'),
(9, 'asd', 'asd', 'arl@gmail.com', '123', '12345678', 'Customer', 'Pending', 'user_data/pfpimage/1747744601589_screenshot 2025-04-10 083107.png'),
(10, 'arl', 'sison', 'arlnaygams@gmail.com', '12', '12345678', 'Customer', 'Active', ''),
(11, 'Janeyxx', 'Exhavez', 'Janey@gmail.com', '12312312312', '123123123', 'Customer', 'Active', ''),
(12, 'Customer', 'Customer', 'Customer', '12312312312', '123123123', 'Customer', 'Active', ''),
(13, 'sdfasdf', 'asdfas', 'asdas@gmail.com', '12312312', '123123123', 'Customer', 'Pending', NULL),
(14, 'angelo', 'quisombing', 'gelo@gmail.com', '12312332', '123123123', 'Customer', 'Pending', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `action` text NOT NULL,
  `action_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `r_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `t_id` int(11) NOT NULL,
  `reservation_date` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`r_id`, `u_id`, `t_id`, `reservation_date`, `address`, `status`) VALUES
(3, 3, 1, '2020-04-24', 'talsiay', 'Pending'),
(4, 3, 1, '2020-04-25', 'bisag asa', 'Pending'),
(5, 3, 1, '2020-05-24', 'Talisay', 'Pending'),
(6, 3, 1, '2020-04-25', 'Inyu', 'Pending'),
(7, 3, 1, '2020-04-25', 'Inyu', 'Pending'),
(8, 3, 1, '2025-05-25', 'tatata', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `seating`
--

CREATE TABLE `seating` (
  `t_id` int(11) NOT NULL,
  `seaters` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `seating`
--

INSERT INTO `seating` (`t_id`, `seaters`, `status`) VALUES
(1, '8 seaters', 'Occupied'),
(2, '10 seaters', 'Available');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`r_id`),
  ADD KEY `u_id` (`u_id`),
  ADD KEY `t_id` (`t_id`);

--
-- Indexes for table `seating`
--
ALTER TABLE `seating`
  ADD PRIMARY KEY (`t_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `c_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `r_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `seating`
--
ALTER TABLE `seating`
  MODIFY `t_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `customer` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `seating` (`t_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `customer` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
