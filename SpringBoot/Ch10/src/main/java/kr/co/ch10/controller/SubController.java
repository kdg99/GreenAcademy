package kr.co.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SubController {
	
	@GetMapping("/hello")
	public String hello() {
		
		log.trace("hello trace 로그...");
		log.debug("hello debug 로그...");
		log.info("hello info 로그...");
		log.warn("hello warn 로그...");
		log.error("hello error 로그...");
		
		return "/hello";
	}
	
	@GetMapping("/welcome")
	public String welcome() {

		log.trace("welcome trace 로그...");
		log.debug("welcome debug 로그...");
		log.info("welcome info 로그...");
		log.warn("welcome warn 로그...");
		log.error("welcome error 로그...");
		
		return "/welcome";
	}
	
	@GetMapping("/greeting")
	public String greeting() {
		return "/greeting";
	}
}
