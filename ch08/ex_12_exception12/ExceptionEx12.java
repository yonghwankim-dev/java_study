package ch08.ex_12_exception12;

/**
 * title : �޼��忡 ���� �����ϱ�
 * - �޼��忡 ���ܸ� �����ϸ� �ش� �޼��忡�� �߻��ϴ� ���ܸ� ��Ƴ� �� ����
 * - �޼��忡 ���ܼ����� Ȯ�������ν� � ���ܰ� �߻��� ������ �ľ��� �� ����
 * - ���ܸ� �޼����� throws�� ����ϴ� ���� ���ܸ� ó���ϴ� ���� �ƴ϶�, �ڽ�(���ܰ� �߻��� ���ɼ���
 * �ִ� �޼���)�� ȣ���� �޼��忡�� ���ܸ� �����Ͽ� ����ó���� ���ñ�� ���Դϴ�.
 * - ��� �Ѱ����� try-catch �������� ���� ó���� ���־����
 */
public class ExceptionEx12 {
	public static void main(String[] args) throws Exception {
		method1();
	}
	
	static void method1() throws Exception {
		method2();
	}
	
	static void method2() throws Exception {
		throw new Exception();
	}
}
