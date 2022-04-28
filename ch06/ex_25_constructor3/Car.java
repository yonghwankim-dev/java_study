package ch06.ex_25_constructor3;

/**
 * �����ڿ��� �ٸ� ������ ȣ���ϱ�
 * - �޼��� �����ε� ��� ����
 * - �������� �̸����� Ŭ���� �̸� ��� this ���
 * - �� �����ڿ��� �ٸ� �����ڸ� ȣ���� ���� �ݵ�� ù�ٿ����� ȣ���� ������
 * - this�� �ν��Ͻ� �ڽ��� ����Ű�� ��������
 */
public class Car {
	String color;		// ����
	String gearType;	// ���ӱ� ���� - auto(�ڵ�), manual(����)
	int door;			// ���� ����
	
	public Car() {
		this("white", "auto", 4);
	}
	
	public Car(String color) {
		this(color, "auto", 4);
	}
	
	public Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}
