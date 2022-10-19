package step08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/10/19
 * 이름 : 김동근
 * 내용 : 백준 난이도8 6번 문제
 */
public class _06 {

	static boolean[] prime = new boolean[10001];			//소수 리스트를 만들기 위해 미리 소수 판별
	static List<Integer> primeList = new ArrayList<>();		//소수만을 담을 리스트
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int n;
		int a = 0, b = 0;
		
		get_prime();
		get_primeList();
		
		
		for(int i=0 ; i<t ; i++) {
			
			n = Integer.parseInt(br.readLine());
			int j = 0;
			while(primeList.get(j) <= n/2) {	//N의 반절까지 증가하며 계산 -> 마지막 a,b 값의 차가 가장적다
				
				if(primeList.contains(n-primeList.get(j))) {	//n-소수 = 소수인지 판별
					a = primeList.get(j);
					b = n-primeList.get(j);
				}
				j++;
			}
			sb.append(a+" "+b+"\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	} //main-end

	
	// 소수를 얻는 메소드
    public static void get_prime() {
        // 0 과 1 은 소수가 아니므로 true
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
    
    // 소수 리스트 메소드
    public static void get_primeList() {
    	int i = 0;
    	for(boolean isPrime : prime) {
    		if(!isPrime) {primeList.add(i);}
    		i++;
    	}
    }
}
