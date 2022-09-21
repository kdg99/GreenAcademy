package step07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/09/21
 * 이름 : 김동근
 * 내용 : 백준 난이도7 2번 문제
 */
public class _02 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int n = 1;			//지나는 방의 개수
		int count = 0;		//한겹당 늘어나는 수
		int border = 1;		//총 방의 개수 < 매번 한겹씩 늘어남
		
		while(true) {
			if(a <= border) break;
			count += 6;
			border += count;
			n++;
		}
		System.out.println(n);
		br.close();
	} //main-end

}
