package ch06.ex_18_power;


/**
 * power 메서드 재귀호출
 */
public class Driver {
	
	public static long power(int x, int n)
	{
		if(n == 1)
		{
			return x;
		}
		return x * power(x, n-1);
	}
	
	public static void main(String[] args) {
		System.out.println(power(2,5));
	}
}
