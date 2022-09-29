package sub08;
/*
 * 날짜 : 2022/09/29
 * 이름 : 김동근
 * 내용 : 자바 총정리 연습문제
 */


public class Test02 {
	public static void main(String[] args) {

		String str1 = "Hello";
		String str2 = "World";
		
		System.out.println("str1 역순 : " + reverseStr(str1));
		System.out.println("str2 역순 : " + reverseStr(str2));
		
	} //main-end
	
	public static String reverseStr(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1 ; i>=0 ; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
}
