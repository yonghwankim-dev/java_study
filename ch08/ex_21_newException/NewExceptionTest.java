package ch08.ex_21_newException;


/**
 * title : 사용자 정의 예외 생성
 * 
 */
public class NewExceptionTest {
	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		}catch (SpaceException e) {
			System.out.printf("에러 메시지 : %s", e.getMessage());
			e.printStackTrace();
			System.out.println("공간을 확보한 후에 다시 설치하시기 바랍니다.");
		}catch (MemoryException e) {
			System.out.printf("에러 메시지 : %s", e.getMessage());
			e.printStackTrace();
			System.gc(); // 가비지 컬렉션을 수행하여 메모리를 늘려준다.
			System.out.println("다시 설치를 시도하세요.");
		}finally {
			deleteTempFile();
		}		
	}
	
	static void startInstall() throws SpaceException, MemoryException {
		if(!enoughSpace()) {
			throw new SpaceException("설치할 공간이 부족합니다.");
		}
		if(!enoughMemory()) {
			throw new MemoryException("메모리가 부족합니다.");
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