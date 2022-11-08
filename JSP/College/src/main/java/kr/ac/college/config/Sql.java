package kr.ac.college.config;

public class Sql {
	//lecture
	public static final String SELECT_LECTURES = "SELECT * FROM `lecture`";
	public static final String INSERT_LECTURE = "INSERT INTO `lecture` VALUES (?,?,?,?,?)";
	
	//register
	public static final String SELECT_REGISTERS = "SELECT a.*, b.`stdName`, c.`lecName` "
												+ "FROM `register` AS a JOIN `student` AS b "
												+ "ON a.`regStdNo` = b.`stdNo` "
												+ "JOIN `lecture` AS c "
												+ "ON a.`regLecNo` = c.`lecNo`";
	public static final String INSERT_REGISTER 	= "INSERT INTO `register` SET "
												+ "`regStdNo`=?, `regLecNo`=?";
	//student
	public static final String SELECT_STUDENTS = "SELECT * FROM `student`";
	public static final String INSERT_STUDENT = "INSERT INTO `student` VALUES (?,?,?,?,?)";
	
	
}
