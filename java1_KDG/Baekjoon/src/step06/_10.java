package step06;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
/*
 * 날짜 : 2022/09/19
 * 이름 : 김동근
 * 내용 : 백준 난이도6 10번 문제
 */
public class _10 {

	public static void main(String[] args) throws IOException {
		
		int n = System.in.read()-48;
		int answer = n;
		Set<Integer> alpList = new HashSet<>();
		
		System.in.skip(2); //줄바꿈 스킵
		
		for(int i=0 ; i<n ; i++) { //받은 개수만큼 돌리기
			
			int now = 0;
			int before = 0;
			alpList.clear(); //매 단어마다 초기화
			
			while(true) {
				 now = System.in.read(); //단어 한글자씩 받아오기
				 if(now == 10) {
					 System.in.skip(2);
					 break; // 13일 때는 돌아가야 마지막 단어까지 체크 가능
				 }
				 
				 if(before != 0 && before != now) { //이전 문자와 다른 경우
					 if(alpList.contains(before)) { //이전 문자가 집합에 들어가 있는지
						 answer--;
						 System.in.skip(100);
						 break;
					 }
					 else {
						 alpList.add(before);		//없으면 추가
					 }
				 }
				 before = now;
			} //while-end
			
		} //for문-end
		
		System.out.println(answer);
		
	} //main-end

}
