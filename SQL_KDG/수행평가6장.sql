SELECT a.*, b.`stdName`, c.`lecName`
FROM `register` AS a JOIN `student` AS b 
ON a.`regStdNo` = b.`stdNo`
JOIN `lecture` AS c
ON a.`regLecNo` = c.`lecNo`;

INSERT INTO `register` SET `regStdNo`=123, `regLecNo`=123;