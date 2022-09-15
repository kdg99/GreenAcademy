package step06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/09/15
 * 이름 : 김동근
 * 내용 : 백준 난이도6 7번 문제
 */
public class _07 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		boolean aorb = false;
		//구분
		//3항연산자로 바꿔볼 것
		if(a%10 > b%10) aorb = true;
		else if(a%10 == b%10) {
			if (a%100 > b%100) aorb = true;
			else if (a%100 == b%100) {
				if (a/100 > b/100) aorb = true;
			}
		}
		
		//출력
		if (aorb) sb.append(Integer.toString(a)).reverse();
		else sb.append(Integer.toString(b)).reverse();
		
		System.out.println(sb);
		
		br.close();
	} //main-end

}
