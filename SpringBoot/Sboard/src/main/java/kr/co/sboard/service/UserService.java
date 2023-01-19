package kr.co.sboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDAO;
import kr.co.sboard.repository.UserRepo;
import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	@Autowired
	private UserRepo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public int insertUser(UserVO vo) {
		vo.setPass(passwordEncoder.encode(vo.getPass2()));
		int result = dao.insertUser(vo);
		
		return result;
	}
	public void selectUser() {}
	public TermsVO selectTerms() {
		return dao.selectTerms();
	}
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}
	
	
	//jpa
	public int countUser(String uid) {
		return repo.countByUid(uid);
	}
	
}
