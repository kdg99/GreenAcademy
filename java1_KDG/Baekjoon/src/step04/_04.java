package step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/08/26
 * 이름 : 김동근
 * 내용 : 백준 난이도4 4번 문제
 */
public class _04 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();
		String[] arr = br.readLine().split(" ");
		int max = 0;
		int total = 0;
		for(int i=0 ; i<arr.length ; i++) {
			if(Integer.parseInt(arr[i]) > max) max=Integer.parseInt(arr[i]);
			total += Integer.parseInt(arr[i]);
		}
		System.out.println((double)100*total/(arr.length*max));
		br.close();
		
	} //main-end

}
