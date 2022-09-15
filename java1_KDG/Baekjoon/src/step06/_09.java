package step06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/09/15
 * 이름 : 김동근
 * 내용 : 백준 난이도6 9번 문제
 */
public class _09 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		s = s.replace("c=", " ");
		s = s.replace("c-", " ");
		s = s.replace("dz=", " ");
		s = s.replace("d-", " ");
		s = s.replace("lj", " ");
		s = s.replace("nj", " ");
		s = s.replace("s=", " ");
		s = s.replace("z=", " ");
		
		System.out.println(s.length());
		
		br.close();
	} //main-end

}
