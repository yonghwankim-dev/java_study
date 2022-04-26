package ch06.ex_06_callMethod;

/**
 * 메서드의 호출 예제
 */
public class Driver {

	public static void main(String[] args) {
		MyMath mm = new MyMath();
		int a=5, b=3;
		
		int result1 = mm.add(a, b);
		int result2 = mm.subtract(a, b);
		int result3 = mm.multiply(a, b);
		double result4 = mm.divide(a, b);
		
		System.out.printf("add(%d, %d) = %d\n", a, b, result1);
		System.out.printf("add(%d, %d) = %d\n", a, b, result2);
		System.out.printf("add(%d, %d) = %d\n", a, b, result3);
		System.out.printf("add(%d, %d) = %f\n", a, b, result4);	
	}
}
