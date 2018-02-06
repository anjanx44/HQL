/*
SQLyog Community v12.5.1 (64 bit)
MySQL - 10.1.29-MariaDB : Database - Hql
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`Hql` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `Hql`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `address_line1` varchar(50) NOT NULL,
  `zipcode` varchar(10) NOT NULL,
  `city` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `par_ind` (`emp_id`),
  CONSTRAINT `fk_employee` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `address` */

insert  into `address`(`id`,`emp_id`,`address_line1`,`zipcode`,`city`) values 
(1,14,'BJIT','1212','Dhaka'),
(2,15,'aaaaaaaaaaaaa','1212','Dhaka'),
(3,16,'aaaaaaaaaaaaa','1212','Dhaka'),
(4,17,'aaaaaaaaaaaaa','1212','Dhaka'),
(5,18,'aaaaaaaaaaaaa','1212','Dhaka'),
(6,19,'aaaaaaaaaaaaa','1212','Dhaka'),
(7,20,'aaaaaaaaaaaaa','1212','Dhaka'),
(8,21,'aaaaaaaaaaaaa','1212','Dhaka'),
(9,22,'aaaaaaaaaaaaa','1212','Dhaka'),
(10,23,'aaaaaaaaaaaaa','1212','Dhaka'),
(11,24,'aaaaaaaaaaaaa','1212','Dhaka'),
(12,25,'aaaaaaaaaaaaa','1212','Dhaka'),
(13,26,'aaaaaaaaaaaaa','1212','Dhaka'),
(14,27,'aaaaaaaaaaaaa','1212','Dhaka'),
(15,28,'aaaaaaaaaaaaa','1212','Dhaka'),
(16,29,'aaaaaaaaaaaaa','1212','Dhaka'),
(17,30,'aaaaaaaaaaaaa','1212','Dhaka');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) NOT NULL,
  `emp_address` varchar(50) NOT NULL,
  `emp_mobile_nos` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

/*Data for the table `employee` */

insert  into `employee`(`id`,`emp_name`,`emp_address`,`emp_mobile_nos`) values 
(1,'Anjan','USA','121345'),
(2,'Anjan','USA','121345'),
(4,'Anjan','USA','121345'),
(5,'Anjan','USA','121345'),
(6,'Anjan','USA','121345'),
(7,'Anjan','USA','121345'),
(8,'Anjan','USA','121345'),
(9,'Anjan','USA','121345'),
(10,'Anjan','USA','121345'),
(11,'Anjan','USA','121345'),
(12,'Anjan','USA','121345'),
(13,'Anjan','USA','121345'),
(14,'Anjan','USA','121345'),
(15,'Anjan','USA','121345'),
(16,'Anjan','USA','121345'),
(17,'Anjan','USA','121345'),
(18,'Anjan','USA','121345'),
(19,'Anjan','USA','121345'),
(20,'Anjan','USA','121345'),
(21,'Anjan','USA','121345'),
(22,'Anjan','USA','121345'),
(23,'Anjan','USA','121345'),
(24,'Anjan','USA','121345'),
(25,'Anjan','USA','121345'),
(26,'Anjan','USA','121345'),
(27,'Anjan','USA','121345'),
(28,'Anjan','USA','121345'),
(29,'Anjan','USA','121345'),
(30,'Anjan','USA','121345');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
