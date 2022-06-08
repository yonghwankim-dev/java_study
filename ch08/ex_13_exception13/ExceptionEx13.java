package ch08.ex_13_exception13;

/**
 * title : 예외 발생 처리 방식 (호출한 메서드 내에서 처리)
 * - 메서드에 예외를 선언하면 해당 메서드에 예외가 발생하면 자신을 호출했던 메서드로 예외를 전달함
 * - 메서드내에서 예외처를 처리하면 그 메서드를 호출한 메서드에서는 예외발생 사실을 알 수 없음
 * - 아래 예제처럼 method1() 메서드 내에서 예외가 발생하고 예외처리를 하게 되면 호출한 main 메서드는
 * 예외가 발생한 사실을 알 수 없음
 */
public class ExceptionEx13 {
	public static void main(String[] args) throws Exception {
		method1();
	}
	
	static void method1(){
		try {
			throw new Exception();
		}catch (Exception e) {
			System.out.println("method1 메서드에서 예외가 처리되었습니다.");
			e.printStackTrace();
		}
	}
	
}
