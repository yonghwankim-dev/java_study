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
	public void water() {	// 물을 뿌리는 기능
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
		car = fe;	// car = (Car) fe;에서 형변환이 생략됨
//		car.water();	// Car 타입의 객체는 water()를 호출할 수 없음
		
		fe2 = (FireEngine) car;	// 자손타입 <- 조상타입
		fe2.water();
	}
}
