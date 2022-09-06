package sub1;
/*
 * 날짜 : 2022/09/05
 * 이름 : 김동근
 * 내용 : Object 클래스 실습하기
 */
public class ObjectTest {
	public static void main(String[] args) {
		
		Apple a1 = new Apple("한국", 5000);
		Apple a2 = new Apple("일본", 4000);
		
		a1.show();
		a2.show();
		
		if( a1==a2 ) {
			System.out.println("a1과 a2 주소값이 같다");
		}else {
			System.out.println("a1과 a2 주소값이 다르다");
		}
		
		if( a1.equals(a2) ) {
			System.out.println("a1과 a2 객체가 같다");
		}else {
			System.out.println("a1과 a2 객체가 다르다");
		}
		
		// toString() : 객체정보
		a1.toString();
		a2.toString();
		
	}
}
