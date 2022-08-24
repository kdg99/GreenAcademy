package sub01;
/*
 * 날짜 : 2022/08/24
 * 이름 : 김동근
 * 내용 : Java 클래스 객체 실습하기
 * 
 * 클래스와 객체
 *  - 클래스는 객체를 생성하는 구조체이고 속성(필드)과 기능(메서드)으로 구성
 *  - 객체는 클래스의 실제 인스턴스이며 new 연산으로 생성
 */
public class ClassTest {

	public static void main(String[] args) {

		// 객체 생성
		Car sonata = new Car();
		
		// 객체 속성 초기화
		sonata.color = "Gold";
		sonata.name = "소나타";
		sonata.speed = 0;
		
		//객체 기능 실행
		sonata.speedUp(100);
		sonata.speedDown(40);
		sonata.show();
		
		Car bmw = new Car();
		bmw.color = "남색";
		bmw.name = "bmw 520";
		bmw.speed = 0;
		
		bmw.speedUp(80);
		bmw.speedDown(30);
		bmw.show();
		
		// Account 객체 생성
		Account kb = new Account();
		kb.bank = "국민은행";
		kb.id = "123-123-213";
		kb.name = "김동근";
		kb.balance = 0;
		
		// 기능
		kb.deposit(100000);
		kb.withdraw(30000);
		kb.show();
		
		// Account 객체 생성, 초기화, 기능
		Account wr = new Account();
		wr.bank = "우리은행";
		wr.id = "123-23-4531";
		wr.name = "김동근";
		wr.balance = 10000;
		
		wr.deposit(50000);
		wr.withdraw(30000);
		wr.show();
		
		
	}

}
