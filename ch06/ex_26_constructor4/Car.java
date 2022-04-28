package ch06.ex_26_constructor4;

/**
 * 생성자를 이용한 인스턴스의 복사
 */
public class Car {
	String color;		// 색상
	String gearType;	// 변속기 종류 - auto(자동), manual(수동)
	int door;			// 문의 개수
	
	public Car() {
		this("white", "auto", 4);
	}
	
	public Car(Car c) {
		color = c.color;
		gearType = c.gearType;
		door = c.door;
	}
	
	public Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}
