package ch06.ex_08_callstack2;

/**
 * 호출 스택 예제
 * 
 * 호출스택 변화
 * 1. empty
 * 2. main
 * 2. main -> firstMethod
 * 3. main -> firstMethod -> secondMethod
 * 4. main -> firstMethod -> secondMethod => println
 * 5. main -> firstMethod -> secondMethod
 * 6. main -> firstMethod
 * 7. main
 * 8. empty
 */
public class Driver {

	public static void main(String[] args) {
		System.out.println("start main");
		firstMethod();
		System.out.println("end main");
	}
	
	public static void firstMethod() {
		System.out.println("start firstMethod");
		secondMethod();
		System.out.println("end firstMethod");
	}
	
	public static void secondMethod() {
		System.out.println("start secondMethod");
		System.out.println("secondMethod()");
		System.out.println("end secondMethod");
	}
}
