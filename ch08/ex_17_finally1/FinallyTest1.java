package ch08.ex_17_finally1;

/**
 * title : fianlly 블럭의 필요성
 * - finally 블럭은 예외의 발생여부에 상관없이 실행되어야 하는 코드를 명시하는 블럭입니다.
 * - finally 블럭은 try-catch 구문에 선택적으로 붙일 수 있습니다.
 * - try{
 * 	 
 *   }
 *   catch{
 *   
 *   }
 *   finally{
 *   
 *   }
 * - 예외가 발생한 경우 순서 : try->catch->finally
 * - 예외가 발생하지 않은 경우 순서 : try->finally
 * - 이 예제는 finally 블럭을 사용하지 않는 경우입니다. 예외 발생 여부에 상관없이
 * deleteTempFiles 메서드를 공통적으로 호출하는 것을 볼 수 있습니다. 이러한 경우 finally
 * 블럭을 사용하여 통합하면 좋습니다.
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
