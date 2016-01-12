-- MySQL dump 10.13  Distrib 5.7.10, for osx10.9 (x86_64)
--
-- Host: localhost    Database: db_restaurant
-- ------------------------------------------------------
-- Server version	5.7.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login_info`
--

DROP TABLE IF EXISTS `login_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_info` (
  `userId` int(11) NOT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `userType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_info`
--

LOCK TABLES `login_info` WRITE;
/*!40000 ALTER TABLE `login_info` DISABLE KEYS */;
INSERT INTO `login_info` VALUES (1,'ssk','abcd','owner'),(2,NULL,NULL,'customer');
/*!40000 ALTER TABLE `login_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reserveDate` varchar(25) NOT NULL,
  `reserveTime` varchar(25) DEFAULT NULL,
  `noOfPeople` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  `tableNo` int(11) DEFAULT NULL,
  `customerName` varchar(75) NOT NULL,
  `customerPhone` varchar(20) NOT NULL,
  `customerEmail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId_idx` (`customerName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,'12-15-2015','12:15 pm',4,'reserved',1,'1','',NULL),(2,'12-25-2015','12.45 pm',6,'closed',2,'3','',NULL),(3,'12-28-2015','08:15 pm',8,'reserved',6,'Joshua Karnel','333-909-0989','jker@sd.com');
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_profile_settings`
--

DROP TABLE IF EXISTS `restaurant_profile_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_profile_settings` (
  `restId` int(11) NOT NULL AUTO_INCREMENT,
  `restName` varchar(45) DEFAULT NULL,
  `tagLine` varchar(45) DEFAULT NULL,
  `addrLine1` varchar(45) DEFAULT NULL,
  `addrLine2` varchar(45) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `zipCode` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `autoAssign` tinyint(1) DEFAULT NULL,
  `openCloseDetails` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`restId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_profile_settings`
--

LOCK TABLES `restaurant_profile_settings` WRITE;
/*!40000 ALTER TABLE `restaurant_profile_settings` DISABLE KEYS */;
INSERT INTO `restaurant_profile_settings` VALUES (1,'Draksha - Bar & Grill','the sizzling way','4250 Fox Valley Cente',NULL,'Aurora','IL','60504','898-090-989','draksha@gmail.com',1,NULL),(3,'Kolhapuri Zataka','tarredar','1121 tall grass rd',NULL,'Naperville','IL','60504','898-090-989','draksha@gmail.com',1,NULL);
/*!40000 ALTER TABLE `restaurant_profile_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_details`
--

DROP TABLE IF EXISTS `table_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_details` (
  `id` int(11) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_details`
--

LOCK TABLES `table_details` WRITE;
/*!40000 ALTER TABLE `table_details` DISABLE KEYS */;
INSERT INTO `table_details` VALUES (1,2),(2,4),(3,4),(4,6),(5,6),(6,8),(7,8),(8,2),(9,4),(10,6);
/*!40000 ALTER TABLE `table_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `userType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'shama','bhosale','388-090-9889','sk@hjd.com',NULL,'owner'),(2,'Jessie','Buck','776-098-9121','jb@yahoo.com',NULL,'customer'),(3,'John','Groppe','123-323-3343','jgroppe@yahoo.com',NULL,'customer'),(4,'Ron','Richards','454-5676-9087','rrichard@mac.com',NULL,'customer'),(5,'Krista','Burndine','898-333-2322',NULL,NULL,'customer'),(6,NULL,NULL,NULL,NULL,NULL,'customer');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-11 23:17:59
