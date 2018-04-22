/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log : Database - dt59shopping
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dt59shopping` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dt59shopping`;

/*Table structure for table `shangping` */

DROP TABLE IF EXISTS `shangping`;

CREATE TABLE `shangping` (
  `spid` int(11) NOT NULL,
  `spname` varchar(500) DEFAULT NULL,
  `spprice` float DEFAULT NULL,
  `spdesc` varchar(500) DEFAULT NULL,
  `num` int(200) DEFAULT NULL,
  PRIMARY KEY (`spid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shangping` */

insert  into `shangping`(`spid`,`spname`,`spprice`,`spdesc`,`num`) values (1,'毛巾',200.12,'还不错哦！',NULL),(2,'牙刷',10.32,'软毛！',NULL),(3,'衣服',99.99,'包油哦！',NULL),(4,'牙高',321.12,'确实比较高！',NULL),(5,'筷子',11.12,'比较长！',NULL),(6,'碗',6000.12,'金碗！',NULL),(7,'锅',10.12,'铁锅！',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
