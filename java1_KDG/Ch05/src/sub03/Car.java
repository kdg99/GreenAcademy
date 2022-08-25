package sub03;

// 클래스 정의
public class Car {
	
	// 자동차의 속성(변수)
	private String name;
	private String color;
	private int speed;
	public static int count;
	
	//생성자
	public Car(String name, String color, int speed) {
		this.name = name;
		this.color = color;
		this.speed =speed;
		count += 1;
	}
	
	// Getter, Setter
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	// 자동차의 기능(메서드)
	public void speedUp(int speed) {
		this.speed += speed;
	}
	
	public void speedDown(int speed) {
		this.speed -= speed;
	}
	
	public void show() {
		System.out.println("차량명 : "+this.name); // 가독성을 위해 붙여도 됨
		System.out.println("차량색 : "+color);
		System.out.println("속도 : "+speed);
		System.out.println("차량번호 : "+count);
	}
	
}
