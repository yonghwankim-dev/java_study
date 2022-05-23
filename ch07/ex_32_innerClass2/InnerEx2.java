package ch07.ex_32_innerClass2;

import ch07.ex_32_innerClass2.InnerEx2.StaticInner;

/**
 * title : 인스턴스 클래스 & static 클래스
 * 1. 인스턴스 클래스는 외부 클래스(InnerEx2)의 인스턴스 멤버를 객체생성 없이 바로 사용할 수 있음
 * 2. static 클래스는 외부 클래스(InnerEx2)의 인스턴스 멤버를 객체생성 없이 사용할 수 없음
 * 3. 인스턴스 클래스는 static 클래스의 멤버들을 객체생성없이 사용할수 있음
 * 4. static 클래스는 인스턴스 클래스의 멤버들을 객체 생성없이 사용할 수 없음
 */
public class InnerEx2 {
	class InstanceInner{}
	static class StaticInner{}
	
	// 인스턴스멤버 간에는 서로 직접 접근이 가능함
	InstanceInner iv = new InstanceInner();
	
	// static 멤버간에는 서로 직접 접근이 가능함
	static StaticInner cv = new StaticInner();
	
	static void staticMethod() {
		// static 멤버(staticMethod)는 인스턴스 멤버(InstanceInner 클래스)에 접근할 수 없음
//		InstanceInner obj1 = new InstanceInner();
		
		// static 멤버(staticMethod)는 정적 멤버(StaticInner 클래스)에 접근할 수 있음
		StaticInner obj2 = new StaticInner();
		
		// 인스턴스 클래스에 접근하기 위해서는 외부 클래스(InnerEx2 클래스)의 객체를 생성한다음
		// 내부 클래스(InstanceInner)를 객체생성할 수 있음
		InnerEx2 outer = new InnerEx2();
		InstanceInner obj1 = outer.new InstanceInner();
		InstanceInner obj3 = outer.iv;	// 클래스 인스턴스 멤버를 참조함
		
	}
	
	void myMethod() {
		class LocalInner{}
		LocalInner lv = new LocalInner();
	}
	
	void instanceMethod() {
		// 인스턴스 메서드(instanceMethod 메서드)에서는 인스턴스 멤버(InstanceInner 클래스, iv)와
		// static 멤버(cv, staticMethod) 모두 접근이 가능함
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		
		// 메서드 내에 지역적으로 선언된 내부 크래스는 외부에서 접근할 수 없음
//		LocalInner lv = new LocalInner();
		
	}
}
