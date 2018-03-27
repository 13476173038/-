/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log : Database - library
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `book` */

CREATE TABLE `book` (
  `bid` varchar(15) NOT NULL,
  `bname` varchar(15) NOT NULL,
  `author` varchar(100) DEFAULT NULL,
  `pubcomp` varchar(15) DEFAULT NULL,
  `pubdate` date DEFAULT NULL,
  `bcount` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`bid`,`bname`,`author`,`pubcomp`,`pubdate`,`bcount`,`price`) values ('1007001','老人与海','海明威','北京大学出版社','2000-12-10',200,28);
insert  into `book`(`bid`,`bname`,`author`,`pubcomp`,`pubdate`,`bcount`,`price`) values ('1007002','神曲','但丁','复旦大学出版社','1998-05-06',50,24);
insert  into `book`(`bid`,`bname`,`author`,`pubcomp`,`pubdate`,`bcount`,`price`) values ('1007003','百年孤独','张爱玲','电子工业出版社','2014-01-01',150,36);
insert  into `book`(`bid`,`bname`,`author`,`pubcomp`,`pubdate`,`bcount`,`price`) values ('1007004','我和狗狗一起活下来','特蕾莎.瑞恩','人民文学出版社','2016-02-02',100,30);
insert  into `book`(`bid`,`bname`,`author`,`pubcomp`,`pubdate`,`bcount`,`price`) values ('1007005','灰霾来了怎么办','林媚珍','广东科技出版社','2016-04-04',100,25);
insert  into `book`(`bid`,`bname`,`author`,`pubcomp`,`pubdate`,`bcount`,`price`) values ('1007006','生活需要仪式感','李思圆','厦门大学出版社','2017-04-20',60,23.4);
insert  into `book`(`bid`,`bname`,`author`,`pubcomp`,`pubdate`,`bcount`,`price`) values ('1007007','任性的弱点','卡耐基','厦门大学出版社','2010-10-01',120,23.8);
insert  into `book`(`bid`,`bname`,`author`,`pubcomp`,`pubdate`,`bcount`,`price`) values ('1007008','缤纷的生命','爱德华.威尔逊','机械出版社','2016-05-11',120,46.7);

/*Table structure for table `borrow` */

CREATE TABLE `borrow` (
  `lid` char(5) NOT NULL,
  `nif` char(15) NOT NULL,
  `lenddate` date NOT NULL,
  `willdate` date DEFAULT NULL,
  `returndate` date DEFAULT NULL,
  PRIMARY KEY (`lid`,`nif`,`lenddate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `borrow` */

insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('001','1007001','2017-03-19','2017-04-19','2017-03-21');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('001','1007008','2017-03-26','2017-04-26','2017-04-10');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('002','1007003','2017-04-20','2017-05-20','2017-04-21');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('002','1007004','2018-03-01','2018-04-01','2018-03-25');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('003','1007003','2018-01-20','2018-02-20',NULL);
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('004','1007002','2017-10-19','2017-11-19','2017-10-30');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('005','1007008','2018-02-10','2018-03-10',NULL);
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('006','1007002','2017-09-01','2017-10-01',NULL);
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('006','1007008','2018-03-20','2018-04-20','2018-04-10');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('007','1007001','2018-03-20','2018-04-20','2018-04-08');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('008','1007004','2018-01-07','2018-02-07',NULL);
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('008','1007008','2018-03-20','2018-04-20','2018-04-10');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('009','1007002','2017-01-12','2017-02-12','2017-01-19');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('010','1007008','2017-07-20','2017-08-20',NULL);
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('010','1007008','2017-07-26','2017-08-26',NULL);
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('011','1007002','2017-10-01','2017-11-01',NULL);
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('012','1007008','2018-02-17','2018-03-17',NULL);
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('013','1007001','2017-11-14','2017-12-14','2017-11-28');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('014','1007002','2017-03-10','2017-04-10','2017-04-02');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('014','1007004','2017-03-10','2017-04-10','2017-04-02');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('015','1007008','2018-01-20','2018-02-20','2018-01-18');
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('016','1007003','2018-01-19','2018-02-19',NULL);
insert  into `borrow`(`lid`,`nif`,`lenddate`,`willdate`,`returndate`) values ('016','1007008','2018-01-16','2018-02-16',NULL);

/*Table structure for table `penalty` */

CREATE TABLE `penalty` (
  `rid` char(5) NOT NULL,
  `bid` char(15) NOT NULL,
  `pdate` date NOT NULL,
  `ptype` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`rid`,`bid`,`pdate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `penalty` */

insert  into `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) values ('003','1007003','2018-03-20',3,36);
insert  into `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) values ('004','1007002','2018-04-10',2,5);
insert  into `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) values ('005','1007008','2018-04-10',3,46.7);
insert  into `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) values ('006','1007002','2018-04-10',2,24);
insert  into `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) values ('008','1007004','2018-04-10',3,30);
insert  into `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) values ('010','1007008','2018-04-10',3,93.4);
insert  into `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) values ('011','1007002','2018-04-10',3,24);
insert  into `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) values ('012','1007008','2018-04-10',3,46.7);
insert  into `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) values ('016','1007003','2018-04-10',3,36);
insert  into `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) values ('016','1007008','2018-04-10',3,46.7);

/*Table structure for table `reader` */

CREATE TABLE `reader` (
  `rid` char(5) NOT NULL,
  `rname` char(10) NOT NULL,
  `lendnum` int(3) DEFAULT NULL,
  `raddress` char(20) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader` */

insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('001','艾青',2,'青岛路20号');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('002','李敖',2,'台北101大厦');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('003','舒畅',1,'');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('004','万方',1,'香港路1号');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('005','林浩',1,'');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('006','屈原',2,'');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('007','王刚',1,'光复路122号');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('008','屈原',2,'中正路10号');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('009','李艾',1,'虎门');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('010','李佳',2,'皇后大道东');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('011','舒乙',1,'');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('012','马云',1,'');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('013','林佳敏',1,'滨湖路10号');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('014','连战',2,'');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('015','王凯',1,'');
insert  into `reader`(`rid`,`rname`,`lendnum`,`raddress`) values ('016','明道',2,'光复路8号');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
