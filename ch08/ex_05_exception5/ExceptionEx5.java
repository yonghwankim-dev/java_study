package ch08.ex_05_exception5;

/**
 * title : ���ܰ� �߻��ҽ� �帧
 * - ���ܰ� �߻��ϸ� �� ������ ��ɾ�� ������� �ʰ� catch �������� �̵��մϴ�. 
 */
public class ExceptionEx5 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	// ���� �߻�
			System.out.println(4);		// ������� ����
		}catch (ArithmeticException e) {
			System.out.println(5);
		}		
		System.out.println(6);
		
	}
}
