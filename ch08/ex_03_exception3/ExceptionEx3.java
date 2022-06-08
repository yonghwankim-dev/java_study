package ch08.ex_03_exception3;

/**
 * title : ArithmeticException ���� ó��
 * - ������ 0���� ������ ArithmeticException ���� �߻��� catch������ ���� ó����
 * - ���� ó���� �Ͽ� �����߿� ������������ ���ߴ� ���� ������ 
 */
public class ExceptionEx3 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for(int i = 0; i < 10; i++) {
			try {
				result = number / (int) (Math.random() * 10);	// 0���� ������ ����
				System.out.println(result);
			}catch (ArithmeticException e) {
				System.out.println("0");
			}

		}
	}
}
