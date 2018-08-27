#这是原始表
CREATE TABLE people (
    id int  PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL,
    age int NOT NULL,
    locale varchar (25) default "本地",
    qq varchar (15) default "保密",
    email varchar (30)
    );
create table book (
    id int  PRIMARY KEY AUTO_INCREMENT,
    bookname varchar (20) not null ,
    number int not null ,
    readcount int (64)  not null,
    author varchar (10)
);
create table readrecord(
    id int  PRIMARY KEY AUTO_INCREMENT,
    user_id int (64) ,
    book_id int (32) ,
    read_time DATETIME,
    foreign key (user_id) references people(id),
    foreign key (book_id) references book(id)
);
============================
#这是修改过后的 然后用备份功能提取出来的表结构
DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(20) NOT NULL,
  `number` int(11) NOT NULL,
  `readcount` int(64) NOT NULL,
  `author` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bookname` (`bookname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `people` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `age` int(11) NOT NULL,
  `locale` varchar(25) DEFAULT '本地',
  `qq` varchar(15) DEFAULT '保密',
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
DROP TABLE IF EXISTS `readrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `readrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(64) DEFAULT NULL,
  `book_id` int(32) DEFAULT NULL,
  `read_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `readrecord_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `people` (`id`),
  CONSTRAINT `readrecord_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
