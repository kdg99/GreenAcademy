package step01;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/19
 * 이름 : 김동근
 * 내용 : 백준 난이도1 문제9번
 */
public class _09 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int gab = 2541-1998;
		int by = sc.nextInt();
		
		System.out.println(by-gab);
		sc.close();
	}
}
