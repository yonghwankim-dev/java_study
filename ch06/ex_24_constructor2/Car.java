package ch06.ex_24_constructor2;

public class Car {
	String color;		// ����
	String gearType;	// ���ӱ� ���� - auto(�ڵ�), manual(����)
	int door;			// ���� ����
	
	public Car() {
		
	}
	
	public Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}
