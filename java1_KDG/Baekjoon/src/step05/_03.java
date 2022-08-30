package step05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
 * 날짜 : 2022/08/29
 * 이름 : 김동근
 * 내용 : 백준 난이도 5 3번 문제
 */
public class _03 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> hashList = new HashSet<>();
		int a, b, c;
		int count = 0;
		
		for(int i=1 ; i<=n ; i++) {
			a=0;
			b=0;
			c=0;
			int temp = i;
			
			if (temp > 99) { a=temp/100; temp%=100; }
			if (temp > 9) { b=temp/10; temp%=10; }
			c=temp;
			
			if(i>99) {
				hashList.add(Integer.valueOf(a-b));
				hashList.add(Integer.valueOf(b-c));
			}
			else {hashList.add(Integer.valueOf(b-c));
			}
			if(hashList.size() == 1) count++;
			
			hashList.clear();
		}
		
		System.out.println(count);
		br.close();
	} // main-end

}
