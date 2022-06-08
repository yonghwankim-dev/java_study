package ch08.ex_18_finally2;

/**
 * title : fianlly 사용
 * - finally 블럭을 사용하여 중복성 최소화
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

	// 프로그램 설치에 필요한 준비를 수행
	static void startInstall() {
		
	}
	// 파일들을 복사
	static void copyFiles() {
		
	}
	// 임시 파일 삭제
	static void deleteTempFiles() {
		
	}
}
