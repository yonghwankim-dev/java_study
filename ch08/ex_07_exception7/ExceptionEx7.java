package ch08.ex_07_exception7;

/**
 * title : catch 구문은 하나만 수행된다
 * - try-catch 구문에서 예외가 발생시 여러 catch 구문중 단 하나의 catch문에서 예외처리를 한다.
 * - 아래 예제에서 정수를 0으로 나누는 연산은 ArithmeticException 인스턴스로도 받을 수 있고
 * Exception 예외도 받을 수 있지만 catch 구문중 true인것 하나만 선택하여 수행됩니다. (위에서 아래로) 
 */
public class ExceptionEx7 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	// 예외 발생
			System.out.println(4);		// 수행되지 않음
		}catch (ArithmeticException ae) {
			if(ae instanceof ArithmeticException) {
				System.out.println("true");
			}
			System.out.println("ArithmeticException");
		}
		catch (Exception e) {	// ArithmeticException을 제외한 모든 예외가 처리됨
			System.out.println("exception");
		}		
		System.out.println(6);
		
	}
}
