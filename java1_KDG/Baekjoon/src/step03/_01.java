package step03;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/22
 * 이름 : 김동근
 * 내용 : 백준 난이도3 문제1번
 */

public class _01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=1 ; i<10 ; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num*i);
		}

		sc.close();
		
	}
}
