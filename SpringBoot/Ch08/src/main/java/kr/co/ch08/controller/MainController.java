package kr.co.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@GetMapping(value = {"/", "/index"})
	public String index() {
		return "/index";
	}
	
	@GetMapping("/admin/success")
	public String adminSuccess() {
		return "/admin/success";
	}
	
	@GetMapping("/manager/success")
	public String managerSuccess() {
		return "/manager/success";
	}

	@GetMapping("/member/success")
	public String memberSuccess() {
		return "/member/success";
	}

	@GetMapping("/guest/success")
	public String guestSuccess() {
		return "/guest/success";
	}
	
	@GetMapping("/guest/login")
	public String guestLogin() {
		return "/guest/login";
	}
	
	@PostMapping("/guest/login")
	public String guestLogin(String uid, String pass) {
		return "/guest/login";
	}
	
	@GetMapping("/guest/loginSuccess")
	public String guestLoginSuccess() {
		return "/guest/loginSuccess";
	}
	
	
}
