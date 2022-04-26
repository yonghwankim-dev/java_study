package ch06.ex_19_staticMethod;

public class MyMath {
	int a;
	int b;
	
	public int add()
	{
		return a + b;
	}
	
	public int subtract()
	{
		return a - b;
	}
	
	public int multiply()
	{
		return a * b;
	}
	
	public double divide()
	{
		return a / b;
	}
	
	public static int add(int a, int b)
	{
		return a + b;
	}
	
	public static int subtract(int a, int b)
	{
		return a - b;
	}
	
	public static int multiply(int a, int b)
	{
		return a * b;
	}
	
	public static double divide(int a, int b)
	{
		return a / b;
	}	
}
