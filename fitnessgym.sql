/*
SQLyog Ultimate v9.20 
MySQL - 5.6.12-log : Database - bnf
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bnf` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bnf`;

/*Table structure for table `bmi_graph` */

DROP TABLE IF EXISTS `bmi_graph`;

CREATE TABLE `bmi_graph` (
  `bmi_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_bmi` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`bmi_id`),
  KEY `FK577E0B4DD8CA3C10` (`user_id`),
  CONSTRAINT `FK577E0B4DD8CA3C10` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bmi_graph` */

/*Table structure for table `exercise_schedule` */

DROP TABLE IF EXISTS `exercise_schedule`;

CREATE TABLE `exercise_schedule` (
  `es_id` int(11) NOT NULL AUTO_INCREMENT,
  `es_day` varchar(255) DEFAULT NULL,
  `es_game` varchar(255) DEFAULT NULL,
  `es_nutrition` varchar(255) DEFAULT NULL,
  `es_video` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`es_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `exercise_schedule` */

insert  into `exercise_schedule`(`es_id`,`es_day`,`es_game`,`es_nutrition`,`es_video`) values (1,'Monday','Shoulder','Beef,Salad,Shake',NULL),(2,'Tuesday','Arms','Chicken Soup,Chocolate,Banana',NULL),(3,'Wednesday','Chest','Fish,Bean,MegaMass',NULL),(4,'Thurday','Wings','Mutton ,salads',NULL),(5,'Friday','Legs','Beef Legs,Fruit Juice',NULL);

/*Table structure for table `link` */

DROP TABLE IF EXISTS `link`;

CREATE TABLE `link` (
  `link_id` int(11) NOT NULL AUTO_INCREMENT,
  `link_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `link` */

insert  into `link`(`link_id`,`link_url`) values (1,'www.com'),(2,'abc.com'),(3,'www.xyz.com'),(4,'www.vu.edu.pk'),(5,'www.gym.com');

/*Table structure for table `mail` */

DROP TABLE IF EXISTS `mail`;

CREATE TABLE `mail` (
  `mail_id` int(11) NOT NULL AUTO_INCREMENT,
  `mail_from` int(11) DEFAULT NULL,
  `mail_to` int(11) DEFAULT NULL,
  `mail_discription` varchar(255) DEFAULT NULL,
  `mail_date` date DEFAULT NULL,
  PRIMARY KEY (`mail_id`),
  KEY `FK_mail` (`mail_to`),
  KEY `FK_mail2` (`mail_from`),
  CONSTRAINT `FK_mail` FOREIGN KEY (`mail_to`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_mail2` FOREIGN KEY (`mail_from`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `mail` */

insert  into `mail`(`mail_id`,`mail_from`,`mail_to`,`mail_discription`,`mail_date`) values (1,14,1,'pain in arm',NULL),(2,15,1,'pain in shoulder',NULL),(3,1,15,'pain in teeth',NULL);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_login` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `cell` varchar(255) DEFAULT NULL,
  `user_height` float DEFAULT NULL,
  `user_weight` float DEFAULT NULL,
  `user_doe` date DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `user_instructor` int(11) DEFAULT NULL,
  `special_instruction` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_users` (`user_instructor`),
  CONSTRAINT `FK_users` FOREIGN KEY (`user_instructor`) REFERENCES `users` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`user_id`,`user_name`,`user_login`,`user_password`,`user_email`,`cell`,`user_height`,`user_weight`,`user_doe`,`user_type`,`user_instructor`,`special_instruction`) values (1,'ali','test','123','ali.com','123',5.4,66,NULL,'instructor',NULL,NULL),(14,'farhan','kek44','123','f.com','4366',5.4,63,NULL,'member',1,'dont do exercise 2 times in a day\r\ndont eat  fat food\r\ndont drink pepsi'),(15,'afzal shah','elifem3','235','abc.om','4522',6.5,43,NULL,'member',1,'dont eat   fast foood\r\ndont be angry\r\ndont drink pepsi\r\neat salad\r\nno smoking'),(16,'Imam Zaid','simeg','3213','cli.com','3453',6.5,76,NULL,'member',1,'no smoking \r\nno alchohal');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
