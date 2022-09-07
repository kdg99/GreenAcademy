#학과
INSERT INTO `Departments` VALUES ('10', '국어국문학과', '051-510-1010');
INSERT INTO `Departments` VALUES ('11', '영어영문학과', '051-510-1011');
INSERT INTO `Departments` VALUES ('20', '경역학과', '051-510-1020');
INSERT INTO `Departments` VALUES ('21', '경제학과', '051-510-1021');
INSERT INTO `Departments` VALUES ('22', '정치외교학과', '051-510-1022');
INSERT INTO `Departments` VALUES ('23', '사회복지학과', '051-510-1023');
INSERT INTO `Departments` VALUES ('30', '수학과', '051-510-1030');
INSERT INTO `Departments` VALUES ('31', '통계학과', '051-510-1031');
INSERT INTO `Departments` VALUES ('32', '생명과학과', '051-510-1032');
INSERT INTO `Departments` VALUES ('40', '기계공학과', '051-510-1040');
INSERT INTO `Departments` VALUES ('41', '전자공학과', '051-510-1041');
INSERT INTO `Departments` VALUES ('42', '컴퓨터공학과', '051-510-1042');

#교수
#INSERT INTO `Professors` (`proNo`, `depNo`, `proName`, `proJumin`, `proHp`, `proEmail`, `proAddr`) VALUES ('P10101', '10', '김유신', '750120-1234567', '010-1101-1976', 'kimys@hg.ac.kr', '서울');
INSERT INTO `Professors` VALUES ('P10101', '10', '김유신', '750120-1234567', '010-1101-1976', 'kimys@hg.ac.kr', '서울');
INSERT INTO `Professors` VALUES ('P10102', '10', '계백', '740610-1234567', '010-1102-1975', 'gaeback@hg.ac.kr', '서울');
INSERT INTO `Professors` VALUES ('P11101', '11', '김관창', '880529-1234567', '010-1103-1989', 'kwanch@hg.ac.kr', '대전');
INSERT INTO `Professors` VALUES ('P11103', '11', '김춘추', '780412-1234567', '010-2101-1979', 'kimcc@hg.ac.kr', '대전');
INSERT INTO `Professors` VALUES ('P11104', '11', '이사부', '650911-1234567', '010-2104-1966', 'leesabu@hg.ac.kr', '대전');
INSERT INTO `Professors` VALUES ('P22110', '22', '장보고', '780727-1234567', '010-3101-1979', 'jangbg@hg.ac.kr', '대구');
INSERT INTO `Professors` VALUES ('P23102', '23', '선덕여왕', '830614-1234567', '010-4101-1984', 'queen@hg.ac.kr', '대구');
INSERT INTO `Professors` VALUES ('P31101', '31', '강감찬', '641020-1234567', '010-5101-1965', 'kang@hg.ac.kr', '대구');
INSERT INTO `Professors` VALUES ('P31104', '31', '신사임당', '711127-1234567', '010-6101-1972', 'sinsa@hg.ac.kr', '부산');
INSERT INTO `Professors` VALUES ('P40101', '40', '이이', '910906-1234567', '010-7103-1992', 'leelee@hg.ac.kr', '부산');
INSERT INTO `Professors` VALUES ('P40102', '40', '이황', '881208-1234567', '010-7104-1989', 'hwang@hg.ac.kr', '광주');
INSERT INTO `Professors` VALUES ('P42103', '42', '송상현', '760313-1234567', '010-8101-1977', 'ssh@hg.ac.kr', '광주');

