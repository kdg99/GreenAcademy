package step03;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/22
 * 이름 : 김동근
 * 내용 : 백준 난이도3 문제3번
 */
public class _03 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		
		for(int i=1 ; i<=n ; i++) sum += i;
		System.out.println(sum);
		
		sc.close();
		
	}
}
