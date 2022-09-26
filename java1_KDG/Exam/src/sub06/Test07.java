package sub06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/09/23
 * 이름 : 김동근
 * 내용 : 자바 총정리 연습문제
 * 
 * BMI
 *  - BMI(Body Mass Index) 체질량 지수
 *  - 몸무게를 키의 제곱으로 나눈 치수
 */
public class Test07 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a =0, b=0, c=0;
		
		try {
			System.out.print("첫번째 수: ");
			a = Integer.parseInt(br.readLine());
			System.out.print("두번째 수: ");
			b = Integer.parseInt(br.readLine());
			System.out.print("세번째 수: ");
			c = Integer.parseInt(br.readLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.printf("가장 큰 수는 %d입니다.", larger(larger(a, b), c));
	} //main-end
	
	public static int larger(int a, int b) {
		return (a>b) ? a:b;
	}
	
}
