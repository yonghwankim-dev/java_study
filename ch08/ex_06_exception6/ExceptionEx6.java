package ch08.ex_06_exception6;

/**
 * title : ������ �߻��� catch ��
 * - ���ܰ� �߻��ϸ� �߻��� ���ܿ� �ش��ϴ� Ŭ������ �ν��Ͻ��� �������
 * - catch ���� ���� Ŭ������ �ν��Ͻ��� �ش��ϴ� catch�� Ž����
 * - ���� Ž������ ���ϸ� ����ó���� �Ұ�����
 * - catch �������� �������� Exception ���������� �����ϸ� ��� ���ܸ� ó���� �� ���� 
 */
public class ExceptionEx6 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	// ���� �߻�
			System.out.println(4);		// ������� ����
		}catch (Exception e) {	// ArithmeticException ��� Exception�� �����
			System.out.println(5);
		}		
		System.out.println(6);
		
	}
}
