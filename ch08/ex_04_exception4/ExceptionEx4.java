package ch08.ex_04_exception4;

/**
 * title : 예외가 발생하지 않을 경우 흐름
 * - try-catch 구문에서 예외가 발생하지 않으면 catch 구문은 실행되지 않음
 * - 예외가 발생하지 않는 경우 : try
 * - 예외가 발생한 경우 : try -> catch
 */
public class ExceptionEx4 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(4);			
		}catch (Exception e) {
			System.out.println(5);	// 실행되지 않음
		}		
		System.out.println(6);
		
	}
}
