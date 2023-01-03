/*
날짜 : 2023//01/03
이름 : 김동근
내용 : 스프링 AOP 실습하기
*/
package kr.co.ch03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AOPMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		AOPService service = (AOPService) ctx.getBean("AOPService");
		
		System.out.println("===============================");
		service.insert();
		
		System.out.println("===============================");
		service.select();
		
		System.out.println("===============================");
		service.update();
		
		System.out.println("===============================");
		service.delete();
	}
}
