package step06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/09/07
 * 이름 : 김동근
 * 내용 : 백준 난이도6 4번 문제
 */
public class _04 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tn = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<tn ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			for(int j=0 ; j<s.length() ; j++ ) {
				
				for(int k=0 ; k<n ; k++) {
					
					sb.append(s.charAt(j));
					
				}

			} //문자 추가 for문 종료
			sb.append("\n");
		} //테스트 for문 종료
	
		System.out.println(sb);
		br.close();
	} //main-end

}
