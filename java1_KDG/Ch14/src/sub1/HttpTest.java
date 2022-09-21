package sub1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpTest {
	/*
	 * 날짜 : 2022/09/21
	 * 이름 : 김동근
	 * 내용 : Java HTTP 통신 실습하기
	 * 
	 * HTTP 통신
	 *  - TCP/IP 프로토콜을 이용한 단방향 통신 (Stateless)
	 *  - 일반적인 웹 프로그래밍은 HTTP 통신을 이용
	 */
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://google.com");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String line = null;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			
			br.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} //main-end

}
