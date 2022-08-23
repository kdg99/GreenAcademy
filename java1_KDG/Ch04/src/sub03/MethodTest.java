package sub03;
/*
 * 날짜 : 2022/08/23
 * 이름 : 김동근
 * 내용 : Java 메서드 실습하기
 * 
 * 메서드(Method)
 * 자주 사용하는 코드 로직을 모듈화한 구조체
 */
public class MethodTest {

	//전역 변수
	int num = 1;
	
	public static void main(String[] args) {

		// 메서드호출
		int r1 = func(1);
		int r2 = func(2);
		int r3 = func(3);
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		
		// 메서드 스택
		int total = sum(1,10);
		System.out.println(total);
		
	}// main-end
	
	
	// 메서드 정의
	// func
	public static int func(int x) {
		int y = x*2+3;
		return y;
	}// func-end
	
	// sum
	public static int sum(int start, int end) {
		// 지역변수
		int total = 0;
		
		for(int i=start ; i<=end ; i++) {
			total+=i;
		}
		
		return total;
	}// sum-end
	
}
