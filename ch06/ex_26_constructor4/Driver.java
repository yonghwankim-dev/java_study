package ch06.ex_26_constructor4;


public class Driver {
	public static void main(String[] args)
	{
		Car car1 = new Car();
		Car car2 = new Car(car1);
		
		System.out.printf("car1의 color=%s, gearType=%s, door=%d\n"
						, car1.color
						, car1.gearType
						, car1.door);
		
		System.out.printf("car2의 color=%s, gearType=%s, door=%d\n"
				, car2.color
				, car2.gearType
				, car2.door);
		
		car1.color = "blue";
		
		System.out.printf("car1의 color=%s, gearType=%s, door=%d\n"
				, car1.color
				, car1.gearType
				, car1.door);

		System.out.printf("car2의 color=%s, gearType=%s, door=%d\n"
				, car2.color
				, car2.gearType
				, car2.door);
	}
}
