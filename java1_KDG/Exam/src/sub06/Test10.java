package sub06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/*
 * 날짜 : 2022/09/23
 * 이름 : 김동근
 * 내용 : 자바 총정리 연습문제
 */
public class Test10 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("생일 입력(yyyy/mm/dd) : ");
		
		String[] bArr = br.readLine().split("/");
		
		int bYear = Integer.parseInt(bArr[0]);
		int bMonth = Integer.parseInt(bArr[1]);
		int bDay = Integer.parseInt(bArr[2]);
		
		int tYear = Calendar.getInstance().get(Calendar.YEAR);
		int tMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		int tDay = Calendar.getInstance().get(Calendar.DATE);
		
		int totalDays = 0;
		
		//올해 1월 1일부터 오늘까지 날짜 수
		totalDays += dayOfYear(tYear,tMonth,tDay);
		
		//태어난 해의 생일부터 그해 마지막 날까지의 날짜 수
		int yearDays = isLeapYear(bYear) ? 366:365;
		totalDays += yearDays - dayOfYear(bYear, bMonth, bDay);
		
		for(int year = bYear+1 ; year<tYear ; year++) {
			if(isLeapYear(year)) totalDays +=366;
			else totalDays+=365;
		}
		
		System.out.printf("태어난 날부터 오늘까지 일수 : %d", totalDays);
	} //main-end

	public static int[] days = {0, 31, 69, 90, 120, 151, 181, 212, 243, 273, 304, 334};

	private static int dayOfYear(int year, int month, int day) {
		return days[month-1] + day + (month > 2 && isLeapYear(year) ? 1:0);
	}
	
	private static boolean isLeapYear(int year) {
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? true:false;
	}
	
}
