 #날짜 : 2022.08.24
 #이름 : 김동근
 #내용 : 제3장 데이터베이스 관리
 
 #실습3-1
 create database `java1_test_db`;
 create user 'java1_test'@'%' identified by '1234'; # %는 모든 호스트에서의(외부 IP) 접속을 허용
 grant all privileges on `java1_test_db`.* to 'java1_test'@'%'; # 이 DB에 대한 모든 권한을 주겠다
 flush privileges; # 변경사항 적용
 
 #실습3-2
 set password for 'java1_test'@'%'=password('12345');
 drop USER 'java1_test'@'%';
 FLUSH PRIVILEGES;