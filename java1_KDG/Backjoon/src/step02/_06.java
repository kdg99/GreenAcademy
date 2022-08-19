package step02;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/19
 * 이름 : 김동근
 * 내용 : 백준 난이도2 문제6번
 */
public class _06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int am = sc.nextInt();
		int daym = h*60+m+am;
		
		if(daym >= 1440) daym -= 1440;
		
		System.out.printf("%d %d\n", daym/60, daym%60);
		
		sc.close();
	}
}
