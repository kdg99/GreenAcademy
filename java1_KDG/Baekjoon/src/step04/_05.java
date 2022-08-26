package step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/08/26
 * 이름 : 김동근
 * 내용 : 백준 난이도4 5번 문제
 */
public class _05 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String[] list = null;
		for(int i=0 ; i<num ; i++) {
			list = br.readLine().split("");
			int count = 0;
			int total = 0;
			for(String a : list) {
				if(a.equals("O")) {count+=1; total+=count;}
				else {count=0;}
			}
			System.out.println(total);
		}
		
		br.close();
	
	} //main-end

}
