package kr.co.ch08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch08.service.User2Service;

@Controller
public class User2Controller {
	
	@Autowired
	private User2Service service;
	
	@GetMapping("/user2/login")
	public String login() {
		return "/user2/login";
	}

	@GetMapping("/user2/loginSuccess")
	public String loginSuccess() {
		return "/user2/loginSuccess";
	}
	
	@GetMapping("/user2/logout")
	public String logout() {
		return "redirect:/user2/login";
	}
	
}
