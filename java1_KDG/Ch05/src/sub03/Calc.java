package sub03;

public class Calc {
	
	// 내부에서 객체 생성
	private static Calc instance = new Calc();
	// getInstance로만 가져올 수 있음
	public static Calc getInstance() {
		return instance;
	}
	// 생성자제한
	private Calc() {}
	
	public int plus(int x, int y) {
		return x+y;
	}
	public int minus(int x, int y) {
		return x-y;
	}
	public int multi(int x, int y) {
		return x*y;
	}
	public int div(int x, int y) {
		return x/y;
	}
	

	
}
