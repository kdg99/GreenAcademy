#날짜 : 2022.08.29
#이름 : 김동근
#내용 : SQL 연습문제1

#실습 1-1
CREATE DATABASE `Java1_Shop`;
CREATE USER 'java1_admin1'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON Shop.* TO 'java1_admin1'@'%';
FLUSH PRIVILEGES;

#실습 1-2
#auto increment X
create table `Customer` (
	`custId` VARCHAR(10) primary KEY,
    `name` VARCHAR(10) NOT NULL,
    `hp` CHAR(13) default NULL,
    `addr` VARCHAR(100) default NULL,
    `rdate` DATE NOT NULL
);

CREATE TABLE `Product`(
	`prodNo` TINYINT primary key,
    `prodName` VARCHAR(10) not null,
    `stock` INT not null default 0,
    `price` INT default null,
    `company` VARCHAR(20) not null
);

CREATE TABLE `Order`(
	`orderNo` TINYINT primary key,
    `orderId` VARCHAR(10) not null,
    `orderProduct` TINYINT not null,
    `orderCount` TINYINT NOT NULL default 1,
    `orderDate` DATETIME not null
);

#실습 1-3
INSERT INTO `Customer` VALUES('c101', '김유신', '010-1234-1001', '김해시 봉황동', '2022-01-01');
INSERT INTO `Customer` VALUES('c102', '김춘추', '010-1234-1002', '김해시 봉황동', '2022-01-02');
INSERT INTO `Customer` VALUES('c103', '장보고', '010-1234-1003', '경주시 보문동', '2022-01-03');
INSERT INTO `Customer` VALUES('c104', '강감찬', '010-1234-1004', '완도군 청산면', '2022-01-04');
INSERT INTO `Customer` (`custId`, `name`, `rdate`) VALUES('c105', '이성계', '2022-01-05');
INSERT INTO `Customer` VALUES('c106', '정철', '010-1234-1006', '경기도 용인시', '2022-01-06');
INSERT INTO `Customer` (`custId`, `name`, `rdate`) VALUES('c107', '허준', '2022-01-07');
INSERT INTO `Customer` VALUES('c108', '이순신', '010-1234-1008', '서울시 영등포구', '2022-01-08');
INSERT INTO `Customer` VALUES('c109', '송상현', '010-1234-1009', '부산시 동래구', '2022-01-09');
INSERT INTO `Customer` VALUES('c110', '정약용', '010-1234-1010', '경기도 광주시', '2022-01-10');

INSERT INTO `Product` VALUES(1, '새우깡', 5000, 1500, '농심');
INSERT INTO `Product` VALUES(2, '초코파이', 2500, 2500, '오리온');
INSERT INTO `Product` VALUES(3, '포카칩', 3600, 1700, '오리온');
INSERT INTO `Product` VALUES(4, '양파링', 1250, 1800, '농심');
INSERT INTO `Product` (`prodNo`, `prodName`, `stock`, `company`) VALUES (5, '죠리퐁', 2200, '크라운');
INSERT INTO `Product` VALUES(6, '마가렛트', 3500, 3500, '롯데');
INSERT INTO `Product` VALUES(7, '뿌셔뿌셔', 1650, 1200, '오뚜기');

INSERT INTO `Order` VALUES(1, 'c102', 3, 2, '2022-07-01 13:15:10');
INSERT INTO `Order` VALUES(2, 'c101', 4, 1, '2022-07-01 14:16:11');
INSERT INTO `Order` VALUES(3, 'c108', 1, 1, '2022-07-01 17:23:18');
INSERT INTO `Order` VALUES(4, 'c109', 6, 5, '2022-07-02 10:46:36');
INSERT INTO `Order` VALUES(5, 'c102', 2, 1, '2022-07-03 09:15:37');
INSERT INTO `Order` VALUES(6, 'c101', 7, 3, '2022-07-03 12:35:12');
INSERT INTO `Order` VALUES(7, 'c110', 1, 2, '2022-07-03 16:55:36');
INSERT INTO `Order` VALUES(8, 'c104', 2, 4, '2022-07-04 14:23:23');
INSERT INTO `Order` VALUES(9, 'c102', 1, 3, '2022-07-04 21:54:34');
INSERT INTO `Order` VALUES(10, 'c107', 6, 1, '2022-07-05 14:21:03');

