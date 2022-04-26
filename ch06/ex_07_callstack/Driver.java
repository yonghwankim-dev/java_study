package ch06.ex_07_callstack;

/**
 * ȣ�� ���� ����
 * 
 * ȣ�⽺�� ��ȭ
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
		firstMethod();
	}
	
	public static void firstMethod() {
		secondMethod();
	}
	
	public static void secondMethod() {
		System.out.println("call secondMethod");
	}
}
