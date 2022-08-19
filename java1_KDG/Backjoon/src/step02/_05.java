package step02;

import java.util.Scanner;

/*
 * 날짜 : 2022/08/19
 * 이름 : 김동근
 * 내용 : 백준 난이도2 문제5번
 */
public class _05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		if (m>=45){
			m -= 45;
		}else if(h==0){
			h = 23;
			m = 60+m-45;
		}else {
			h -= 1;
			m = 60+m-45;
		}
		System.out.println(h +" "+ m);
		
		sc.close();
	}
}
