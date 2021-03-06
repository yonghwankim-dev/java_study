package ch06.ex_15_recursion;


/**
 * 팩토리얼 재귀 호출
 * 재귀 호출은 메서드 내부에서 메서드 자신을 다시 호춣하는 것을 의미함
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
