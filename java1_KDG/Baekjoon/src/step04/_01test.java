package step04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/08/26
 * 이름 : 김동근
 * 내용 : 백준 난이도4 1번 문제
 * 버퍼라이터
 */
public class _01test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		int min = 1000000;
		int max = -1000000;
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<num ; i++) {
			
			int temp = Integer.parseInt(st.nextToken());
			if (temp > max) max = temp;
			if (temp < min) min = temp;
			
		}
		
		bw.write(min + " " + max);
		bw.flush();
		bw.close();
		br.close();
		
	} // main-end

}
