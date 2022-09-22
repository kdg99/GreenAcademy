package step07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/09/21
 * 이름 : 김동근
 * 내용 : 백준 난이도7 4번 문제
 */
public class _04 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		if ((v-a) % (a-b) == 0) {
			System.out.println(((v-a) / (a-b))+1);
		}else {
			System.out.println(((v-a) / (a-b))+2);
		}
		
		
		
	} //main-end

}
