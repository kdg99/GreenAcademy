/*
	날짜 : 2023//01/02
	이름 : 김동근
	내용 : Maven 실습하기
*/
package kr.co.ch01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		Hello bean = (Hello) ctx.getBean("hello");
		bean.hello();
	}
}
