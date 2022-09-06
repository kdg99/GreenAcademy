package sub02;

public class Calc {
	private static Calc instance = new Calc();
	
	public static Calc getInstance() {
		return instance;
	}
	
	private Calc() {}
	
	public int plus(int x, int y) {
		return x+y;
	}
	public int minus(int x, int y) {
		return x-y;
	}
	public int multi(int x, int y) throws Exception {
		
		if(y <= 0) {//예외 강제로 발생시키기
			Exception e = new Exception("y = 0보다 작으면 안 됩니다.");
			throw e;
		}
		
		int z = x*y;
		return z;
	}
	public int div(int x, int y) throws ArithmeticException {
		int z = x/y;
		return z;
	}
	
}
