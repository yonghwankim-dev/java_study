package ch06.ex_15_recursion;


/**
 * ÆÑÅä¸®¾ó Àç±Í È£Ãâ
 * Àç±Í È£ÃâÀº ¸Ş¼­µå ³»ºÎ¿¡¼­ ¸Ş¼­µå ÀÚ½ÅÀ» ´Ù½Ã È£­„ÇÏ´Â °ÍÀ» ÀÇ¹ÌÇÔ
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
