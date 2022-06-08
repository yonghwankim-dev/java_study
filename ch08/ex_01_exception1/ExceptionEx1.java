package ch08.ex_01_exception1;

/**
 * title : try-catch문 구성
 * - try 블록 안에서 예외가 발생시 catch문으로 이동됨
 * - 중복 try-catch문 구성시 예외 변수이름이 중복되면 안됩니다.
 *
 */
public class ExceptionEx1 {
	public static void main(String[] args) {
		try {
			try {
				
			}catch (Exception e) {
				
			}
		}catch (Exception e) {
//			try {
//				
//			}catch (Exception e) {	// 에러. 변수 e가 중복 선언됨
//				
//			}			
		} // try-catch의 끝
	}
}
