package ch07.ex_31_innerClass1;

/**
 * title : inner class (인스턴스 클래스)와 inner static class (정적 멤버 클래스)의 차이
 * 1. 인스턴스 클래스 객체 생성시 단점
 * - 참조값을 담아야 하기 때문에 인스턴스 생성시 시간적, 공간적으로 성능이 낮아짐
 * - 외부 인스턴스에 대한 참조가 존재하기 때문에, 가비지 컬렉션이 인스턴스 수거를 하지 못하여 메모리 누수
 * 가 발생할 수 있음
 * 
 * 결론
 * 1. 인스턴스 클래스를 생성해야 하는 경우가 발생시 외부 클래스로 빼도록함
 * 2. 다른 외부 클래스가 접근하지 못하게 해야한다면 내부 클래스 생성시 static을 적용하여
 * 정적 멤버 클래스로 정의함
 * 
 */
public class MyClass {
	void myMethod() {
		System.out.println("call myMethod");
	}
	
	// 내부 클래스 (인스턴스 클래스)
	class InnerClass{
		void innerClassMethod() {
			MyClass.this.myMethod();	// 숨은 외부 참조가 있기 때문에 가능함
		}
	}
	
	// 정적 멤버 클래스 (static 클래스)
	static class StaticInnerClass{
		void staticInnerClassMethod() {
			// myMethod 메서드는 인스턴스 멤버이기 때문에 참조할 수 없음
//			MyClass.this.myMethod();	// 컴파일 에러
		}
	}
	
	public static void main(String[] args) {
		// Case1 : 내부 클래스 객체 생성
		// InnerClass 내부 클래스 타입의 객체를 생성하기 위해서 외부 클래스인 MyClass 객체를
		// 생성한 다음 객체를 생성해야함
		MyClass.InnerClass obj1 = new MyClass().new InnerClass();
		MyClass.InnerClass obj2 = new MyClass().new InnerClass();
		// 두 객체(obj1, obj2)는 타입은 같지만 각각 다른 객체이므로 서로 다름
		System.out.println("obj1 == obj2 : " + (obj1 == obj2));	// false
		
		// Case2 : 정적 멤버 클래스 객체 생성
		// StaticInnerClass 정적 멤버 클래스 타입의 객체를 생성하기 위해서 외부 클래스인 MyClass
		// 객체를 생성하지 않아도 바로 참조하여 객체를 생성할 수 있음
		MyClass.StaticInnerClass obj3 = new MyClass.StaticInnerClass();
		MyClass.StaticInnerClass obj4 = new MyClass.StaticInnerClass();
		// 두 객체(obj3, obj4)는 타입은 같지만 각각 다른 객체이므로 서로 다름
		System.out.println("obj3 == obj4 : " + (obj3 == obj4));	// false
		
		// Case1, Case2 방식의 차이
		// 내부 클래스 같은 경우는 인스턴스 멤버이므로 외부 클래스의 객체 생성이 전제됨
		// 정적 멤버 클래스는 클래스 초기화시 생성되기 때문에 외부 클래스의 객체 생성이 전제되지 않고
		// 바로 접근이 가능함
		
		MyClass obj5 = new MyClass();
		// obj6은 obj5에 대한 숨은 외부 참조를 갖음 
		MyClass.InnerClass obj6 = obj5.new InnerClass();
		// obj7은 숨은 외부 참조를 갖지 않음
		MyClass.StaticInnerClass obj7 = new MyClass.StaticInnerClass();
		
	}
	
	
}
