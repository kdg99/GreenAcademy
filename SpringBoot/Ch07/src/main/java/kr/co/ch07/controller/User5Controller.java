package kr.co.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch07.entity.User5Entity;
import kr.co.ch07.service.User5Service;
import kr.co.ch07.vo.User5VO;

@Controller
public class User5Controller {

	@Autowired
	User5Service service;
	
	@GetMapping("/user5/list")
	public String list(Model model) {
		List<User5Entity> users = service.selectUser5s();
		model.addAttribute("users", users);
		return "/user5/list";
	}
	
	//modify
	@GetMapping("/user5/modify")
	public String modify(Model model, String uid) {
		User5Entity user = service.selectUser5(uid);
		model.addAttribute("user", user);
		return "/user5/modify";
	}
	
	@PostMapping("/user5/modify")
	public String modify(User5Entity vo) {
		service.updateUser5(vo);
		return "redirect:/user5/list";
	}
	
	//register
	@GetMapping("/user5/register")
	public String register() {
		return "/user5/register";
	}
	
	@PostMapping("/user5/register")
	public String register(User5Entity vo) {
		service.insertUser5(vo);
		return "redirect:/user5/list";
	}
	
	//delete
	@GetMapping("/user5/delete")
	public String delete(String uid) {
		service.deleteUser5(uid);
		return "redirect:/user5/list";
	}
	
}
