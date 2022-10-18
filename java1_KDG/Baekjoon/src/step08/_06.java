package step08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 날짜 : 2022/10/05
 * 이름 : 김동근
 * 내용 : 백준 난이도8 1번 문제
 */
public class _06 {

	static boolean[] prime = new boolean[10001];
	static List<Integer> primeList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int a;
		int b;
		
		get_prime();
		get_primeList();
		
		System.out.println(primeList);
		
		for(int i=0 ; i<t ; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			
		}
		
		
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
