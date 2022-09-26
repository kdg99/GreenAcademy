package sub06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/*
 * 날짜 : 2022/09/23
 * 이름 : 김동근
 * 내용 : 자바 총정리 연습문제
 * 
 * 윤년(Leap Year)
 *  - 4년마다 2월을 하루 늘린 해
 *  - 4로 나누어지고 100으로 나누어지지 않는 해
 *  - 400으로 나누어 떨어지는 해
 */
public class Test06 {
	
	public static void printArray(String tit, int[] array) {
	
		System.out.println(tit);
		for(int i=0 ; i<array.length ; i++)
			System.out.printf("%5d%s", array[i], (i%10==9) ? "\n":"");
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random random = new Random();
		int[] values = new int[30];
		
		for(int i=0 ; i<30 ; i++)
			values[i] = random.nextInt(100);
		
		printArray("정렬 전", values);
		Arrays.sort(values);
		printArray("정렬 후", values);
		
		System.out.print("=> 검색할 숫자 입력 : ");
		int findNum = Integer.parseInt(br.readLine());
		int count = 0;
		
		//선형탐색
		
		for(int i=0 ; i<values.length ; i++) {
			count++;
			if( values[i] == findNum ) {
				System.out.printf("values[%d] = %d\n", i, findNum);
				System.out.printf("선형탐색 비교 횟수 %d회\n", count);
				break;
			}
		}
		
		
		// 이진탐색
		count = 0;
		int low = 0;
		int high = values.length-1;
		
		while(low <= high) {
			count++;
			int mid = (low+high)/2;
			if(findNum == values[mid]) {
				System.out.printf("values[%d] = %d\n", mid, findNum);
				System.out.printf("이진탐색 비교 횟수 %d회\n", count);
				break;
			}else if (findNum > values[mid]) low = mid +1;
			else high = mid-1;
		}
		
	} //main-end
}
