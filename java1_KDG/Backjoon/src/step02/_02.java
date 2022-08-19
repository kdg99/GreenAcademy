package step02;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/19
 * 이름 : 김동근
 * 내용 : 백준 난이도2 문제2번
 */
public class _02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		switch (a/10) {
			case 10:
			case 9: System.out.println("A"); break;
			case 8: System.out.println("B"); break;
			case 7: System.out.println("C"); break;
			case 6: System.out.println("D"); break;
			default: System.out.println("F"); break;
		}
		sc.close();
	}
}
