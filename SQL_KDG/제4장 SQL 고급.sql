#날짜 : 2022.8.24
#이름 : 김동근
#내용 : SQL 고급

#실습4-1
CREATE TABLE `Member` (
	`uid` VARCHAR(10) PRIMARY KEY,
    `name` VARCHAR(10) NOT NULL,
    `hp` CHAR(13) UNIQUE NOT NULL,
    `pos` VARCHAR(10) NOT NULL,
    `dep` TINYINT DEFAULT NULL,
    `rdate` DATETIME NOT NULL
);

CREATE TABLE `Department` (
	`depNo` TINYINT NOT NULL,
    `name` VARCHAR(10) NOT NULL,
    `tel` LONG NOT NULL
);

CREATE TABLE `Sales` (
	`seq` INT auto_increment primary key,
    `uid` VARCHAR(10) NOT NULL,
    `year` YEAR NOT NULL,
    `month` TINYINT NOT NULL,
    `sale` INT NOT NULL
);

#실습4-2
INSERT INTO `Member` VALUES('a101', '박혁거세', '010-1234-1001', '부장', 101, NOW());
INSERT INTO `Member` VALUES('a102', '김유신', '010-1234-1002', '차장', 101, NOW());
INSERT INTO `Member` VALUES('a103', '김춘추', '010-1234-1003', '사원', 101, NOW());
INSERT INTO `Member` VALUES('a104', '장보고', '010-1234-1004', '대리', 102, NOW());
INSERT INTO `Member` VALUES('a105', '강감찬', '010-1234-1005', '과장', 102, NOW());
INSERT INTO `Member` VALUES('a106', '이성계', '010-1234-1006', '차장', 103, NOW());
INSERT INTO `Member` VALUES('a107', '정철', '010-1234-1007', '차장', 103, NOW());
INSERT INTO `Member` VALUES('a108', '이순신', '010-1234-1008', '부장', 104, NOW());
INSERT INTO `Member` VALUES('a109', '허균', '010-1234-1009', '부장', 104, NOW());
INSERT INTO `Member` VALUES('a110', '정약용', '010-1234-1010', '사원', 105, NOW());
INSERT INTO `Member` VALUES('a111', '박지원', '010-1234-1011', '사원', 105, NOW()); 

INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a101', YEAR(NOW()), 1, 98100);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a102', YEAR('2018-01-01'), 1, 136000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a103', YEAR('2018-01-01'), 1, 80100);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a104', YEAR('2018-01-01'), 1, 78000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a105', YEAR('2018-01-01'), 1, 93000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a101', YEAR('2018-01-01'), 2, 23500);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a102', YEAR('2018-01-01'), 2, 126000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a103', YEAR('2018-01-01'), 2, 18500);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a105', YEAR('2018-01-01'), 2, 19000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a106', YEAR('2018-01-01'), 2, 53000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a101', YEAR('2019-01-01'), 1, 24000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a102', YEAR('2019-01-01'), 1, 109000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a103', YEAR('2019-01-01'), 1, 101000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a104', YEAR('2019-01-01'), 1, 53500);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a107', YEAR('2019-01-01'), 1, 24000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a102', YEAR('2019-01-01'), 2, 160000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a103', YEAR('2019-01-01'), 2, 101000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a104', YEAR('2019-01-01'), 2, 43000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a105', YEAR('2019-01-01'), 2, 24000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a106', YEAR('2019-01-01'), 2, 109000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a102', YEAR('2020-01-01'), 1, 201000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a104', YEAR('2020-01-01'), 1, 63000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a105', YEAR('2020-01-01'), 1, 74000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a106', YEAR('2020-01-01'), 1, 122000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a107', YEAR('2020-01-01'), 1, 111000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a102', YEAR('2020-01-01'), 2, 120000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a103', YEAR('2020-01-01'), 2, 93000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a104', YEAR('2020-01-01'), 2, 84000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a105', YEAR('2020-01-01'), 2, 180000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES('a108', YEAR('2020-01-01'), 2, 76000);

