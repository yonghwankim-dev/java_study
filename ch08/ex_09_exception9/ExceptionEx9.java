package ch08.ex_09_exception9;

/**
 * title : ���� �߻���Ű��
 * - ���� �ν��Ͻ��� �����ϰ� throw Ű���带 ���Ͽ� ���ܸ� �߻���ų�� ����
 */
public class ExceptionEx9 {
	public static void main(String[] args) {

		try {
			Exception e = new Exception("���Ƿ� �߻�������");
			throw e;
			
		}catch (Exception e) {
			System.out.println("���� �޽��� : " + e.getMessage());
			e.printStackTrace();
		}		
		System.out.println("���α׷��� ���� ����Ǿ���");
		
	}
}
