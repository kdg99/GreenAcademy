#날짜 : 2022/08/23
#이름 : 김동근
#내용 : 제2장 테이블 제약조건과 수정

#실습 2-1
CREATE TABLE `User2`(
	`uid` VARCHAR(20) PRIMARY KEY,
    `name` VARCHAR(10),
    `hp` CHAR(13),
    `age` TINYINT
);

#실습 2-2
INSERT INTO `User2` VALUES('a103', '김동근', '010-1111-1111', 23);
INSERT INTO `User2` VALUES('a102', '김유신', '010-2222-2222', 120);


#실습 2-3
CREATE TABLE `User3`(
	`uid` VARCHAR(20) PRIMARY KEY,
    `name` VARCHAR(10),
    `hp` CHAR(13) UNIQUE,
    `age` TINYINT
);

#실습 2-4
INSERT INTO `User3` VALUES('a103', '김동근', '010-1111-1113', 23);
INSERT INTO `User3` VALUES('a102', '김유신', '010-2222-2222', 120);

#실습 2-5
CREATE TABLE `Parent` (
	`pid` VARCHAR(10) PRIMARY KEY,
	`name` VARCHAR(10),
	`hp` CHAR(13) UNIQUE
);

CREATE TABLE `Child` (
	`cid` VARCHAR(10) PRIMARY KEY,
	`name` VARCHAR(10),
	`hp` CHAR(13) UNIQUE,
	`pid` VARCHAR(10),
	FOREIGN KEY (`pid`) REFERENCES `Parent` (`pid`)
);

#실습 2-6
insert into `Parent` values ('p101', '이성계', '010-1234-1111');
insert into `Child` values ('c101', '이방원', '010-1234-1001', 'p101');

#실습 2-7
CREATE TABLE `User4`(
	`seq` INT auto_increment primary key,
    `name` varchar(10),
    `gender` tinyint,
    `age` int,
    `addr` VARCHAR(255)
);

#실습 2-8
insert into `User4` (`name`, `gender`, `age`, `addr`) values ('김씨', 1, 23, '부산진구');
insert into `User4` (`name`, `gender`, `age`, `addr`) values ('이씨', 2, 24, '부산진구');
insert into `User4` (`name`, `gender`, `age`, `addr`) values ('박씨', 1, 12, '부산진구');
DELETE from `User4` where `name` = '이씨';

#실습 2-9
CREATE TABLE `User5`(
	`name` VARCHAR(10) NOT NULL,
	`gender` TINYINT,
	`age` INT DEFAULT 1,
	`addr` VARCHAR(10)
);

#실습 2-10
INSERT INTO `User5` SET
						`name` = '김씨',
                        `gender` = 1,
                        `addr` = '부산진구';
                        
#실습 2-11
ALTER TABLE `User5` ADD `hp` VARCHAR(20);
ALTER TABLE `User5` ADD `birth` CHAR(10) DEFAULT '0000-00-00' AFTER `name`;
ALTER TABLE `User5` ADD `uid` VARCHAR(10) first; 

#실습 2-12
ALTER TABLE `User5` MODIFY `hp` CHAR(13);
ALTER TABLE `User5` MODIFY `age` TINYINT;

#실습 2-13
ALTER TABLE `User5` CHANGE COLUMN `addr` `address` VARCHAR(100);

#실습 2-14
ALTER TABLE `User5` DROP `gender`;

#실습 2-15
CREATE TABLE `User6` LIKE `User5`;

#실습 2-16
INSERT INTO `User6` SELECT * FROM `User5`;
