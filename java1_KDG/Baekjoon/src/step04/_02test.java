package step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/08/26
 * 이름 : 김동근
 * 내용 : 백준 난이도4 2번 문제
 * for문 한 번 더 쓰기
 */
public class _02test {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[9];
		int max = 0;
		
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i] == max) {
				sb.append(arr[i]);
				sb.append("\n");
				sb.append((i+1));
				break;
			}
		}
		
		System.out.println(sb.toString());
		br.close();
		
		
	} // main-end

}
