package test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
 * 날짜 : 2022/08/26
 * 이름 : 김동근
 * 내용 : 그냥 품
 */
public class Test {

	public static void main(String[] args) throws IOException {

		Set<String> alpList = new HashSet<>();
		
		String b = "h";
		alpList.add(b);
		String c = "he";
		System.out.println(c == b);
		
	} // main-end
}