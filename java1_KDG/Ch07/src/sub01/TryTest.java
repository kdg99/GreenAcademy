package sub01;
/*
 * 날짜 : 2022/09/05
 * 이름 : 김동근
 * 내용 : Java 예외처리 실습하기
 */
public class TryTest {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		//예외상황1 : 어떤 수를 0으로 나눌때
		int num1 = 1;
		int num2 = 0;
		
		int r1=0, r2=0, r3=0, r4=0;
		
		try {
			//예외가 발생 가능한 코드 로직
			r1 = num1 + num2;
			r2 = num1 - num2;
			r3 = num1 * num2;
			r4 = num1 / num2;
		}catch(ArithmeticException e) {
			// 예외가 발생했을 때 처리할코드 로직
			e.printStackTrace();
		}
		
		System.out.println("r1 : " + r1);
		System.out.println("r2 : " + r2);
		System.out.println("r3 : " + r3);
		System.out.println("r4 : " + r4);
		
		//예외상황2 : 배열의 인덱스 범위를 벗어났을 때
		int[] arr = {1,2,3,4,5};
		try {
			for(int i=0 ; i<=5 ; i++) {
			System.out.println("arr[i] : "+ arr[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		//예외상황3 : NULL 포인트 참조
		Animal animal = null;
		
		try {
			animal.move();
			animal.hunt();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//예외상황 4 : Casting 에러
		Animal a1 = new Tiger(); //업캐스팅
		Animal a2 = new Eagle(); //업캐스팅
		
		try {
			Eagle eagle = (Eagle) a1;
			eagle.hunt();
			eagle.move();
			
			Tiger tiger = (Tiger) a2;
			tiger.move();
			tiger.hunt();
		} catch (Exception e) {
			
		}finally {
			// 정리 코드
			System.out.println("캐스팅 완료...");
		}
		
				
		
		
		System.out.println("프로그램 종료...");
	}
	
}
