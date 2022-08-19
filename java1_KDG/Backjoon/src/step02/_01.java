package step02;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/19
 * 이름 : 김동근
 * 내용 : 백준 난이도2 문제1번
 */
public class _01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a==b) System.out.println("==");
		else if(a>b) System.out.println(">");
		else System.out.println("<");
		
		sc.close();
	}
}
