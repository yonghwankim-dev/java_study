package ch08.ex_13_exception13;

/**
 * title : ���� �߻� ó�� ��� (ȣ���� �޼��� ������ ó��)
 * - �޼��忡 ���ܸ� �����ϸ� �ش� �޼��忡 ���ܰ� �߻��ϸ� �ڽ��� ȣ���ߴ� �޼���� ���ܸ� ������
 * - �޼��峻���� ����ó�� ó���ϸ� �� �޼��带 ȣ���� �޼��忡���� ���ܹ߻� ����� �� �� ����
 * - �Ʒ� ����ó�� method1() �޼��� ������ ���ܰ� �߻��ϰ� ����ó���� �ϰ� �Ǹ� ȣ���� main �޼����
 * ���ܰ� �߻��� ����� �� �� ����
 */
public class ExceptionEx13 {
	public static void main(String[] args) throws Exception {
		method1();
	}
	
	static void method1(){
		try {
			throw new Exception();
		}catch (Exception e) {
			System.out.println("method1 �޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
			e.printStackTrace();
		}
	}
	
}
