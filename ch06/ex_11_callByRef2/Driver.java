package ch06.ex_11_callByRef2;

/**
 * call by value ¿¹Á¦
 */
public class Driver {

	public static void change(int[] x)
	{
		x[0] = 1000;
		System.out.printf("change() : x = %d\n", x[0]);
	}
	
	public static void main(String[] args) {
		int[] x = {10};
		
		
		System.out.printf("main() : x = %d\n", x[0]);
		
		change(x);
		System.out.printf("After change(x)\n");
		System.out.printf("main() : x = %d", x[0]);
		
		
	}
}
