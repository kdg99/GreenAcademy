package step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/08/96
 * 이름 : 김동근
 * 내용 : 백준 난이도4 6번 문제
 */
public class _06 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<num ; i++) {
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			
			int total = 0;
					
			for(int j=1 ; j<list.size() ; j++) {
				total += list.get(j);
			}
			
			double avg = (double)total / list.get(0);
			int count = 0;
			
			for(int j=1 ; j<list.size() ; j++) {
				if(list.get(j)>avg) count++; 
			}
			System.out.printf("%.3f%%\n", (double)count / list.get(0) * 100);
			list.clear();
		}
		
	} // main-end

}
