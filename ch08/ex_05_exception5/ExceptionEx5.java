package ch08.ex_05_exception5;

/**
 * title : 예외가 발생할시 흐름
 * - 예외가 발생하면 그 이후의 명령어는 수행되지 않고 catch 구문으로 이동합니다. 
 */
public class ExceptionEx5 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	// 예외 발생
			System.out.println(4);		// 수행되지 않음
		}catch (ArithmeticException e) {
			System.out.println(5);
		}		
		System.out.println(6);
		
	}
}