INSERT INTO `Department` VALUES (101, '영업1부', '051-512-1001');
INSERT INTO `Department` VALUES (102, '영업2부', '051-512-1002');
INSERT INTO `Department` VALUES (103, '영업3부', '051-512-1003');
INSERT INTO `Department` VALUES (104, '영업4부', '051-512-1004');
INSERT INTO `Department` VALUES (105, '영업5부', '051-512-1005');
INSERT INTO `Department` VALUES (106, '영업지원부', '051-512-1006');
INSERT INTO `Department` VALUES (107, '인사부', '051-512-1007');

#실습4-3
select * from `Member` where `name` <> '김춘추';
> SELECT * FROM `Member` WHERE `pos`='차장' AND dep=101;
SELECT * FROM `Member` WHERE `pos`='차장' OR dep=101;
SELECT * FROM `Member` WHERE `name` != '김춘추';
SELECT * FROM `Member` WHERE `name` <> '김춘추';
SELECT * FROM `Member` WHERE `pos`='사원' OR `pos`='대리';
SELECT * FROM `Member` WHERE `pos` IN('사원', '대리');
SELECT * FROM `Member` WHERE `dep` IN(101, 102, 103);
SELECT * FROM `Member` WHERE `name` LIKE '%신';
SELECT * FROM `Member` WHERE `name` LIKE '김%';
SELECT * FROM `Member` WHERE `name` LIKE '김__';
SELECT * FROM `Member` WHERE `name` LIKE '_성_';
SELECT * FROM `Member` WHERE `name` LIKE '정_';
SELECT * FROM `Sales` WHERE `sale` > 50000;
SELECT * FROM `Sales` WHERE `sale` >= 50000 AND `sale` < 100000 AND `month`=1;
SELECT * FROM `Sales` WHERE `sale` BETWEEN 50000 AND 100000;
SELECT * FROM `Sales` WHERE `sale` NOT BETWEEN 50000 AND 100000;
SELECT * FROM `Sales` WHERE `year` IN(2020);
SELECT * FROM `Sales` WHERE `month` IN(1, 2);

#실습4-4
SELECT * FROM `Sales` ORDER BY `sale`; # 기본오름차순
SELECT * FROM `Sales` ORDER BY `sale` ASC;	#오름차
SELECT * FROM `Sales` ORDER BY `sale` DESC; #내림차
SELECT * FROM `Member` ORDER BY `name`;
SELECT * FROM `Member` ORDER BY `name` DESC;
SELECT * FROM `Member` ORDER BY `name` ASC;
SELECT * FROM `Sales` WHERE `sale` > 50000 ORDER By `sale` DESC;
SELECT * FROM `Sales` Where `sale` > 50000 ORDER BY `year`, `month`, `sale` DESC;

#실습4-5
SELECT * FROM Sales LIMIT 3;
SELECT * FROM Sales LIMIT 0,3;
SELECT * FROM Sales LIMIT 5,3; #인덱스 0부터 시작
SELECT * FROM Sales ORDER BY `sale` DESC LIMIT 3,5;
SELECT * FROM Sales 
WHERE `sale` > 50000
ORDER BY `year` DESC, `month`, `sale` DESC
LIMIT 5;


#실습4-6
Select sum(`sale`) as `합계` from `Sales`;
Select count(`seq`) as `갯수` from `Sales`;
SELECT COUNT(sale) AS `갯수` FROM `Sales`;
SELECT COUNT(*) AS `갯수` FROM `Sales`; 
SELECT AVG(sale) AS `평균` FROM `Sales`;
SELECT MAX(sale) AS `최대값` FROM `Sales`;
SELECT MIN(sale) AS `최소값` FROM `Sales`; 

SELECT SUBSTRING(hp, 10, 4) AS '전화번호 끝자리' FROM `Member`; 

INSERT INTO `Member` VALUES ('b101', '을지문덕', '010-5555-1234', '사장', 107, NOW());

