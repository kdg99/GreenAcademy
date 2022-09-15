package step06;

import java.io.IOException;

/*
 * 날짜 : 2022/09/15
 * 이름 : 김동근
 * 내용 : 백준 난이도6 8번 문제
 */
public class _08 {

	public static void main(String[] args) throws IOException {
		
		//char는 int로 바꿔도 된다.
		char b = 0;
		int total = 0;
		
		//'\n' 사용해도 된다
		while(b != 10) {
			b = (char) System.in.read();
			
			if (b >= 'A' && b <= 'C') total += 3;
			else if(b >= 'D' && b <= 'F') total += 4;
			else if(b >= 'G' && b <= 'I') total += 5;
			else if(b >= 'J' && b <= 'L') total += 6;
			else if(b >= 'M' && b <= 'O') total += 7;
			else if(b >= 'P' && b <= 'S') total += 8;
			else if(b >= 'T' && b <= 'V') total += 9;
			else if(b >= 'W' && b <= 'Z') total += 10;
		} //while-end
		
		System.out.println(total);
		
	} //main-end

}
