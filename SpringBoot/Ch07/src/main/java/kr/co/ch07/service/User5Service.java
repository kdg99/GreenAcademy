package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.persistence.User5Repo;
import kr.co.ch07.entity.User5Entity;

@Service
public class User5Service {
	
	@Autowired
	private User5Repo repo;
	
	public void insertUser5(User5Entity entity) {
		repo.save(entity);
	}
	
	public User5Entity selectUser5(String uid) {
		return repo.findById(uid).get();
	}
	
	public List<User5Entity> selectUser5s() {
		return repo.findAll();
	}
	
	public void updateUser5(User5Entity entity) {
		repo.save(entity);
	}
	
	public void deleteUser5(String uid) {
		repo.deleteById(uid);
	}
	
}
