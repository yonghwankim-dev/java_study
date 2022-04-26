package ch06.ex_16_recursion2;


/**
 * ÆÑÅä¸®¾ó Àç±Í È£Ãâ
 * Àç±Í È£ÃâÀº ¸Ş¼­µå ³»ºÎ¿¡¼­ ¸Ş¼­µå ÀÚ½ÅÀ» ´Ù½Ã È£­„ÇÏ´Â °ÍÀ» ÀÇ¹ÌÇÔ
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
				System.out.printf("À¯È¿ÇÏÁö ¾ÊÀº °ªÀÔ´Ï´Ù. (0<n<21) : %d\n", i);
				break;
			}
			System.out.printf("%2d!=%20d\n",i, result);
		}
	}
}
