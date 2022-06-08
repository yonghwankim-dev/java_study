package ch08.ex_17_finally1;

/**
 * title : fianlly ���� �ʿ伺
 * - finally ���� ������ �߻����ο� ������� ����Ǿ�� �ϴ� �ڵ带 ����ϴ� ���Դϴ�.
 * - finally ���� try-catch ������ ���������� ���� �� �ֽ��ϴ�.
 * - try{
 * 	 
 *   }
 *   catch{
 *   
 *   }
 *   finally{
 *   
 *   }
 * - ���ܰ� �߻��� ��� ���� : try->catch->finally
 * - ���ܰ� �߻����� ���� ��� ���� : try->finally
 * - �� ������ finally ���� ������� �ʴ� ����Դϴ�. ���� �߻� ���ο� �������
 * deleteTempFiles �޼��带 ���������� ȣ���ϴ� ���� �� �� �ֽ��ϴ�. �̷��� ��� finally
 * ���� ����Ͽ� �����ϸ� �����ϴ�.
 */
public class FinallyTest1 {

	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
			deleteTempFiles();
		}catch (Exception e) {
			e.printStackTrace();
			deleteTempFiles();
		}
	}

	// ���α׷� ��ġ�� �ʿ��� �غ� ����
	static void startInstall() {
		
	}
	// ���ϵ��� ����
	static void copyFiles() {
		
	}
	// �ӽ� ���� ����
	static void deleteTempFiles() {
		
	}
}
