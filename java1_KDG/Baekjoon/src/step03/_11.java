package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/08/24
 * 이름 : 김동근
 * 내용 : 백준 난이도3 문제11번
 */
public class _11 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		while(true) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
			int c = a+b;
			
			if (c==0) break;
			
			bw.write(c+"\n");
		
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
