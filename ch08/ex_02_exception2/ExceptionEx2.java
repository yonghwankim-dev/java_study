package ch08.ex_02_exception2;

/**
 * title : 예외 발생
 * - 예외발생의 대표적인 예시는 정수를 0으로 나누는 연산
 * - 정수를 0으로 나눌시 ArithmeticException 예외 발생
 */
public class ExceptionEx2 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for(int i = 0; i < 10; i++) {
			result = number / (int) (Math.random() * 10);	// 0으로 나뉠수 있음
			System.out.println(result);
		}
	}
}
