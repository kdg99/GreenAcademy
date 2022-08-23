package step02;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/19
 * 이름 : 김동근
 * 내용 : 백준 난이도3 문제1번
 */
public class _07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int res,max;
		
		if(a==b && a==c) {
			res = 10000+a*1000;
		}else if (a==b||b==c||a==c) {
			if (a==b) max = a;
			else max = c;
			res = 1000+max*100;
		}else {
			max = (a>b&&a>c) ? a : b>c ? b:c;
			res = max*100;
		}
		System.out.println(res);
		
		sc.close();
	}
}
