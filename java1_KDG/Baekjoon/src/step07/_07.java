package step07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/09/21
 * 이름 : 김동근
 * 내용 : 백준 난이도7 1번 문제
 */
public class _07 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		int a=0;
		if (n==4 || n==7) {
			System.out.println(-1);
		}else {
			switch(n%5){
			
				case 0:
					a = n/5;
					break;
				case 1:
					a = n/5 + 1;
					break;
				case 2:
					a = n/5 + 2;
					break;
				case 3:
					a = n/5 + 1;
					break;
				case 4:
					a = n/5 + 2;
					break;
			}
			System.out.println(a);
		}
	} //main-end

}
