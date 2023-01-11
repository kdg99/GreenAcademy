package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.entity.User1Entity;
import kr.co.ch07.persistence.User1Repo;

@Service
public class User1Service {

	//JPA
	@Autowired
	private User1Repo repo;
	
	public void insertUser1(User1Entity entity) {
		repo.save(entity);
	}
	
	public User1Entity selectUser1(String uid) {
		User1Entity user = repo.findById(uid).get();
		return user;
	}
	
	public List<User1Entity> selectUser1s() {
		List<User1Entity> users = repo.findAll();
		return users;
	}
	
	public void updateUser1(User1Entity entity) {
		repo.save(entity);
	}
	
	public void deleteUser1(String uid) {
		repo.deleteById(uid);
	}
	
}
