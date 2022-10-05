package step08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 날짜 : 2022/10/05
 * 이름 : 김동근
 * 내용 : 백준 난이도8 1번 문제
 */
public class _02 {

	public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;            
        }
        return true;
    }
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min = Integer.parseInt(br.readLine());
		int max  = Integer.parseInt(br.readLine());
		br.close();
		List<Integer> list = new ArrayList<Integer>();
		int total = 0;
		
		for(int i=min ; i<=max ; i++) {
			if(isPrime(i))
				list.add(i);
		}
		for(int i : list) {
			total += i;
		}
		
		System.out.println(total);
		System.out.println(Collections.min(list));
		
		
	} //main-end

}
