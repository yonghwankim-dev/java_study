package ch08.ex_08_exception8;

/**
 * title : ����(ArithmeticException, Exception) �ν��Ͻ��� ���� ���
 * - ���� Ŭ������ �ν��Ͻ����� �߻��� ���ܿ� ���� ������ ��� �ְ� �޼��带 ���� ȣ���� �� ����
 * - printStackTrace() : ���ܹ߻� �ٽ��� ȣ�⽺��(Call Stack)�� �־��� �޼����� ������
 * ���� �޽����� ȭ�鿡 �����
 * - getMessage() : �߻��� ���� Ŭ������ �ν��Ͻ��� ����� �޽����� ���� �� ����
 */
public class ExceptionEx8 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	// ���� �߻�
			System.out.println(4);		// ������� ����
		}catch (ArithmeticException ae) {
			// �������� ae�� ����, ������ ArithmeticException �ν��Ͻ��� ������ �� ����
			ae.printStackTrace(); 
			System.out.println("���ܸ޽��� : " + ae.getMessage());
		}		
		System.out.println(6);
		
	}
}
