package ch08.ex_10_exception10;

/**
 * title : throw RuntimeException
 * - RuntimeException�� ����ó���� ���� �ʾƵ� �������̵�
 * - �׷��� ����� ���ܰ� �߻���. RuntimeException Ŭ������ �� �ڼ� Ŭ������ ���α׷��ӿ� ����
 * �Ǽ��� �߻��ϴ� �͵��̱� ������ ����ó���� �������� �ʴ´�.
 * - ������ RuntimeException�� �߻��Ҹ��� ���� ����ó�� ���־����
 * - RuntimeException Ŭ���� : �����Ϸ��� ����ó���� Ȯ������ ���� (�������� ��)
 * - Exception Ŭ���� : �����Ϸ��� ����ó���� Ȯ���� (�������� ���� ����)
 */
public class ExceptionEx10 {
	public static void main(String[] args) {
		throw new RuntimeException();	
	}
}
