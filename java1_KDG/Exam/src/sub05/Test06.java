package sub05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;

/*
 * 날짜 : 2022/09/23
 * 이름 : 김동근
 * 내용 : 자바 총정리 연습문제
 * 
 * 윤년(Leap Year)
 *  - 4년마다 2월을 하루 늘린 해
 *  - 4로 나누어지고 100으로 나누어지지 않는 해
 *  - 400으로 나누어 떨어지는 해
 */
public class Test06 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		br.close();
		
		if((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) {
			System.out.printf("%d는 윤년 입니다.\n", year);
		}else {
			System.out.printf("%d는 평년 입니다.\n", year);
		}
		
		GregorianCalendar greCal = new GregorianCalendar();
		
		if(greCal.isLeapYear(year)) {
			System.out.printf("%d는 윤년 입니다.\n", year);
		}else {
			System.out.printf("%d는 평년 입니다.\n", year);
		}
		
	}
}