#실습4-7
SELECT SUM(`sale`) AS `2018년 1월 매출 총합` FROM `Sales` WHERE `year`='2018' AND `month`=1;

#실습4-8
SELECT 
	SUM(`sale`) AS `2019년 2월 5만원 이상 매출 총합`,
	AVG(`sale`) AS `2019년 2월 5만원 이상 매출 평균` 
FROM 
	`Sales`
WHERE 
	`year`='2019' AND `month`=2 AND `sale` > 50000;
    
#실습4-9
SELECT
	MIN(`sale`) AS `최저`,
    MAX(`sale`) AS `최고`
FROM
	`Sales`
WHERE
	`year` IN(2020);
    

#실습4-10
select * from `Sales` group by `uid`;
select * from `Sales` group by `year`;
select * from `Sales` group by `uid`, `year`;


select `uid`, count(`seq`) as `건수` from `Sales` group by `uid`;
select `uid`, sum(`sale`) as `합계` from `Sales` group by `uid`;
select `uid`, avg(`sale`) as `평균` from `Sales` group by `uid`;
SELECT 
	`uid`,
    `year`,
    SUM(sale) AS `합계`
FROM `Sales` 
WHERE `sale` >= 50000
GROUP BY `uid`, `year`
ORDER BY `합계` DESC
limit 3;


#실습4-11
SELECT `uid`, sum(`sale`) AS `합계` from `Sales`
group by `uid`
HAving `합계` >= 200000;

SELECT `uid`, `year`, SUM(sale) AS `합계`
FROM `Sales`
WHERE `sale` >= 100000
GROUP BY `uid`, `year`
HAVING `합계` >= 200000
ORDER BY `합계` DESC;

#실습4-12
CREATE TABLE `Sales2` LIKE `Sales`;
INSERT INTO `Sales2` select * FROM `Sales`;
UPDATE `Sales2` SET `year` = `year` + 3;

SELECT * from `Sales` UNION SELECT * FROM `Sales2`;

SELECT 
	`uid`, `year`, SUM(`sale`) AS `합계`
FROM `Sales`
group by `uid`, `year`
UNION
SELECT 
	`uid`, `year`, SUM(`sale`) AS `합계`
FROM `Sales2`
group by `uid`, `year`
order by `year` ASC, `합계`DESC;

#실습4-13
SELECT * FROM `Sales` INNER JOIN `Member` ON `Sales`.uid = `Member`.uid; 
SELECT * FROM 
	`Sales` AS a 
JOIN 
	`Member` AS b 
ON a.uid = b.uid;

select
	`seq`, a.`uid`, `sale`, `name`, `pos`
from `Sales` as a
join `Member` as b
on a.uid = b.uid;


select
	`seq`, a.`uid`, `sale`, `name`, `pos`
from `Sales` as a
join `Member` as b
using(`uid`); #같은 칼럼 축약 명령어

select * from `Sales` as a
join `Member` as b on a.uid = b.uid
join `Department` as c on b.dep = c.depNo;


#실습4-14
select * from `Sales` as a
left join `member` as b
on a.uid=b.uid;

select * from `Sales` as a
right join `member` as b
on a.uid=b.uid;

#실습4-15
SELECT `uid`, a.`name`, `pos`, b.`name` AS `부서명`
from `Member` as a
join `Department` as b
on a.dep = b.depNo;

SELECT sum(`sale`) `김유신 2019년도 매출 합`
from `Sales` as a
join `Member` as b
using (`uid`)
WHERE `year`=2019 AND `name` = '김유신';

SELECT 
	b.`name` as `직원명`,
    c.`name` as `부서명`,
    b.`pos` as `직급`,
    a.`year` as `년도`,
	sum(`sale`) as `매출합`
From `Sales` as a
Join `Member` as b
on a.uid = b.uid
Join `Department` as c on b.dep = c.depNo
Where `year` = 2019 and `sale` >= 50000
Group by a.`uid`
Having `매출합` >= 100000
Order by `매출합` Desc;


#실습4-16
#실습4-17
#실습4-17
#실습4-19
#실습4-20
















