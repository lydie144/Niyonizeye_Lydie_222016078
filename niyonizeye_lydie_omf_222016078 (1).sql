-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 12:38 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `niyonizeye_lydie_omf_222016078`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteAttendee` (IN `p_attendeeID` INT)   BEGIN
    DELETE FROM attendees
    WHERE attendeeID = p_attendeeID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteStage` (IN `p_stageID` INT)   BEGIN
    DELETE FROM stages
    WHERE stageID = p_stageID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayArtists` ()   BEGIN
    SELECT * FROM artists;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayAttendees` ()   BEGIN
    SELECT * FROM attendees;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayFestivals` ()   BEGIN
    SELECT * FROM festivals;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayPerformances` ()   BEGIN
    SELECT * FROM performances;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplaySchedule` ()   BEGIN
    SELECT * FROM schedule;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayStages` ()   BEGIN
    SELECT * FROM stages;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayTickets` ()   BEGIN
    SELECT * FROM tickets;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertArtist` (IN `p_artist_name` VARCHAR(255), IN `p_genre` VARCHAR(255), IN `p_website` VARCHAR(255), IN `p_contactemail` VARCHAR(255))   BEGIN
    INSERT INTO artists (artist_name, genre, website, contactemail)
    VALUES (p_artist_name, p_genre, p_website, p_contactemail);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertAttendee` (IN `p_first_name` VARCHAR(255), IN `p_last_name` VARCHAR(255), IN `p_email` VARCHAR(255), IN `p_other_column` VARCHAR(255))   BEGIN
    INSERT INTO attendees (first_name, last_name, email, other_column)
    VALUES (p_first_name, p_last_name, p_email, p_other_column);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertFestival` (IN `p_festival_name` VARCHAR(255), IN `p_location` VARCHAR(255), IN `p_start_date` DATE, IN `p_other_column` VARCHAR(255))   BEGIN
    INSERT INTO festivals (festival_name, location, start_date, other_column)
    VALUES (p_festival_name, p_location, p_start_date, p_other_column);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertPerformance` (IN `p_artist_id` INT, IN `p_stage_id` INT, IN `p_performance_date` DATE, IN `p_other_column` VARCHAR(255))   BEGIN
    INSERT INTO performances (artist_id, stage_id, performance_date, other_column)
    VALUES (p_artist_id, p_stage_id, p_performance_date, p_other_column);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertSchedule` (IN `p_performanceID` INT, IN `p_stageID` INT, IN `p_start_time` DATETIME, IN `p_other_column` VARCHAR(255))   BEGIN
    INSERT INTO schedule (performanceID, stageID, start_time, other_column)
    VALUES (p_performanceID, p_stageID, p_start_time, p_other_column);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertStage` (IN `p_festivalID` INT, IN `p_name` VARCHAR(255), IN `p_capital` DECIMAL(10,2))   BEGIN
    INSERT INTO stages (festivalID, name, capital)
    VALUES (p_festivalID, p_name, p_capital);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertTicket` (IN `p_eventID` INT, IN `p_ticket_type` VARCHAR(255), IN `p_price` DECIMAL(10,2), IN `p_other_column` VARCHAR(255))   BEGIN
    INSERT INTO tickets (eventID, ticket_type, price, other_column)
    VALUES (p_eventID, p_ticket_type, p_price, p_other_column);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateFestival` (IN `p_festivalID` INT, IN `p_new_festival_name` VARCHAR(255), IN `p_new_location` VARCHAR(255), IN `p_new_start_date` DATE, IN `p_new_other_column` VARCHAR(255))   BEGIN
    UPDATE festivals
    SET
        festival_name = p_new_festival_name,
        location = p_new_location,
        start_date = p_new_start_date,
        other_column = p_new_other_column
    WHERE festivalID = p_festivalID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateTicket` (IN `p_ticketID` INT, IN `p_new_eventID` INT, IN `p_new_ticket_type` VARCHAR(255), IN `p_new_price` DECIMAL(10,2), IN `p_new_other_column` VARCHAR(255))   BEGIN
    UPDATE tickets
    SET
        eventID = p_new_eventID,
        ticket_type = p_new_ticket_type,
        price = p_new_price,
        other_column = p_new_other_column
    WHERE ticketID = p_ticketID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ViewFestivalPerformancesWithArtists` ()   BEGIN
    SELECT p.performance_name, p.start_time, a.artist_name
    FROM performances p
    JOIN (
        SELECT artist_id, artist_name
        FROM artists
    ) a
    ON p.artist_id = a.artist_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ViewTicketsWithArtists` ()   BEGIN
    SELECT t.*, a.artist_name
    FROM tickets t
    JOIN artists a ON t.artist_id = a.artist_id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `artists`
--

