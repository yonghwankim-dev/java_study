package ch06.ex_26_constructor4;

/**
 * �����ڸ� �̿��� �ν��Ͻ��� ����
 */
public class Car {
	String color;		// ����
	String gearType;	// ���ӱ� ���� - auto(�ڵ�), manual(����)
	int door;			// ���� ����
	
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
