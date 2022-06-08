package ch08.ex_09_exception9;

/**
 * title : 예외 발생시키기
 * - 예외 인스턴스를 생성하고 throw 키워드를 통하여 에외를 발생시킬수 있음
 */
public class ExceptionEx9 {
	public static void main(String[] args) {

		try {
			Exception e = new Exception("고의로 발생시켰음");
			throw e;
			
		}catch (Exception e) {
			System.out.println("에러 메시지 : " + e.getMessage());
			e.printStackTrace();
		}		
		System.out.println("프로그램이 정상 종료되었음");
		
	}
}
