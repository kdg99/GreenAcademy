package step08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/10/17
 * 이름 : 김동근
 * 내용 : 백준 난이도8 5번 문제
 */
public class _05 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 1;
		int count = 0;
		while(n != 0){
			n = Integer.parseInt(br.readLine()); 
			count = 0;
			if(n == 0) break;
			
			for(int i=n+1 ; i<=2*n ; i++) {
				if(isPrime(i)) {
					count++;
				}
			}
			System.out.println(count);
		}
		
		
		
		br.close();
	} //main-end
	
	public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;            
        }
        return true;
    }

}
