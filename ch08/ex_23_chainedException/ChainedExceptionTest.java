package ch08.ex_23_chainedException;

public class ChainedExceptionTest {
	public static void main(String[] args) {
		try {
			install();
		} catch (InstallException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void install() throws InstallException {
		try {
			startInstall();
			copyFiles();
		}catch (SpaceException e) {
			InstallException ie = new InstallException("��ġ �� ���ܹ߻�");
			ie.initCause(e);	// ���� ���� ����, ����: SpaceExcetion(��������)
			throw ie;
		}catch (MemoryException e) {
			InstallException ie = new InstallException("��ġ �� ���ܹ߻�");
			ie.initCause(e);	// ���� ���� ����, ����: MemoryExcetion(�޸𸮰�������)
			throw ie;
		}finally {
			deleteTempFile();	// ���α׷� ��ġ�� ���� �ӽ����ϵ� ����
		}	
	}
	
	static void startInstall() throws SpaceException, MemoryException {
		if(!enoughSpace()) {
			throw new SpaceException("��ġ�� ������ �����մϴ�.");
		}
		if(!enoughMemory()) {
//			throw new MemoryException("�޸𸮰� �����մϴ�.");
			// checked����(MemoryException)�� unchecked���ܷ� ��ȯ
			throw new RuntimeException(new MemoryException("�޸𸮰� �����մϴ�."));
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

class InstallException extends Exception{
	public InstallException(String msg) {
		super(msg);
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