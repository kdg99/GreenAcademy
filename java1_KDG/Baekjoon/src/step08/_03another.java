package step08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 날짜 : 2022/10/14
 * 이름 : 김동근
 * 내용 : 백준 난이도8 3번 문제
 */
public class _03another {
	
	

	public static void main(String[] args) throws IOException {

		//변수 선언
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //입력받은 수
		int length = (int) Math.ceil(Math.sqrt(n));	 
		br.close();
		
		//1
		while(n!=1) {
			for(int i=2 ; i<1000000 ; i++) {
				if(n%i == 0) {
					System.out.println(i);
					n/=i;
					break;
				}
			}
			
		}
		
		
		/*
		// another
		for(int i=2; i<=Math.sqrt(n); i++){
            while (n%i == 0){
                System.out.println(i);
                n /= i;
            }
        }
        if(n != 1){
            System.out.println(n);
        }*/
		
	}
}

