package sub01;
/*
 * 날짜 : 2022/08/30
 * 이름 : 김동근
 * 내용 : 정기 수행 평가 01. 프로그래밍 언어 활용
 */

import java.io.IOException;

public class printAsterHard {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringBuilder sb = new StringBuilder();
		int n1 = 5;
		for(int i=0 ; i<n1 ; i++) {
			for(int j=n1-1 ; j>i ; j--) { sb.append("☆"); }
			for(int j=0 ; j<=i ; j++) { sb.append("★"); }
			sb.append("\n");
		}
		
		sb.append("\n");
		int n2 = 4;
		for(int i=1 ; i<=n2 ; i++) {
			for(int j=n2-i ; j>0 ; j--) { sb.append("☆"); }
			for(int j=1 ; j<i*2 ; j++) { sb.append("★"); }
			for(int j=n2-i ; j>0 ; j--) { sb.append("☆"); }
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	} // main-end
	
}


