package step07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/09/21
 * 이름 : 김동근
 * 내용 : 백준 난이도7 1번 문제
 */
public class _08 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char[] num1 = st.nextToken().toCharArray();
		char[] num2 = st.nextToken().toCharArray();
		int length = num1.length > num2.length ? num1.length : num2.length;
		char[][] answer = new char[2][length+1];
		
		//집어넣기
		for(int i=length ; i>0 ; i--) {
			if(num1.length - length + i -1 >= 0) {
				answer[0][i] = num1[num1.length - length + i -1];
			}
			if(num2.length - length + i -1 >= 0) {
				answer[1][i] = num2[num2.length - length + i -1];
			}
			
		}
		
		
		for(int j=0 ; j<=1 ; j++) {
			for(int i=0 ; i<=length ; i++) {
				System.out.printf("[%c]", answer[j][i]);
			}
			System.out.print("\n");
		}
		
	} //main-end

}
