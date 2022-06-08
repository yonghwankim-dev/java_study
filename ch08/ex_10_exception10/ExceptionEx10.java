package ch08.ex_10_exception10;

/**
 * title : throw RuntimeException
 * - RuntimeException은 예외처리를 하지 않아도 컴파일이됨
 * - 그러나 실행시 예외가 발생함. RuntimeException 클래스와 그 자손 클래스는 프로그래머에 의해
 * 실수로 발생하는 것들이기 때문에 예외처리를 강제하지 않는다.
 * - 하지만 RuntimeException이 발생할만한 곳에 예외처를 해주어야함
 * - RuntimeException 클래스 : 컴파일러가 예외처리를 확인하지 않음 (컴파일은 됨)
 * - Exception 클래스 : 컴파일러가 예외처리를 확인함 (컴파일이 되지 않음)
 */
public class ExceptionEx10 {
	public static void main(String[] args) {
		throw new RuntimeException();	
	}
}
