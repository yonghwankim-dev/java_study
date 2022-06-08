package ch08.ex_19_finally3;

/**
 * title : finally 블럭의 수행 흐름
 * - try-catch-finally 구문에서 예외가 발생하지 않고 try 마지막 부분이 return 문을 호출하여
 * 호출했던 메서드로 돌아가려고 할때 돌아가기전에 finally 블럭을 먼저 수행합니다.
 * - try 구문 마지막에 return문이 있을때의 수행흐름
 * try->return문 호출->finally 블럭 수행 -> return문 실행
 */
public class FinallyTest3 {

	public static void main(String[] args) {
		method1();
		System.out.println("main 메서드가 종료되었습니다.");
	}
	static void method1() {
		try {
			System.out.println("method1()이 호출되었습니다.");
			return;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("method1()의 finally 블럭이 실행되었습니다.");
		}
	}
}
