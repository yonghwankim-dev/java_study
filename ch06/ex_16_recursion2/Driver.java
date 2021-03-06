package ch06.ex_16_recursion2;


/**
 * 팩토리얼 재귀 호출
 * 재귀 호출은 메서드 내부에서 메서드 자신을 다시 호춣하는 것을 의미함
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
				System.out.printf("유효하지 않은 값입니다. (0<n<21) : %d\n", i);
				break;
			}
			System.out.printf("%2d!=%20d\n",i, result);
		}
	}
}
