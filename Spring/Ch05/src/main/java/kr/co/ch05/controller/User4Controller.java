package kr.co.ch05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch05.service.User4Service;
import kr.co.ch05.vo.User4VO;

@Controller
public class User4Controller {
	
	@Autowired
	private User4Service service;
	
	//list
	@GetMapping("/user4/list")
	public String list(Model model) {
		
		List<User4VO> users = service.selectUser4s();
		model.addAttribute("users", users);

		return "/user4/list";
	}
	
	//register
	@GetMapping("/user4/register")
	public String register() {
		return "/user4/register";
	}
	
	@PostMapping("/user4/register")
	public String register(User4VO vo) {
		service.insertUser4(vo);
		return "redirect:/user4/list";
	}

	
	//modify
	@GetMapping("/user4/modify")
	public String modify(Model model, String uid) {
		User4VO user = service.selectUser4(uid);
		model.addAttribute("user", user);
		return "/user4/modify";
	}
	@PostMapping("/user4/modify")
	public String modify(User4VO vo) {
		service.updateUser4(vo);
		return "redirect:/user4/list";
	}
	
	//delete
	@GetMapping("/user4/delete")
	public String delete(String uid) {
		service.deleteUser4(uid);
		return "redirect:/user4/list";
	}
	
	
}
