package ch08.ex_14_exception14;


/**
 * title : 예외 발생 처리 방식 (자기를 호출한 메서드로 전달하여 예외 처리)
 * - 메서드에 예외를 선언하고 예외가 발생하면 자기를 호출한 메서드로 예외를 전달함
 * - 전달받은 또다른 메서드는 예외처리를 할 수 있고 발생 사실도 알 수 있음
 */
public class ExceptionEx14 {
	public static void main(String[] args){
		
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main메서드에서 에외가 처리되었습니다.");
			e.printStackTrace();
		}
	}
	
	static void method1() throws Exception{
		throw new Exception();
	}
	
	
}
