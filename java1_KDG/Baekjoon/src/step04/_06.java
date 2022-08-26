package step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/08/26
 * 이름 : 김동근
 * 내용 : 백준 난이도4 6번 문제
 */
public class _06 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		for(int i=0 ; i<num ; i++) {
			
			st = new StringTokenizer(br.readLine());
			while(int temp = Integer.parseInt(st.nextToken()))!= null) {} 
			
		}
		
	} // main-end

}
