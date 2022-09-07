package sub4;
/*
 * 날짜 : 2022/09/07
 * 이름 : 김동근
 * 내용 : Java Math 클래스 실습하기
 */
public class MathTest {
	public static void main(String[] args) {
		
		
		//수학관련 메서드
		System.out.println("절대값 : " + Math.abs(-5));
		System.out.println("제곱근 : " + Math.sqrt(9));
		System.out.println("올림값 : " + Math.ceil(1.2));
		System.out.println("올림값 : " + Math.ceil(1.8));
		System.out.println("내림값 : " + Math.floor(1.2));
		System.out.println("내림값 : " + Math.floor(1.8));
		System.out.println("반올림 : " + Math.round(1.2));
		System.out.println("반올림 : " + Math.round(1.8));
		
		//random
		double num1 = Math.random();
		System.out.println("num1 : " + num1); //0~1 사이의 실수
		
		double num2 = Math.random()*10;
		System.out.println("num1 : " + num2); //1~10 사이의 실수
		System.out.println("num1 : " + Math.ceil(num2)); //1~10 사이의 정수
		
		int rNum = (int) Math.ceil(Math.random()*10);
		
	}
}
