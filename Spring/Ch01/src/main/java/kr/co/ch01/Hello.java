/*
	날짜 : 2023//01/02
	이름 : 김동근
	내용 : Maven 실습하기
*/

package kr.co.ch01;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class Hello {
	
	@GetMapping("/hello")
	public void hello() {
		System.out.println("Hello Spring!");
	}
}
