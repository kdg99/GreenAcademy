package step03;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/22
 * 이름 : 김동근
 * 내용 : 백준 난이도3 문제4번
 */
public class _04 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int totalPrice = sc.nextInt();
		int totalKind = sc.nextInt();
		int guess = 0;
		
		for(int i=0 ; i<totalKind ; i++) {
			
			int price = sc.nextInt();
			int amount = sc.nextInt();
			
			guess += (price*amount);
			
		}
		
		if(totalPrice == guess) System.out.println("Yes");
		else System.out.println("No");
		
		sc.close();
		
	}//main-end
}
