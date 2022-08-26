package step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/08/26
 * 이름 : 김동근
 * 내용 : 백준 난이도4 2번 문제
 * 변수 한 개 더 쓰기
 */
public class _02 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[9];
		int max = 0;
		int index = 0;
		
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i]>max) {
				max = arr[i];
				index = i+1;
			}
		}
		
		sb.append(max);
		sb.append("\n");
		sb.append(index);
		
		System.out.println(sb.toString());
		br.close();
		
		
	} // main-end

}
