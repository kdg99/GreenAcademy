package step03;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/22
 * 이름 : 김동근
 * 내용 : 백준 난이도3 문제2번
 */
public class _02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0 ; i<n ; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println(a+b);
			
		}
		sc.close();
	}
}
