package step05;

import java.util.ArrayList;

/*
 * 날짜 : 2022/08/29
 * 이름 : 김동근
 * 내용 : 백준 난이도 5 2번 문제
 */
public class _02 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=1 ; i<10000 ; i++) {
			list.add(i);
		}
		for(int i=10000 ; i>=1 ; i--) {
			int x = i;
			int y = x+(x/1000);
			while(x>=1000) x-=1000;
			y += (x/100);
			while(x>=100) x-=100;
			y += ((x/10) + (x%10));
			
			list.remove(Integer.valueOf(y));
		}
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
	}

}
