package ch06.ex_21_overloading;

/**
 * 오버로딩
 * - 매개변수의 타입이 다르거나, 개수가 달라야함
 * - 메서드의 이름이 같아야함
 * - 리턴타입이 다르것은 오버로딩으로 간주하지 않음
 */
public class Calculator {
	public int add(int a, int b)
	{
		System.out.println("int add(int a, int b) -");
		return a + b;
	}
	
	public long add(int a, long b)
	{
		System.out.println("long add(int a, long b) -");
		return a + b;
	}
	
	public long add(long a, int b)
	{
		System.out.println("long add(long a, int b) -");
		return a + b;
	}
	
	public long add(long a, long b)
	{
		System.out.println("long add(long a, long b) -");
		return a + b;
	}
	
	public int add(int[] arr)
	{
		System.out.println("int add(int[] arr) -");
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
		{
			sum += arr[i];
		}
		return sum;
	}
}
