package sub1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 날짜 : 2022/09/13
 * 이름 : 김동근
 * 내용 : Java 파일 입출력 스트림 실습하기
 *
 * 파일 입출력(I/O)
 *  - 파일(File)은 컴퓨터 저장매체에 저장되는 데이터 묶음
 *  - 프로그램은 데이터 처리와 함께 저장하기 위해 파일 입출력을 수행
 *  - 파일 입출력을 위해 스트림(Stream)을 연결해야 됨
 */
public class FileIOTest {
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\java1\\Desktop\\Sample1.txt";
		String target = "C:\\Users\\java1\\Desktop\\Sample2.txt";
		
		
		try {
			FileInputStream fis = new FileInputStream(path);
			FileOutputStream fos = new FileOutputStream(target);
			
			while(true) {
				
				int value = fis.read();
				
				if(value == -1) { // 파일을 모두 읽었다면
					break;
				}
				
				char c = (char) value;
				System.out.print(c);
				fos.write(value);
				
			}
			
			fis.close(); // 스트림 해제
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} //try catch-end
		
		
		
		
		
	} // main-end
	
}
