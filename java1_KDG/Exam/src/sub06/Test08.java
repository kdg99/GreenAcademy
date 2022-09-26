package sub06;
/*
 * 날짜 : 2022/09/23
 * 이름 : 김동근
 * 내용 : 자바 총정리 연습문제
 */
public class Test08 {
	public static void main(String[] args) {
		
		int count = 0;
		for(int i=2 ; i<=100 ; i++) {
			if(isPrime(i)) {	
				System.out.print(i+" ");
				count++;
			}
		}
		System.out.printf("\n2~100까지 소수는 모두 %d개 입니다.", count);
	} //main-end

	private static boolean isPrime(int x) {
		
		for(int i=2; i<x ; i++) {
			if(x%i == 0) return false;
		}
		
		return true;
	}
}