CREATE TABLE `artists` (
  `ArtistID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Genre` varchar(255) DEFAULT NULL,
  `Website` varchar(255) DEFAULT NULL,
  `ContactEmail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`ArtistID`, `Name`, `Genre`, `Website`, `ContactEmail`) VALUES
(1, 'John Doe', 'Pop', 'http://www.johndoe.com', 'johndoe@email.com'),
(2, 'ishimwe adelas', 'rock', 'http://www.ishimweadelas.com', 'ishimweadelas@email.com');

--
-- Triggers `artists`
--
DELIMITER $$
CREATE TRIGGER `AfterUpdateartist` AFTER UPDATE ON `artists` FOR EACH ROW BEGIN

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_delete_artist` AFTER DELETE ON `artists` FOR EACH ROW BEGIN
    
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_artist` AFTER UPDATE ON `artists` FOR EACH ROW BEGIN
    
    
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `attendees`
--

CREATE TABLE `attendees` (
  `AttendeeID` int(11) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Phone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendees`
--

INSERT INTO `attendees` (`AttendeeID`, `FirstName`, `LastName`, `Email`, `Phone`) VALUES
(30, 'Ella', 'gisubizo', 'gisu@gmail.com', '78889996'),
(31, 'adela', 'murenzi', 'murenzi@gmail.com', '7889921');

--
-- Triggers `attendees`
--
DELIMITER $$
CREATE TRIGGER `after_delete_attendee` AFTER DELETE ON `attendees` FOR EACH ROW BEGIN
    
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `festivals`
--

CREATE TABLE `festivals` (
  `FestivalID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  `Organizer` varchar(255) DEFAULT NULL,
  `TicketPrice` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `festivals`
--

INSERT INTO `festivals` (`FestivalID`, `Name`, `Location`, `StartDate`, `EndDate`, `Organizer`, `TicketPrice`) VALUES
(10, 'English', 'gicumbi', '0000-00-00', '0000-00-00', 'producer', 1000.00),
(11, 'ishimwe lyne', 'rubavu', '2022-01-01', '2022-04-04', 'producer', 2000.00);

--
-- Triggers `festivals`
--
DELIMITER $$
CREATE TRIGGER `AfterUpdatefestival` AFTER UPDATE ON `festivals` FOR EACH ROW BEGIN

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_festival_date` BEFORE UPDATE ON `festivals` FOR EACH ROW BEGIN
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `festivals_view`
--

CREATE TABLE `festivals_view` (
  `FestivalID` int(11) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  `Organizer` varchar(255) DEFAULT NULL,
  `TicketPrice` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `performances`
--

CREATE TABLE `performances` (
  `PerformanceID` int(11) NOT NULL,
  `FestivalID` int(11) DEFAULT NULL,
  `ArtistID` int(11) DEFAULT NULL,
  `PerformanceDate` date DEFAULT NULL,
  `StartTime` time DEFAULT NULL,
  `Duration` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `performances`
--

INSERT INTO `performances` (`PerformanceID`, `FestivalID`, `ArtistID`, `PerformanceDate`, `StartTime`, `Duration`) VALUES
(20, 10, 1, '2023-03-01', '00:20:23', 10),
(21, 11, 2, '2023-02-01', '00:20:23', 5);

--
-- Triggers `performances`
--
DELIMITER $$
CREATE TRIGGER `after_update_performance` AFTER UPDATE ON `performances` FOR EACH ROW BEGIN
    
    
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_performance_date` BEFORE UPDATE ON `performances` FOR EACH ROW BEGIN
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `performances_view`
--

CREATE TABLE `performances_view` (
  `PerformanceID` int(11) DEFAULT NULL,
  `FestivalID` int(11) DEFAULT NULL,
  `ArtistID` int(11) DEFAULT NULL,
  `PerformanceDate` date DEFAULT NULL,
  `StartTime` time DEFAULT NULL,
  `Duration` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `ScheduleID` int(11) NOT NULL,
  `PerformanceID` int(11) DEFAULT NULL,
  `StageID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`ScheduleID`, `PerformanceID`, `StageID`) VALUES
(51, 21, 41);

-- --------------------------------------------------------

--
-- Table structure for table `schedule_view`
--

CREATE TABLE `schedule_view` (
  `ScheduleID` int(11) DEFAULT NULL,
  `PerformanceID` int(11) DEFAULT NULL,
  `StageID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stages`
--

CREATE TABLE `stages` (
  `StageID` int(11) NOT NULL,
  `FestivalID` int(11) DEFAULT NULL,
  `Name` varchar(255) NOT NULL,
  `Capacity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stages`
--

INSERT INTO `stages` (`StageID`, `FestivalID`, `Name`, `Capacity`) VALUES
(40, 11, 'ngoga inncocent', 23),
(41, 10, 'rukundo kelly', 20);

--
-- Triggers `stages`
--
DELIMITER $$
CREATE TRIGGER `AfterInsertstage` AFTER INSERT ON `stages` FOR EACH ROW BEGIN
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AfterUpdatestage` AFTER UPDATE ON `stages` FOR EACH ROW BEGIN

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `stages_view`
--

CREATE TABLE `stages_view` (
  `StageID` int(11) DEFAULT NULL,
  `FestivalID` int(11) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Capacity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE `tickets` (
  `TicketID` int(11) NOT NULL,
  `AttendeeID` int(11) DEFAULT NULL,
  `FestivalID` int(11) DEFAULT NULL,
  `PurchaseDate` date DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tickets`
--

INSERT INTO `tickets` (`TicketID`, `AttendeeID`, `FestivalID`, `PurchaseDate`, `Price`) VALUES
(61, 31, 11, '2023-05-08', 1100.00),
(62, 31, 11, '2023-05-08', 1100.00);

--
-- Triggers `tickets`
--
DELIMITER $$
CREATE TRIGGER `AfterInsertticket` AFTER INSERT ON `tickets` FOR EACH ROW BEGIN
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AfterUpdatetickrt` AFTER UPDATE ON `tickets` FOR EACH ROW BEGIN

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tickets_view`
--

CREATE TABLE `tickets_view` (
  `TicketID` int(11) DEFAULT NULL,
  `AttendeeID` int(11) DEFAULT NULL,
  `FestivalID` int(11) DEFAULT NULL,
  `PurchaseDate` date DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
