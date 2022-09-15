package step06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/09/14
 * 이름 : 김동근
 * 내용 : 백준 난이도6 5번 문제
 */
public class _05another {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] alpList = br.readLine().toCharArray();
		int[] countList = new int[26];
		int max = 0;
		char res = '?';
		
		for(char c : alpList) {
			if(c > 90) c -= 32;
			countList[c-65] += 1;
		}
		
		for (int a=0 ; a<26 ; a++) {
			if(countList[a] > max) {
				max = countList[a];
				res = (char)(65+a);
			}else if(countList[a] == max) {
				res = '?';
			}
		}
		
		System.out.println(res);
		
		br.close();
		
	} //main-end

}