#실습 1-4
SELECT * FROM `Customer`;

#실습 1-5
SELECT `custID`, `name`, `hp` FROM `Customer`;

#실습 1-6
SELECT * FROM `Product`;

#실습 1-7
SELECT `company` FROM `Product`;
 
#실습 1-8
SELECT distinct `company` FROM `Product`;

#실습 1-9
SELECT `prodName`, `price` FROM `Product`;


#실습 1-10
SELECT `prodName`, `price`+500 as `조정단가` FROM `Product`;

#실습 1-11
SELECT `prodName`, `stock`, `price` FROM `Product` WHERE `company`='오리온';

#실습 1-12
SELECT `orderProduct`, `orderCount`, `orderDate` FROM `Order` WHERE `orderId`='c102';

#실습 1-13
SELECT `orderProduct`, `orderCount`, `orderDate` FROM `Order` WHERE `orderId` = 'c102' AND `orderCount` >= 2; 

#실습 1-14
SELECT * FROM `Product` WHERE `price`>= 1000 AND `price` <= 2000;

#실습 1-15
SELECT `custId`, `name`, `hp`, `addr` FROM `Customer` WHERE `name` LIKE '김%';

#실습 1-16
SELECT `custId`, `name`, `hp`, `addr` FROM `Customer` WHERE `name` LIKE '__';

#실습 1-17
SELECT * FROM `Customer` WHERE `hp` IS null;

#실습 1-18
SELECT * FROM `Customer` WHERE `addr` IS NOT NULL;

#실습 1-19
SELECT * FROM `Customer` order by `rdate` DESC;

#실습 1-20
SELECT * FROM `Order` WHERE `orderCount` >= 3 order by `orderCount` DESC, `orderNo`ASC;

#실습 1-21
SELECT AVG(`price`) FROM `Product`;

#실습 1-22
SELECT SUM(`stock`) as `재고량 합계` FROM `Product` WHERE `company`='농심';

#실습 1-23
SELECT COUNT(*) AS `고객수` FROM `Customer`;

#실습 1-24
SELECT COUNT(distinct `company`) AS `제조업체 수` FROM `Product`;

#실습 1-25
SELECT `orderProduct` AS `주문 상품번호`, SUM(`orderCount`) AS `총 주문수량` FROM `Order` group by `orderProduct` order by `orderProduct`;

#실습 1-26
SELECT `company` AS `제조업체`, COUNT(*) AS `제품수`, MAX(`price`) AS `최고가` FROM `Product` group by `company` order by `company`;

#실습 1-27
SELECT `company` AS `제조업체`, COUNT(*) AS `제품수`, MAX(`price`) AS `최고가` FROM `Product` group by `company` having `제품수` >= 2;

#실습 1-28
SELECT `orderProduct`, `orderId`, SUM(`orderCount`) AS `총 주문수량` FROM `Order` group by `orderProduct`, `orderId` order by `orderProduct`;

#실습 1-29
SELECT a.orderId, b.prodName FROM `Order` As a
Join `Product` As b
On a.orderProduct= b.prodNo
WHERE `orderId` = 'c102';

#실습 1-30
SELECT `orderId`, `name`, `prodName`, `orderDate`
FROM `Order` AS a
Join `Customer` AS b
On a.orderId = b.custId
Join `Product` AS c
On a.orderProduct = c.prodNo
WHERE DATE(`orderDate`) = '2022-07-03';


SELECT `orderId`, `name`, `prodName`, `orderDate`
FROM `Order` AS a
Join `Customer` AS b
On a.orderId = b.custId
Join `Product` AS c
On a.orderProduct = c.prodNo
WHERE `orderDate` Like '%07-03%';
