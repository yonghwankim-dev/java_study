package ch08.ex_08_exception8;

/**
 * title : 예외(ArithmeticException, Exception) 인스턴스의 정보 출력
 * - 예외 클래스의 인스턴스에는 발생한 예외에 대한 정보가 담겨 있고 메서드를 통해 호출할 수 있음
 * - printStackTrace() : 예외발생 다시의 호출스택(Call Stack)에 있었던 메서드의 정보와
 * 예외 메시지를 화면에 출력함
 * - getMessage() : 발생한 예외 클래스의 인스턴스에 저장된 메시지를 얻을 수 있음
 */
public class ExceptionEx8 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	// 예외 발생
			System.out.println(4);		// 수행되지 않음
		}catch (ArithmeticException ae) {
			// 참조변수 ae를 통해, 생성된 ArithmeticException 인스턴스에 접근할 수 있음
			ae.printStackTrace(); 
			System.out.println("예외메시지 : " + ae.getMessage());
		}		
		System.out.println(6);
		
	}
}
