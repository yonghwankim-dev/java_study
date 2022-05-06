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
	public void water() {	// 물을 뿌리는 기능
		System.out.println("water!!");
	}
}

public class CastingTest {
	public static void main(String[] args)
	{
		Car car = new Car();	// new FireEngine() 이라면 실행이 가능함
		Car car2 = null;
		FireEngine fe = null;
		
		car.drive();
		fe = (FireEngine) car;	// compile ok, runtime error
		fe.drive();
		car2 = fe;
		car2.drive();
	}
}
