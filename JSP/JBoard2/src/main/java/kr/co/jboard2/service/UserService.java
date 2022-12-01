package kr.co.jboard2.service;

import com.google.gson.JsonObject;

import kr.co.jboard2.dao.UserDAO;
import kr.co.jboard2.vo.UserVO;

public enum UserService {
	INSTANCE;
	private UserDAO dao = UserDAO.getInstance();
	
	public String checkPassForModifyInfo(String uid, String pass) {
		UserVO user = dao.selectUser(uid, pass);
		JsonObject json = new JsonObject();
		json.addProperty("result", (user != null ? 1 : 0));
		
		return json.toString();
	}
	
	public String updateUserPassword(String uid, String pass) {
		JsonObject json = new JsonObject();
		json.addProperty("result", dao.updateUserPassword(uid, pass));
		
		return json.toString();
	}
	
	public void updateUserInfo(UserVO user) {
		dao.updateUser(user);
	}
	
	public UserVO selectUserForChangeInfo(String uid) {
		return dao.selectUserForChangeInfo(uid);
	}
	
	public String closeAccount(String uid) {
		JsonObject json = new JsonObject();
		json.addProperty("result", dao.closeAccount(uid));
		json.addProperty("uid", uid);
		
		return json.toString();
	}
	
	public String selectCountNick(String nick) {
		JsonObject json = new JsonObject();
		json.addProperty("result", dao.selectCountNick(nick));
		
		return json.toString();
	}
}
