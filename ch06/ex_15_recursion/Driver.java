package ch06.ex_15_recursion;


/**
 * ���丮�� ��� ȣ��
 * ��� ȣ���� �޼��� ���ο��� �޼��� �ڽ��� �ٽ� ȣ���ϴ� ���� �ǹ���
 */
public class Driver {

	public static int factorial(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		return n * factorial(n-1);
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
}
