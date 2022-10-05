package step08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/10/05
 * 이름 : 김동근
 * 내용 : 백준 난이도8 1번 문제
 */
public class _01 {

	public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;            
        }
        return true;
    }
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		
		while(st.hasMoreTokens()) {
			if(isPrime(Integer.parseInt(st.nextToken())))
				count++;
		}
		System.out.println(count);
		br.close();
	} //main-end

}
