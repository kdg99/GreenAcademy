package kr.co.jboard2.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.jboard2.db.DBHelper;
import kr.co.jboard2.db.Sql;
import kr.co.jboard2.vo.TermsVO;
import kr.co.jboard2.vo.UserVO;

public class UserDAO extends DBHelper{
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	private UserDAO() {}
	//로거
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertUser(UserVO user) {
		try {
			logger.info("insertUser...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_USER);
			psmt.setString(1, user.getUid());
			psmt.setString(2, user.getPass());
			psmt.setString(3, user.getName());
			psmt.setString(4, user.getNick());
			psmt.setString(5, user.getEmail());
			psmt.setString(6, user.getHp());
			psmt.setString(7, user.getZip());
			psmt.setString(8, user.getAddr1());
			psmt.setString(9, user.getAddr2());
			psmt.setString(10, user.getRegip());
			psmt.executeUpdate();
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public TermsVO selectTerms() {
		TermsVO terms = null;
		try {
			logger.info("selectTerms start...");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_TERMS);
			
			if(rs.next()) {
				terms = new TermsVO();
				terms.setTerms(rs.getString(1));
				terms.setPrivacy(rs.getString(2));				
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("terms : " + terms);
		return terms;
	}
	
	public int selectCountUid(String uid) {
		int result = 0;
		try {
			logger.info("selectCountUid start...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_UID);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : "+ result);
		return result;
	}
	
	public int selectCountNick(String nick) {
		int result = 0;
		try {
			logger.info("selectCountNick start...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_NICK);
			psmt.setString(1, nick);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : "+ result);
		return result;
	}
	
	public UserVO selectUser(String uid, String pass) {
		UserVO user = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_USER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setUid(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setName(rs.getString(3));
				user.setNick(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setHp(rs.getString(6));
				user.setGrade(rs.getInt(7));
				user.setZip(rs.getString(8));
				user.setAddr1(rs.getString(9));
				user.setAddr2(rs.getString(10));
				user.setRegip(rs.getString(11));
				user.setRdate(rs.getString(12));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return user;
	}
	
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}
}
