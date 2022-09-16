package step06;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
/*
 * 날짜 : 2022/09/07
 * 이름 : 김동근
 * 내용 : 백준 난이도6 2번 문제
 */
public class _10 {

	public static void main(String[] args) throws IOException {
		
		int n = System.in.read()-48;
		int answer = n;
		Set<Integer> alpList = new HashSet<>();
		
		System.in.read();
		System.in.read();
		
		for(int i=0 ; i<n ; i++) {
			
			int now = 0;
			int before = 0;
			alpList.clear();
			
			while(true) {
				 now = System.in.read();
				 if(now == 13) break;
				 if(before != 0 && before != now) {
					 if(alpList.contains(before)) {answer--; break;}
					 alpList.add(before);
				 }	 
				 before = now;
			}
			
		} //for문-end
		
		System.out.println(answer);
		
	} //main-end

}
