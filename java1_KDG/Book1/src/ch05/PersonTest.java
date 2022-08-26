package ch05;

public class PersonTest {
	
	public static void main(String[] args) {
		Person2 personKim = new Person2();
		personKim.name = "김유신";
		personKim.weight = 85.5;
		personKim.height = 180.0;
		
		Person2 personLee = new Person2("이순신", 175, 175);
	}
	
}
