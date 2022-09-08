package step06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜 : 2022/09/08
 * 이름 : 김동근
 * 내용 : 백준 난이도6 3번 문제
 */
public class _03test {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(char c='a'; c<='z'; c++) {
            sb.append(str.indexOf(c)).append(" ");
        }
        System.out.println(sb);
	}

}
