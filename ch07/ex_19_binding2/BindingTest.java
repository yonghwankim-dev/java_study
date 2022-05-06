package ch07.ex_19_binding2;

/**
 * 참조변수와 인스턴스의 연결 2
 * 다음 예제는 이전 예제(ex18)와는 다르게 자손 클래스에 중복된 멤버변수와 오버라이딩된 메서드가 없는 
 * 경우입니다.
 * 
 * - 조상 클래스(Parent) 참조변수와 자손 클래스(Child) 참조변수 모두 자손 클래스 타입의 인스턴스를 
 * 가리킴
 * - c.x 호출시 자손 클래스의 멤버변수에는 x변수가 없으므로 조상 클래스로 올라가서 x가 있는지 탐색하고
 * 있다면 반환합니다. c.x = 100
 * - p.method() 호출시 Child 클래스에 오버라이딩된 메서드가 없으므로 Parent 클래스의 method()를
 * 호출합니다. (Parent Method)
 *
 */
public class BindingTest {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		
		System.out.println("p.x = " + p.x);	// Expected Output : 100
		p.method();                         // Expected Output : Parent Method
		
		System.out.println("c.x = " + c.x); // Expected Output : 100
		c.method();                         // Expected Output : Parent Method							
	}
}

class Parent{
	int x = 100;
	
	public void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent{
}