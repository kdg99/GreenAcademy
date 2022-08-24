package step03;
/*
 * 날짜 : 2022/08/24
 * 이름 : 김동근
 * 내용 : 백준 난이도3 문제9번
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _09 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=n ; i++) {
			for(int k=n ; k>i ; k--) {
				bw.write(" ");
			}
			
			for(int j=0 ; j<i ; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}// main-end
}
