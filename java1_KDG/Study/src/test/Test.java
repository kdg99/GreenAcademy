package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/08/26
 * 이름 : 김동근
 * 내용 : 그냥 품
 */
public class Test {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        String s;
		while((s = br.readLine()) != null) {
			sb.append(s+"\n");
		}
		System.out.println(sb.toString());
		br.close();
	} // main-end
}