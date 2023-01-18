package kr.co.sboard.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ArticleController {

	@GetMapping("/list")
	public String list() {
		return "/list";
	}
	
	@GetMapping("/view")
	public String view() {
		return "/view";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "/modify";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "/delete";
	}
	
	
}
