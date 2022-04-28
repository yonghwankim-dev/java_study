package ch06.ex_25_constructor3;


public class Driver {
	public static void main(String[] args)
	{
		Car car1 = new Car();
		Car car2 = new Car("blue");
		
		System.out.printf("car1ÀÇ color=%s, gearType=%s, door=%d\n"
						, car1.color
						, car1.gearType
						, car1.door);
		
		System.out.printf("car2ÀÇ color=%s, gearType=%s, door=%d\n"
				, car2.color
				, car2.gearType
				, car2.door);		
	}
}
