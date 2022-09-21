package sub3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sub2.Person;
/*
 * 날짜 : 2022/09/20
 * 이름 : 김동근
 * 내용 : Java 맵 스트림 실습하기
 * 
 * 내,외부 반복자
 */
public class MapStreamTest {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("김유신",25));
		list.add(new Person("김춘추",23));
		list.add(new Person("장보고",23));
		list.add(new Person("강참찬",24));
		list.add(new Person("이순신",25));
	
		//map
		list.stream().map(p->p.getName().substring(1)).forEach(name->System.out.println(name + ""));
		//flatMap
		List<String> names = Arrays.asList("김유신,김춘추", "장보고,강감찬", "이순신,정약용");
		names.stream().flatMap(name -> Arrays.stream(name.split(","))).forEach(name -> System.out.print(name+ " "));

		//외부 반복자 처리
		System.out.println(names);
		
		for(String name : names) {
			String[] values = name.split(",");
			
			for(String value : values) {
				System.out.print(value + " ");
			}
		}
		
	}
}
