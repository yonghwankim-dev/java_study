package ch08.ex_07_exception7;

/**
 * title : catch ������ �ϳ��� ����ȴ�
 * - try-catch �������� ���ܰ� �߻��� ���� catch ������ �� �ϳ��� catch������ ����ó���� �Ѵ�.
 * - �Ʒ� �������� ������ 0���� ������ ������ ArithmeticException �ν��Ͻ��ε� ���� �� �ְ�
 * Exception ���ܵ� ���� �� ������ catch ������ true�ΰ� �ϳ��� �����Ͽ� ����˴ϴ�. (������ �Ʒ���) 
 */
public class ExceptionEx7 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	// ���� �߻�
			System.out.println(4);		// ������� ����
		}catch (ArithmeticException ae) {
			if(ae instanceof ArithmeticException) {
				System.out.println("true");
			}
			System.out.println("ArithmeticException");
		}
		catch (Exception e) {	// ArithmeticException�� ������ ��� ���ܰ� ó����
			System.out.println("exception");
		}		
		System.out.println(6);
		
	}
}
