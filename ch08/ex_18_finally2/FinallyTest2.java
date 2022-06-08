package ch08.ex_18_finally2;

/**
 * title : fianlly ���
 * - finally ���� ����Ͽ� �ߺ��� �ּ�ȭ
 */
public class FinallyTest2 {

	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
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
