package kr.co.ch03.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Component
public class BeforeAdvice {
	//포인트컷 == 어드바이스가 들어온 조인포인트(메서드)
	//execution(반환타입 패키지.클래스.메서드(매개변수))
	@Pointcut("execution(* kr.co.ch03.AOPService.insert*(..))")
	public void insertPointcut() {}
	@Pointcut("execution(* kr.co.ch03.AOPService.select*(..))")
	public void selectPointcut() {}
	@Pointcut("execution(* kr.co.ch03.AOPService.update*(..))")
	public void updatePointcut() {}
	
	@Before("insertPointcut()")
	public void before1() {
		System.out.println("횡단관심 - before1...");
	}
	@Before("selectPointcut()")
	public void before2() {
		System.out.println("횡단관심 - before2...");
	}
	@Before("updatePointcut()")
	public void before3() {
		System.out.println("횡단관심 - before3...");
	}
}
