java1_collegeCREATE DATABASE `java1_College`;
CREATE USER 'java1_admin'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON java1_College.* TO 'java1_admin'@'%';
FLUSH PRIVILEGES;

#실습3-2
CREATE TABLE `Student` (
	`stdjava1dbNo`		CHAR(8) PRIMARY KEY,
	`stdName`	VARCHAR(20) NOT NULL,
	`stdHp`		CHAR(13) NOT NULL,
	`stdYear`	TINYINT NOT NULL,
	`stdAddress` VARCHAR(100)
);

CREATE TABLE `Lecture` (
	`lecNo`		INT PRIMARY KEY,
	`lecName`	VARCHAR(20) NOT NULL,
	`lecCredit`	TINYINT NOT NULL,
	`lecTime`	INT NOT NULL,
	`lecClass`	VARCHAR(10) DEFAULT NULL
);

CREATE TABLE `Register` (
	`regStdNo`			CHAR(8),
	`regLecNo`			INT,
	`regMidScore`		TINYINT,
	`regFinalScore`	TINYINT,
	`regTotalScore`	TINYINT,
	`regGrade`			CHAR(1)
);

#실습3-3
INSERT INTO `Student` VALUES ('20201016', '김유신', '010-1234-1001', 3, NULL);
INSERT INTO `Student` VALUES ('20201126', '김춘추', '010-1234-1002', 3, '경상남도 경주시');
INSERT INTO `Student` VALUES ('20210216', '장보고', '010-1234-1003', 2, '전라남도 완도시');
INSERT INTO `Student` VALUES ('20210326', '강감찬', '010-1234-1004', 2, '서울시 영등포구');
INSERT INTO `Student` VALUES ('20220416', '이순신', '010-1234-1005', 1, '부산시 부산진구');
INSERT INTO `Student` VALUES ('20220521', '송상현', '010-1234-1006', 1, '부산시 동래구');

INSERT INTO `Lecture` VALUES (234, '무역영문', 3, 20, '본201');
INSERT INTO `Lecture` VALUES (239, '세법개론', 3, 40, '본204');
INSERT INTO `Lecture` VALUES (248, '빅데이터 개론', 3, 20, '본B01');
INSERT INTO `Lecture` VALUES (253, '컴퓨팅사고와 코딩', 2, 10, '본B02');
INSERT INTO `Lecture` VALUES (349, '사회복지 마케팅', 2, 50, '본301');
INSERT INTO `Lecture` VALUES (159, '인지행동심리학', 3, 40, '본304');
INSERT INTO `Lecture` VALUES (167, '운영체제론', 3, 25, '본B05');

INSERT INTO `Register` (`regStdNo`, `regLecNo`) VALUES ('20201126', 234);
INSERT INTO `Register` (`regStdNo`, `regLecNo`) VALUES ('20201016', 248);
INSERT INTO `Register` (`regStdNo`, `regLecNo`) VALUES ('20201016', 253);
INSERT INTO `Register` (`regStdNo`, `regLecNo`) VALUES ('20201126', 239);
INSERT INTO `Register` (`regStdNo`, `regLecNo`) VALUES ('20210216', 349);
INSERT INTO `Register` (`regStdNo`, `regLecNo`) VALUES ('20210326', 349);
INSERT INTO `Register` (`regStdNo`, `regLecNo`) VALUES ('20201016', 167);
INSERT INTO `Register` (`regStdNo`, `regLecNo`) VALUES ('20220416', 349);

# 실습 3-9. 아래와 같이 중간고사, 기말고사 점수를 입력하시오.
UPDATE `Register` SET `regMidScore` = 36, `regFinalScore`= 42 WHERE `regStdNo`='20201126' AND `regLecNo`=234;
UPDATE `Register` SET `regMidScore` = 24, `regFinalScore`= 62 WHERE `regStdNo`='20201016' AND `regLecNo`=248;
UPDATE `Register` SET `regMidScore` = 28, `regFinalScore`= 40 WHERE `regStdNo`='20201016' AND `regLecNo`=253;
UPDATE `Register` SET `regMidScore` = 37, `regFinalScore`= 57 WHERE `regStdNo`='20201126' AND `regLecNo`=239;
UPDATE `Register` SET `regMidScore` = 28, `regFinalScore`= 68 WHERE `regStdNo`='20210216' AND `regLecNo`=349;
UPDATE `Register` SET `regMidScore` = 16, `regFinalScore`= 65 WHERE `regStdNo`='20210326' AND `regLecNo`=349;
UPDATE `Register` SET `regMidScore` = 18, `regFinalScore`= 38 WHERE `regStdNo`='20201016' AND `regLecNo`=167;
UPDATE `Register` SET `regMidScore` = 25, `regFinalScore`= 58 WHERE `regStdNo`='20220416' AND `regLecNo`=349;

# 실습 3-10. 아래와 같이 총점과 등급을 입력하시오.
UPDATE `Register` SET 
							`regTotalScore`= `regMidScore` + `regFinalScore`,
							`regGrade` = if(`regTotalScore` >= 90, 'A', 
  										 	 if(`regTotalScore` >= 80, 'B',
											 if(`regTotalScore` >= 70, 'C',
											 if(`regTotalScore` >= 60, 'D', 'F'))));						
