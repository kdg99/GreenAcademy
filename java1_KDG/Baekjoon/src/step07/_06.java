package step07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/09/28
 * 이름 : 김동근
 * 내용 : 백준 난이도7 6번 문제
 */
public class _06 {

	public static int people (int floor, int index){

		if(floor==0) return index;
		if(index==1) return 1;
		return people(floor-1, index) + people(floor,index-1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<t ; i++) {
			System.out.println(people(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
		}
		
		br.close();	
	} //main-end

}