#학생
#INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdEmail`,`stdAddr`) VALUES ('20','','P', '', '-1234567', '010-', '@.com','');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdAddr`) VALUES ('20101001','10','P10101', '정우성', '760121-1234567', '010-1101-7601', '서울');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdAddr`) VALUES ('20101002','10','P10101', '이정재', '750611-1234567', '010-1102-7506', '서울');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdEmail`,`stdAddr`) VALUES ('20111011','11','P11103', '전지현', '890530-1234567', '010-1103-8905', 'jjh@naver.com','대전');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdEmail`,`stdAddr`) VALUES ('20111013','11','P11103', '이나영', '790413-1234567', '010-2101-7904', 'lee@naver.com','대전');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdEmail`,`stdAddr`) VALUES ('20111014','11','P11104', '원빈', '660912-1234567', '010-2104-6609', 'one@daum.com','대전');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdEmail`,`stdAddr`) VALUES ('21221010','22','P22110', '장동건', '790728-1234567', '010-3101-7907', 'jang@naver.com','대구');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdEmail`,`stdAddr`) VALUES ('21231002','23','P23102', '고소영', '840615-1234567', '010-4101-8406', 'goso@daum.com','대구');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdEmail`,`stdAddr`) VALUES ('22311011','31','P31104', '김연아', '651021-1234567', '010-5101-6510', 'yuna@daum.com','대구');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdAddr`) VALUES ('22311014','31','P31104', '유재석', '721128-1234567', '010-6101-7211', '부산');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdAddr`) VALUES ('22401001','40','P40101', '강호동', '920907-1234567', '010-7103-9209', '부산');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdEmail`,`stdAddr`) VALUES ('22401002','40','P40101', '조인성', '891209-1234567', '010-7104-8912', 'join@gmail.com','광주');
INSERT INTO `Students` (`stdNo`, `Departments_depNo`, `Professors_proNo`,`stdName`, `stdJumin`, `stdHp`, `stdEmail`,`stdAddr`) VALUES ('22421003','42','P42103', '강동원', '770314-1234567', '010-8101-7703', 'dong@naver.com','광주');

#강좌
INSERT INTO `Lectures` VALUES('101001', 'P10101', '대학 글쓰기', 2, 10, '본102');
INSERT INTO `Lectures` VALUES('101002', 'P10102', '한국어음운론', 3, 30, '본102');
INSERT INTO `Lectures` VALUES('101003', 'P10102', '한국현대문학사', 3, 30, '본103');
INSERT INTO `Lectures` VALUES('111011', 'P11103', '중세영문학', 3, 25, '본201');
INSERT INTO `Lectures` VALUES('111012', 'P11104', '영미시', 3, 25, '본201');
INSERT INTO `Lectures` VALUES('231110', 'P23102', '사회복지학개론', 1, 8, '별관103');
INSERT INTO `Lectures` VALUES('311002', 'P31101', '통계학의 이해', 2, 16, '별관303');
INSERT INTO `Lectures` VALUES('311003', 'P31104', '기초 통계학', 3, 26, '별관303');
INSERT INTO `Lectures` VALUES('401019', 'P40101', '기계역학', 3, 36, '공학관 102');
INSERT INTO `Lectures` VALUES('421012', 'P42103', '데이터베이스', 3, 32, '공학관 103');

#수강
INSERT INTO `Register` (`Students_stdNo`, `Lectures_lecNo`, `lectures_professors_proNo`) VALUES('20101001', '101001', 'P10101');
INSERT INTO `Register` (`Students_stdNo`, `Lectures_lecNo`, `lectures_professors_proNo`) VALUES('20101001', '101002', 'P10102');
INSERT INTO `Register` (`Students_stdNo`, `Lectures_lecNo`, `lectures_professors_proNo`) VALUES('20111013', '111011', 'P11103');
INSERT INTO `Register` (`Students_stdNo`, `Lectures_lecNo`, `lectures_professors_proNo`) VALUES('21231002', '231110', 'P23102');
INSERT INTO `Register` (`Students_stdNo`, `Lectures_lecNo`, `lectures_professors_proNo`) VALUES('22401001', '401019', 'P40101');
INSERT INTO `Register` (`Students_stdNo`, `Lectures_lecNo`, `lectures_professors_proNo`) VALUES('22401001', '421012', 'P42103');
INSERT INTO `Register` (`Students_stdNo`, `Lectures_lecNo`, `lectures_professors_proNo`) VALUES('20101001', '101003', 'P10102');
INSERT INTO `Register` (`Students_stdNo`, `Lectures_lecNo`, `lectures_professors_proNo`) VALUES('22421003', '311003', 'P31104');
INSERT INTO `Register` (`Students_stdNo`, `Lectures_lecNo`, `lectures_professors_proNo`) VALUES('22421003', '421012', 'P42103');
INSERT INTO `Register` (`Students_stdNo`, `Lectures_lecNo`, `lectures_professors_proNo`) VALUES('20111013', '111012', 'P11104');
