package ch06.ex_16_recursion2;


/**
 * ���丮�� ��� ȣ��
 * ��� ȣ���� �޼��� ���ο��� �޼��� �ڽ��� �ٽ� ȣ���ϴ� ���� �ǹ���
 */
public class Driver {

	public static int factorial(int n)
	{
		if(n<=0 || n>20)
		{
			return -1;
		}
		
		if(n == 1)
		{
			return 1;
		}
		return n * factorial(n-1);
	}
	
	public static void main(String[] args) {
		int n = 21;
		int result = 0;
		for(int i = 1; i <= n; i++)
		{
			result = factorial(i);
			
			if(result == -1)
			{
				System.out.printf("��ȿ���� ���� ���Դϴ�. (0<n<21) : %d\n", i);
				break;
			}
			System.out.printf("%2d!=%20d\n",i, result);
		}
	}
}
