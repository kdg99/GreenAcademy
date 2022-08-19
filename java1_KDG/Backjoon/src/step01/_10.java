package step01;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/19
 * 이름 : 김동근
 * 내용 : 백준 난이도1 문제10번
 */
public class _10 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] list = {1,1,2,2,2,8};
		
		for(int i=0 ; i<=list.length-1 ; i++) {
			System.out.print(list[i] - sc.nextInt() + " ");
		}
		
		sc.close();
		
	}
}
