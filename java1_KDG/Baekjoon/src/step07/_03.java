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
		int x = 1;
		int y = 1;
		boolean isLeft false;
		
		while(true) {
			if(n <= count) {
				y = count % x;
				break
			};
			
			x++;
			count += x;
		}
		
		br.close();
	} //main-end

}
