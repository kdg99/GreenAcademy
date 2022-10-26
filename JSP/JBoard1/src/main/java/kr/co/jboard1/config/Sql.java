package kr.co.jboard1.config;

public class Sql {
	public static final String INSERT_USER		= "INSERT INTO `board_user` set "
												+ "`uid`=?,"
												+ "`pass`=SHA2(?,256),"
												+ "`name`=?,"
												+ "`nick`=?,"
												+ "`email`=?,"
												+ "`hp`=?,"
												+ "`zip`=?,"
												+ "`addr1`=?,"
												+ "`addr2`=?"
												+ "`regip`=?,"
												+ "`rdate`=NOW()";
	
	public static final String SELECT_USER 		= "select * from `board_user` where `uid`=? and `pass`=SHA2(?,256)";
	public static final String SELECT_COUNT_UID	=  "SELECT COUNT(`uid`) FROM `board_user` WHERE `uid`=?"; 
	public static final String SELECT_COUNT_NICK= "SELECT COUNT(`nick`) FROM `board_user` WHERE `nick`=?";
	public static final String SELECT_TERMS		= "select * from `board_terms`";

	
	// write.jsp
	public static final String INSERT_ARTICLE		= "INSERT INTO `board_article` set "
													+ "`title`=?,"
													+ "`content`=?,"
													+ "`file`=?,"
													+ "`uid`=?,"
													+ "`regip`=?,"
													+ "`rdate`=NOW()";
	
	public static final String INSERT_FILE 	= "INSERT INTO `board_file` set "
											+ "`parent`=?,"
											+ "`newName`=?,"
											+ "`oriName`=?,"
											+ "`rdate`=NOW()";
	
	public static final String SELECT_MAX_NO = "SELECT MAX(`no`) from `board_article`";
	
}
