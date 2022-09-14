package step06;

import java.io.IOException;

/*
 * 날짜 : 2022/09/14
 * 이름 : 김동근
 * 내용 : 백준 난이도6 6번 문제
 */
public class _06another {

	public static void main(String[] args) throws IOException {
		
		int count = 0;
		int pre_str = 32;	// 공백을 의미한다.
		int str ;
		
		
		while(true) {
			str = System.in.read();
            
			// 입력받은 문자가 공백일 때,
			if(str == 32) {
				// 이전의 문자가 공백이 아니면
				if(pre_str != 32) count++;
			}
 
			// 입력받은 문자가 개행일때 ('\n')
			else if(str == 10) {
				// 이전의 문자가 공백이 아니면
				if(pre_str != 32) count++;
				break;
			}
			
			pre_str = str;
			
		}
		
		System.out.println(count);
		
	} //main-end

}
