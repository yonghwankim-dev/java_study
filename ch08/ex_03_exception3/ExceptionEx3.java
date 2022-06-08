package ch08.ex_03_exception3;

/**
 * title : ArithmeticException 예최 처리
 * - 정수를 0으로 나눌시 ArithmeticException 예외 발생시 catch문으로 예최 처리함
 * - 예외 처리를 하여 실행중에 비정상적으로 멈추는 것을 방지함 
 */
public class ExceptionEx3 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for(int i = 0; i < 10; i++) {
			try {
				result = number / (int) (Math.random() * 10);	// 0으로 나뉠수 있음
				System.out.println(result);
			}catch (ArithmeticException e) {
				System.out.println("0");
			}

		}
	}
}
