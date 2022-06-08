package ch07.ex_31_innerClass1;

public class Person {
	String name;
	static final String KIND = "human"; // 정적(클래스) 멤버
	
	static void method() {
		// name 인스턴스 멤버는 아직 객체생성을 하지 않았기 때문에 정적 멤버(method)는
		// name을 참조할 수 없음, 컴파일 에러
//		System.out.println(name);
		// KIND 정적 멤버는 클래스 초기화시 할당됬기 때문에 참조가 가능함
		System.out.println(KIND);
	}
	
	void sayName() {
		// 인스턴스 멤버인 sayName은 같은 인스턴스 멤버인 name 필드멤버를 참조가 가능함
		System.out.println(name);
		// 인스턴스 멤버인 sayName은 모든 객체가 공유하는 멤버인 정적 멤버를 참조가 가능함
		System.out.println(KIND);
	}	
}
