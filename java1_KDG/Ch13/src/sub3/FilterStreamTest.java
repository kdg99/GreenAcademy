package sub3;

import java.util.Arrays;
import java.util.List;

public class FilterStreamTest {
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("김유신", "김춘추", "장보고", "강감찬", "이순신", "김춘추");
		System.out.println(names);
		
		//중복제거
		names.stream().distinct().forEach((name) -> {System.out.println(name);});
		
		//김씨 성을 갖는 문자열 필터링
		names.stream().filter(name->name.startsWith("김")).forEach(name->System.out.println(name+" "));
		System.out.println();
	}
}
