package step07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/09/27
 * 이름 : 김동근
 * 내용 : 백준 난이도7 5번 문제
 */
public class _05 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int h;
		int n;
		int a=0;
		for (int i=0 ; i<t ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			st.nextToken();
			n = Integer.parseInt(st.nextToken());
			if (n%h == 0) {
				a = h*100 + n/h;
			}else
				a = n%h*100 + n/h+1;

			System.out.println(a);
		}
		
		
		br.close();
	} //main-end

}
