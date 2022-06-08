package ch08.ex_12_exception12;

/**
 * title : 메서드에 예외 선언하기
 * - 메서드에 예외를 선언하면 해당 메서드에서 발생하는 예외를 잡아낼 수 있음
 * - 메서드에 예외선언을 확인함으로써 어떤 예외가 발생할 것인지 파악할 수 있음
 * - 예외를 메서드의 throws에 명시하는 것은 에외를 처리하는 것이 아니라, 자신(예외가 발생할 가능성이
 * 있는 메서드)을 호출한 메서드에게 예외를 전달하여 예외처리를 떠맡기는 것입니다.
 * - 어느 한곳에서 try-catch 구문으로 예외 처리를 해주어야함
 */
public class ExceptionEx12 {
	public static void main(String[] args) throws Exception {
		method1();
	}
	
	static void method1() throws Exception {
		method2();
	}
	
	static void method2() throws Exception {
		throw new Exception();
	}
}
