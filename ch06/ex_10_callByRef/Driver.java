package ch06.ex_10_callByRef;

/**
 * call by value ¿¹Á¦
 */
public class Driver {

	public static void change(Data d)
	{
		d.x = 1000;
		System.out.printf("change() : x = %d\n", d.x);
	}
	
	public static void main(String[] args) {
		Data d = new Data();
		
		d.x = 10;
		System.out.printf("main() : x = %d\n", d.x);
		
		change(d);
		System.out.printf("After change(d.x)\n");
		System.out.printf("main() : x = %d", d.x);
		
		
	}
}
