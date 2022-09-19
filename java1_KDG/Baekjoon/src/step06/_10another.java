package step06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
/*
 * 날짜 : 2022/09/19
 * 이름 : 김동근
 * 내용 : 백준 난이도6 10번 문제
 */
public class _10another {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = n;
		Set<String> alpList = new HashSet<>();
		
		
		for(int i=0 ; i<n ; i++) { //받은 개수만큼 돌리기
			
			String[] st = br.readLine().split("");
			String now = "";
			String before = "";
			alpList.clear(); //매 단어마다 초기화
			
			for(String s : st) {
				now = s;
				System.out.println(alpList);
				if( !before.equals("") && !before.equals(now)) {
					if(alpList.contains(before)) {
						answer--;
						break;
					}else {
						alpList.add(before);		//해쉬에 추가하는 순서를 바꿀 것 > now를 추가해본다.
					}
				}
				before = now;
				
			} //for-end
			
		} //for문-end
		
		System.out.println(answer);
		
	} //main-end

}
