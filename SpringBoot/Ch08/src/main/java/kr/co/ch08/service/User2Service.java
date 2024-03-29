package kr.co.ch08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.ch08.repository.User2Repo;
import kr.co.ch08.security.MyUserDetails;
import kr.co.ch08.vo.User2VO;

@Service
public class User2Service implements UserDetailsService{
	
	@Autowired
	private User2Repo repo;
	
	public void insertUser2(User2VO vo) {
		// Spring security 암호화 처리
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		vo.setPass(passEncoder.encode(vo.getPass()));
		
		repo.save(vo);
	}
	public User2VO selectUser2(String uid, String pass) {
		return repo.findUser2VOByUidAndPass(uid, pass);
	}
	public void selectUser2s() {}
	public void updateUser2() {}
	public void deleteUser2() {}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User2VO user = repo.findById(username).get();
		
		if(user == null) {
			System.out.println("user 없음...");
			throw new UsernameNotFoundException(username);
		}
		/*
		UserDetails ud = User
							.builder()
							.username(user.getUid()).password(user.getPass())
							.roles("ADMIN").build();
		
		return ud;
		*/
		MyUserDetails myUser = new MyUserDetails();
		myUser.setUid(user.getUid());
		myUser.setPass(user.getPass());
		myUser.setName(user.getName());
		myUser.setHp(user.getHp());
		myUser.setAge(user.getAge());
		myUser.setRdate(user.getRdate().toString());
		return myUser;
		
	}
	
	
	
}
