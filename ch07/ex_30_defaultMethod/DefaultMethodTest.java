package ch07.ex_30_defaultMethod;

public class DefaultMethodTest {

	public static void main(String[] args) {
		Child c = new Child();
		c.method1();	// 여러 인터페이스의 디폴트 메서드 간의 충돌 : 
						// 인터페이스를 구현한 클래스(Child)에서 디폴트 메서드를 오버라이딩해야함
		
		c.method2();	// 디폴트 메서드와 조상클래스 간의 메서드 충돌 : 
						//조상 클래스의 메서드가 상속됨
		MyInterface.staticMethod();
		MyInterface2.staticMethod();
	}

}
