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
		
		int n = System.in.read();
		int answer = n;
		Set<Integer> alpList = new HashSet<>();
		
		System.in.read();
		for(int i=0 ; i<n ; i++) {
			
			int now = 0;
			int save = 0;
			int before = 0;
			alpList.clear();
			
			while(now != 10) {
				 now = System.in.read();
				 save = now;
				 System.out.println(save);
				 System.in.read();
				 if(before != 0 && before != save) {
					 if(alpList.contains(before)) {answer--; break;}
					 alpList.add(before);
				 }	 
				 before = save;
			}
			
		} //for문-end
		
		//System.out.println(answer);
		
	} //main-end

}
