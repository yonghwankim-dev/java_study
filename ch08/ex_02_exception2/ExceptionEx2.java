package ch08.ex_02_exception2;

/**
 * title : ���� �߻�
 * - ���ܹ߻��� ��ǥ���� ���ô� ������ 0���� ������ ����
 * - ������ 0���� ������ ArithmeticException ���� �߻�
 */
public class ExceptionEx2 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for(int i = 0; i < 10; i++) {
			result = number / (int) (Math.random() * 10);	// 0���� ������ ����
			System.out.println(result);
		}
	}
}
