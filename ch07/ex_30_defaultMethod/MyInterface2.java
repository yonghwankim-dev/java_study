package ch07.ex_30_defaultMethod;

public interface MyInterface2 {
	default void method1() {
		System.out.println("method1() in MyInterface2");
	}
		
	static void staticMethod() {
		System.out.println("staticMethod() in MyInterface2");
	}
}
