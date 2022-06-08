package ch08.ex_21_newException;


/**
 * title : ����� ���� ���� ����
 * 
 */
public class NewExceptionTest {
	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		}catch (SpaceException e) {
			System.out.printf("���� �޽��� : %s", e.getMessage());
			e.printStackTrace();
			System.out.println("������ Ȯ���� �Ŀ� �ٽ� ��ġ�Ͻñ� �ٶ��ϴ�.");
		}catch (MemoryException e) {
			System.out.printf("���� �޽��� : %s", e.getMessage());
			e.printStackTrace();
			System.gc(); // ������ �÷����� �����Ͽ� �޸𸮸� �÷��ش�.
			System.out.println("�ٽ� ��ġ�� �õ��ϼ���.");
		}finally {
			deleteTempFile();
		}		
	}
	
	static void startInstall() throws SpaceException, MemoryException {
		if(!enoughSpace()) {
			throw new SpaceException("��ġ�� ������ �����մϴ�.");
		}
		if(!enoughMemory()) {
			throw new MemoryException("�޸𸮰� �����մϴ�.");
		}
	}
	
	static void copyFiles() {
		System.out.println("copyFiles");
	}
	
	static void deleteTempFile() {
		System.out.println("process deleteTempFile");
	}
	
	static boolean enoughSpace() {
		// ��ġ�ϴµ� �ʿ��� ������ �ִ��� Ȯ���ϴ� �ڵ带 ����
		return false;
	}
	
	static boolean enoughMemory() {
		// ��ġ�ϴµ� �ʿ��� �޸� ������ �ִ��� Ȯ���ϴ� �ڵ带 ����
		return true;
	}
}

class SpaceException extends Exception{
	public SpaceException(String msg) {
		super(msg);
	}
}

class MemoryException extends Exception{
	public MemoryException(String msg) {
		super(msg);
	}
}