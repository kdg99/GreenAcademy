package sub01;
/*
 * 날짜 : 2022/08/30
 * 이름 : 김동근
 * 내용 : 정기 수행 평가 01. 프로그래밍 언어 활용
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class printAsterLeft {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<=i ; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	} // main-end
	
}


