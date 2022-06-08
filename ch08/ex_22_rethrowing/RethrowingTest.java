package ch08.ex_22_rethrowing;

/**
 * title : ���� �Ǵ�����(exception re-throwing)
 *
 */
public class RethrowingTest {

	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main �޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
		}
	}
	
	static void method1() throws Exception {
		try {
			throw new Exception();
		}catch (Exception e) {
			System.out.println("method1 �޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
			throw e;	// re-throwing ����
		}
		
	}

}
