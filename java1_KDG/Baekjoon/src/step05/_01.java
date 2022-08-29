package step05;
/*
 * 날짜 : 2022/08/29
 * 이름 : 김동근
 * 내용 : 백준 난이도 5 1번 문제
 */
public class _01 {

	public static void main(String[] args) {
		int[] list = {1,3,5,7,9};
		
		System.out.println(sum(list));
	}

	public static long sum(int[] a) {
		long total = 0;
		for (int i=0 ; i<a.length ; i++){total+=a[i];}
		
		return total;
	}
	
}
