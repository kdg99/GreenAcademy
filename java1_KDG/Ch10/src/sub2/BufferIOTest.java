package sub2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * 날짜 : 2022/09/13
 * 이름 : 김동근
 * 내용 : Java 버퍼 입출력 스트림 실습하기
 * 
 * 버퍼 스트림
 *  - 기본 입출력에 Buffer를 추가해서 빠른 입출력을 지원하는 스트림
 *  - 기본 입출력에 무조건 장착해야 실행 성능 향상
 */
public class BufferIOTest {

	public static void main(String[] args) {
		
		String path = "C:\\Users\\java1\\Desktop\\java.pdf";
		String target = "C:\\Users\\java1\\Desktop\\java2.pdf";
		
		
		try {
			//파일과 스트림 연결
			FileInputStream fis = new FileInputStream(path);
			FileOutputStream fos = new FileOutputStream(target);
			
			//보조스트림 생성 연결
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			while(true) {
				
				int value = bis.read();
				
				if(value == -1) { // 파일을 모두 읽었다면
					break;
				}
				
				bos.write(value);
				
			}
			// 스트림 해제
			bis.close();
			bos.close();
			fis.close(); 
			fos.close();
			
			
			System.out.println("쓰기완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try catch-end
		
		
		
	} //main-end
	
}
