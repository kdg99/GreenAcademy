package step06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/09/07
 * 이름 : 김동근
 * 내용 : 백준 난이도6 2번 문제
 */
public class _02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] list = br.readLine().split("");
		int total = 0;
		
		for(int i=0 ; i<n ; i++) {
			total += Integer.parseInt(list[i]);
		}
		System.out.println(total);
	}

}
