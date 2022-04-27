package ch06.ex_21_overloading;

public class Driver {
	public static void main(String[] args)
	{
		Calculator c = new Calculator();
		System.out.println("c.add(3,3) = " + c.add(3, 3));
		System.out.println("c.add(3L,3) = " + c.add(3L, 3));
		System.out.println("c.add(3,3L) = " + c.add(3, 3L));
		System.out.println("c.add(3L,3L) = " + c.add(3L, 3L));
		
		int[] arr = {10, 20, 30};
		System.out.println("c.add(arr) = " + c.add(arr));
	}
}
