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
			InstallException ie = new InstallException("설치 중 예외발생");
			ie.initCause(e);	// 원인 예외 설정, 원인: SpaceExcetion(공간부족)
			throw ie;
		}catch (MemoryException e) {
			InstallException ie = new InstallException("설치 중 예외발생");
			ie.initCause(e);	// 원인 예외 설정, 원인: MemoryExcetion(메모리공간부족)
			throw ie;
		}finally {
			deleteTempFile();	// 프로그램 설치에 사용된 임시파일들 삭제
		}	
	}
	
	static void startInstall() throws SpaceException, MemoryException {
		if(!enoughSpace()) {
			throw new SpaceException("설치할 공간이 부족합니다.");
		}
		if(!enoughMemory()) {
//			throw new MemoryException("메모리가 부족합니다.");
			// checked예외(MemoryException)을 unchecked예외로 변환
			throw new RuntimeException(new MemoryException("메모리가 부족합니다."));
		}
	}
	
	static void copyFiles() {
		System.out.println("copyFiles");
	}
	
	static void deleteTempFile() {
		System.out.println("process deleteTempFile");
	}
	
	static boolean enoughSpace() {
		// 설치하는데 필요한 공간이 있는지 확인하는 코드를 적음
		return false;
	}
	
	static boolean enoughMemory() {
		// 설치하는데 필요한 메모리 공간이 있는지 확인하는 코드를 적음
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