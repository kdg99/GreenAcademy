package kr.co.farmstory2.service;

import kr.co.farmstory2.dao.UserDAO;
import kr.co.farmstory2.vo.TermsVO;
import kr.co.farmstory2.vo.UserVO;

public enum UserService {
	INSTANCE;
	private UserDAO dao = UserDAO.getInstance();

	public void insertUser(UserVO user) {
		dao.insertUser(user);
	}
	
	public TermsVO selectTerms() {
		return dao.selectTerms();
	}
	
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	public int selectCountNick(String nick) {
		return dao.selectCountNick(nick);
	}
	
	public UserVO selectUser(String uid, String pass) {
		return dao.selectUser(uid, pass);
	}
	
}
