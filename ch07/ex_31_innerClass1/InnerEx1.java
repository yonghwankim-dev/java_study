package ch07.ex_31_innerClass1;

/**
 * title : 내부 클래스의 제어자와 접근성
 * 1. 내부 클래스 중에서 static 클래스(StaticInner)만 static 멤버를 가질 수 있음
 * 2. final static이 동시에 붙은 변수는 상수이므로 모든 내부 클래스에서 정의가 가능함
 */
public class InnerEx1 {
	class InstanceInner{
		int iv = 100;
//		static int cv = 100; // 에러!, static 변수를 선언할 수 없음
		final static int CONST = 100;	// final static은 상수이므로 허용
	}
	
	static class StaticInner{
		int iv = 200;
		static int cv = 200;	// static 클래스만 static 멤버를 정의할 수 있음
	}
	
	public void myMethod() {
		class LocalInner{
			int iv = 300;
//			static int cv = 300;	// 에러!, static 변수를 선언할 수 없음
			final static int CONST = 300;	// final static은 상수이므로 허용
		}
		
		System.out.println(LocalInner.CONST);
	}
	
	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);	// 인스턴스 멤버(InstanceInner)의 클래스 멤버 접근
		System.out.println(StaticInner.cv);			// 정적 멤버(StaticInner)의 클래스 멤버 접근
		new InnerEx1().myMethod();
	}
}
