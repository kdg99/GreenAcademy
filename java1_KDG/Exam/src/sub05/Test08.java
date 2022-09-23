package sub05;
/*
 * 날짜 : 2022/09/23
 * 이름 : 김동근
 * 내용 : 자바 총정리 연습문제
 */
public class Test08 {
	public static void main(String[] args) {
		
		for(int y=1 ; y<=9 ; y++) {
			
			for(int x=2 ; x<=9 ; x++) {
				System.out.printf("%d x %d = %3d\t", x, y, x*y);
			}
			System.out.println();
		}
		
	}
}
