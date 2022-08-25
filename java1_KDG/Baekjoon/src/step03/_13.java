package step03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/08/25
 * 이름 : 김동근
 * 내용 : 백준 난이도3 문제13번
 * 
 * 0 <= n <= 99 O
 * 숫자 받고 기억 O
 *  - a에 받은 숫자 기입 O
 * 반복문 진입 O
 * 숫자변환 알고리즘
 *  - a 자릿수 세고 0추가 O << 필요없음
 *  - b에 2+6 넣기 O
 *  - a에 새 숫자 넣기
 * 반복횟수 기억 O
 * 첫 숫자와 같으면 break O
 */
public class _13 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int firstNum = Integer.parseInt(br.readLine());
		int count = 0;
		int a = firstNum; 
		int b;
		
		do {
			b = (a/10) + (a%10);	//b에 값 넣기
			a = Integer.parseInt(a%10+""+b%10); //a에 새 숫자 넣기
			count += 1;
			if (firstNum==a) break;
		}while(true);
		System.out.println(count);
		
	} // main-end
	
}
