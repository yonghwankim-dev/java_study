package ch08.ex_06_exception6;

/**
 * title : 예외의 발생과 catch 블럭
 * - 예외가 발생하면 발생한 예외에 해당하는 클래스의 인스턴스가 만들어짐
 * - catch 블럭중 예외 클래스의 인스턴스에 해당하는 catch를 탐색함
 * - 만약 탐색하지 못하면 예외처리가 불가능함
 * - catch 구문들중 마지막에 Exception 참조변수를 설정하면 모든 예외를 처리할 수 있음 
 */
public class ExceptionEx6 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	// 예외 발생
			System.out.println(4);		// 수행되지 않음
		}catch (Exception e) {	// ArithmeticException 대신 Exception을 사용함
			System.out.println(5);
		}		
		System.out.println(6);
		
	}
}
