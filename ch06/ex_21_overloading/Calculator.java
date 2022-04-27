package ch06.ex_21_overloading;

/**
 * �����ε�
 * - �Ű������� Ÿ���� �ٸ��ų�, ������ �޶����
 * - �޼����� �̸��� ���ƾ���
 * - ����Ÿ���� �ٸ����� �����ε����� �������� ����
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
