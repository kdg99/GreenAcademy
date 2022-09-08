package step06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/09/08
 * 이름 : 김동근
 * 내용 : 백준 난이도6 3번 문제
 */
public class _03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] alp = "abcdefghijklmnopqrstuvwxyz".split("");
		String word = br.readLine().toString();
		String[] words = word.split("");
		
		for (int i=0 ; i<alp.length ; i++) {
			boolean isExist = false;
			for (String w : words) {
				
				if(alp[i].equals(w)) {
					isExist = true;
				}
				if (isExist) {
					alp[i] = word.indexOf(w)+"";
					break;
				} 
			} // words for-end
			if(!isExist) { alp[i] = "-1"; }
		} // alp for-end
		
		for (String s : alp) {
			sb.append(s + " ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
