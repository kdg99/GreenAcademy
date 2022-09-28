package sub07;
/*
 * 날짜 : 2022/09/28
 * 이름 : 김동근
 * 내용 : 자바 총정리 연습문제
 */

interface IRunnable{
	public void run();
}

interface IFlyable{
	public void fly();
}

class FlyingCar implements IFlyable, IRunnable{
	@Override
	public void fly() {
		System.out.println("Car fly!");
	}
	@Override
	public void run() {
		System.out.println("Car run!");
	}
}

public class Test08 {

	public static void main(String[] args) {
		
		FlyingCar car = new FlyingCar();
		car.run();
		car.fly();
		
		
	}
	
}
