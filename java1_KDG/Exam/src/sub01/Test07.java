package sub01;

/*
 * 날짜 : 2022/08/19
 * 이름 : 김동근
 * 내용 : Java 1~10까지 2의 배수, 3의 배수 정수의 합 구하기
 */
public class Test07 {

	public static void main(String[] args) {

		int total = 0;
		
		for(int i=1 ; i<=10 ; i++) { 
			if((i%2==0) || (i%3==0)) total += i; 
		}
		
		System.out.println("1 ~ 10까지 2와 3배수의 정수의 합 : "+total);
		
	}//main-end

}
