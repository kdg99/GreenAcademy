package step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
 * 날짜 : 2022/08/26
 * 이름 : 김동근
 * 내용 : 백준 난이도4 3번 문제
 */
public class _03 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> hashList = new HashSet<>();
		int temp = 0;
		for (int i=0 ; i<10 ; i++) {
			temp = Integer.parseInt(br.readLine());
			hashList.add((temp%42));
		};
		
		System.out.println(hashList.size());
		
	} // main-end

}
