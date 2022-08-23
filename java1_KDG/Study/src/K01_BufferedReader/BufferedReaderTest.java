package K01_BufferedReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BufferedReaderTest {
	public static void main(String[] args) throws IOException { //throws IOException 추가해줘야 에러 X
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine()); //버퍼는 String으로만 받기 때문에 형변환을 해줘야 한다.
		
		//공백 단위로 입력받는 경우 사용
		StringTokenizer st = new StringTokenizer(br.readLine()); //먼저 st에 한 줄을 입력 받는다
		int first = Integer.parseInt(st.nextToken()); //첫 번째 데이터 호출
		int second = Integer.parseInt(st.nextToken()); //공백 단위로 다음 데이터를 호출
		
		//혹은 String.split으로 배열에 공백 단위로 끊어서 데이터를 넣고 사용하는 방식
		String s_2way = br.readLine(); //for String
		StringTokenizer st_2way = new StringTokenizer(s_2way); 
		String array[] = s_2way.split(" ");
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //할당된 버퍼에 값 넣어주기
		String sW = "출력할 문자열";
		bw.write(sW+"\n"); //버퍼에 있는 값 전부 출력
		bw.flush(); //남아 있는 데이터를 모두 출력시킴
		bw.close(); //스트림을 닫음
		
	}
}
