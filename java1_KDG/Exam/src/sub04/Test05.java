package sub04;

/*
 * 날짜 : 2022/09/16
 * 이름 : 김동근
 * 내용 : Java String, Wrapper 클래스 연습문제
 */
public class Test05 {
	public static void main(String[] args) {
		String strCsv = "60,72,82,86,92";
		String[] scores = strCsv.split(",");
		
		int total = 0;
		for(int i=0 ; i<scores.length ; i ++) {
			total += Integer.parseInt(scores[i]);
		}
		
		System.out.println("총점 : " + total);
	}
}
