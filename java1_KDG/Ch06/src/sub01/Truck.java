package sub01;

public class Truck extends Car {

	private int capacity;
	
	public Truck(String name, String color, int speed, int capacity) {
		super(name, color, speed);
		this.setCapacity(capacity);
	}

	@Override
	public void speedUp(int speed) {
		this.speed += speed + 10;
	}

	@Override
	public void speedDown(int speed) {
		this.speed -= speed - 10;		
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}