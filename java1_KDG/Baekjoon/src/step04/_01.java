package step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/08/26
 * 이름 : 김동근
 * 내용 : 백준 난이도4 1번 문제
 * 스트링빌더
 */
public class _01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		int min = 1000000;
		int max = -1000000;
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<num ; i++) {
			
			int temp = Integer.parseInt(st.nextToken());
			if (temp > max) max = temp;
			if (temp < min) min = temp;
			
		}
		
		sb.append(min);
		sb.append(" ");
		sb.append(max);
		
		System.out.println(sb.toString());
		
		br.close();
		
	} // main-end

}
