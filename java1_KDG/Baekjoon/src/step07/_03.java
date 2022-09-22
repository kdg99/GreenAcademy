package step07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/09/21
 * 이름 : 김동근
 * 내용 : 백준 난이도7 3번 문제
 */
public class _03 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 1; // 총 분수의 개수
		int x = 1;		// 매 줄마다 증가하는 count값
		int y = 1;		// 왼쪽 혹은 오른쪽에서 몇 번째인지
		boolean isLeft = true; //왼쪽부터 세는지 오른쪽부터 세는지
		
		while(true) {
			if(n <= count) {
				y = n - (count-x);
				break;
			};
			
			if(isLeft) isLeft = false;
			else isLeft = true;
			x++;
			count += x;
		}
		
		if(isLeft) System.out.println((x+1-y) + "/" + y);
		else System.out.println(y + "/" + (x+1-y));
		
		br.close();
	} //main-end

}
