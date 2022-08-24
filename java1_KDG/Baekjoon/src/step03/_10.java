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
 * 내용 : 백준 난이도3 문제10번
 */
public class _10 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer s = new StringTokenizer(br.readLine());
		int number = Integer.parseInt(s.nextToken());
		int maxN = Integer.parseInt(s.nextToken());
		
		String numberString = br.readLine();
		String[] nList = numberString.split(" ");
		
		for(int i=0 ; i<number ; i++) {
			if(Integer.parseInt(nList[i]) < maxN) bw.write(Integer.parseInt(nList[i])+" ");
		}
		bw.flush();
		bw.close();
	}// main-end
	
}
