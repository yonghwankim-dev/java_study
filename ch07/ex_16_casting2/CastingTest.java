package ch07.ex_16_casting2;

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
		Car car = new Car();	// new FireEngine() �̶�� ������ ������
		Car car2 = null;
		FireEngine fe = null;
		
		car.drive();
		fe = (FireEngine) car;	// compile ok, runtime error
		fe.drive();
		car2 = fe;
		car2.drive();
	}
}
