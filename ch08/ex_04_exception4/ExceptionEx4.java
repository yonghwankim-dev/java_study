package ch08.ex_04_exception4;

/**
 * title : ���ܰ� �߻����� ���� ��� �帧
 * - try-catch �������� ���ܰ� �߻����� ������ catch ������ ������� ����
 * - ���ܰ� �߻����� �ʴ� ��� : try
 * - ���ܰ� �߻��� ��� : try -> catch
 */
public class ExceptionEx4 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(4);			
		}catch (Exception e) {
			System.out.println(5);	// ������� ����
		}		
		System.out.println(6);
		
	}
}
