package ch06.ex_09_callByValue;

/**
 * call by value ¿¹Á¦
 */
public class Driver {

	public static void change(int x)
	{
		x = 1000;
		System.out.printf("change() : x = %d\n", x);
	}
	
	public static void main(String[] args) {
		Data d = new Data();
		
		d.x = 10;
		System.out.printf("main() : x = %d\n", d.x);
		
		change(d.x);
		System.out.printf("After change(d.x)\n");
		System.out.printf("main() : x = %d", d.x);
		
		
	}
}
