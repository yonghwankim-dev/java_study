package ch07.ex_15_casting;

class Car{
	String color;
	int door;
	
	public void drive() {
		System.out.println("drive~~~");
	}
	
	public void stop() {
		System.out.println("stop!!");
	}
}

class FireEngine extends Car{
	public void water() {	// ���� �Ѹ��� ���
		System.out.println("water!!");
	}
}

public class CastingTest {
	public static void main(String[] args)
	{
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe;	// car = (Car) fe;���� ����ȯ�� ������
//		car.water();	// Car Ÿ���� ��ü�� water()�� ȣ���� �� ����
		
		fe2 = (FireEngine) car;	// �ڼ�Ÿ�� <- ����Ÿ��
		fe2.water();
	}
}
