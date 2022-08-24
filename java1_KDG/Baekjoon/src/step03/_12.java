package step03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/08/24
 * 이름 : 김동근
 * 내용 : 백준 난이도3 문제12번
 */
public class _12 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		
		while((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			StringBuilder sb = new StringBuilder();
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
			System.out.println(sb.toString());
		}
		
	} // main-end
}
