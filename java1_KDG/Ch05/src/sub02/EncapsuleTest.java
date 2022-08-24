package sub02;
/*
 * 날짜 : 2022/08/24
 * 이름 : 김동근
 * 내용 : Java 캡슐화 실습하기
 * 
 * 캡슐화(Encapsulation)
 *  - 캡슐화는 객체의 속성(필드)을 외부에서 참조하지 못하도록 객체의 정보를 은닉하는 특성
 *  - 클래스의 속성은 반드시 private 선언을 통해 캡슐화 해야한다.
 *  - 은닉된 정보의 안전한 참조를 위해 Getter, Setter를 정의한다.
 */
public class EncapsuleTest {
	public static void main(String[] args) {
		
		// 객체 생성과 초기화
		Car sonata = new Car("소나타","흰색",0);
	
		// Setter, Getter
		sonata.setColor("은색");
		
		// 기능
		sonata.speedUp(80);
		sonata.speedDown(20);
		sonata.show();
		
		
		//Account 객체 생성과 초기화
		Account ibk = new Account("기업", "173-2342-42", "김동근", 100000);
		
		//기능
		ibk.deposit(100000);
		ibk.withdraw(30000);
		ibk.show();
	}
}
