package sub4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/*
 * 날짜 : 2022/09/14
 * 이름 : 김동근
 * 내용 : Java 프로퍼티 실습하기
 */
public class PropertiesTest {

	public static void main(String[] args) {

		//프로퍼티 파일 생성
		Properties prop = new Properties();
		prop.setProperty("A", "Apple");
		prop.setProperty("B", "Banana");
		prop.setProperty("C", "Cherry");
		
		System.out.println(prop);
		
		String path = "C:\\Users\\java1\\Desktop\\Fruit.properties";
		
		try {
			FileOutputStream fos = new FileOutputStream(path);
			prop.store(fos, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("프로퍼티 파일 생성완료...");
		
		//프로퍼티 객체 생성
		Properties propCities = new Properties();
		String target = "C:\\Users\\java1\\Desktop\\Cities.properties";
	
		try {
			FileInputStream fis = new FileInputStream(target);
			propCities.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(propCities);
		System.out.println(propCities.getProperty("kor"));
		System.out.println(propCities.getProperty("usa"));
		
		System.out.println("프로퍼티 객체 생성완료...");
	} //main-end

}
