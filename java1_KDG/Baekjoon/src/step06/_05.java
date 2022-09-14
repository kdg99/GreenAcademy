package step06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 날짜 : 2022/09/13
 * 이름 : 김동근
 * 내용 : 백준 난이도6 5번 문제
 */
public class _05 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] wordList = br.readLine().toUpperCase().split("");
		Map<String, Integer> alpList = new HashMap<>();
		
		for(String alp : wordList) {
			
			if(alpList.get(alp) == null) {
				alpList.put(alp, 1);
			}else {
				alpList.replace(alp, alpList.get(alp)+1);
			}
			
		} //각 알파벳 개수 세기
		
		int maxN = 0;
		for(String key : alpList.keySet()) {
			if(alpList.get(key) > maxN ) {
				maxN = alpList.get(key);
				sb.setLength(0);
				sb.append(key);
			}else if(alpList.get(key) == maxN) {
				sb.setLength(0);
				sb.append("?");
			}
		}
		
		System.out.println(sb.toString());
		br.close();
		
	} //main-end

}
