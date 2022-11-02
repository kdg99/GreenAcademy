package _01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_JadenCase {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		String[] words = br.readLine().split(" ");
		for(String ss : words){
            answer.append(ss.substring(0,1).toUpperCase());
                answer.append(ss.substring(1).toLowerCase());
                answer.append(" ");
        }
		answer.setLength(answer.length()-1);
		System.out.println(answer.toString());
	}
}
