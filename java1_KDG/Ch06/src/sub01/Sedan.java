package sub01;

public class Sedan extends Car {

	private int cc;
	
	public Sedan(String name, String color, int speed, int cc) {
		super(name, color, speed);
		this.setCc(cc);
	}

	@Override
	public void speedUp(int speed) {
		this.speed += speed + 20; 
	}

	@Override
	public void speedDown(int speed) {
		this.speed -= speed - 20;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
}