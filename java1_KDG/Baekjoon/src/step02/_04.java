package step02;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/19
 * 이름 : 김동근
 * 내용 : 백준 난이도2 문제4번
 */
public class _04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (a>0 && b>0) System.out.println(1);
		else if (a<0 && b>0) System.out.println(2);
		else if (a<0 && b<0) System.out.println(3);
		else System.out.println(4);
		
		
		sc.close();
	}
}
