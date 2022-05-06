package ch07.ex_18_binding;	

/**
 * 참조변수와 인스턴스의 연결
 * - 조상 클래스 타입의 참조 변수는 자손 클래스 타입의 인스턴스를 참조할 수 있음
 * - Parent 클래스와 Child 클래스 모두 x라는 멤버 변수를 가지고 있음
 * 
 * 조상 클래스 타입의 참조 변수와 자손 클래스 타입의 참조변수의 차이점
 * - 조상 클래스 참조변수(Parent)와 자손 클래스 참조변수(Child)가 자손 클래스 타입의 
 * 인스턴스(new Child())를 가리킨다고 가정합니다.
 * - 이때 메서드의 경우 참조변수의 타입(Parent, Child)에 관계없이 
 * 실제 인스턴스 메서드(오버라이딩된 메서드)가 호출됩니다.
 * - 하지만 멤버 변수의 경우 참조 변수의 타입에 따라 달라집니다. 
 *   멤버변수가 조상 클래스(Parent)와 자손 클래스(Child)에 중복으로 정의된 경우,
 *   조상 타입의 참조 변수를 사용했을 때는 조상 클래스에 선언된 멤버변수가 사용됨,
 *   자손 타입의 참조변수를 사용했을때는 자손 클래스에 선언된 멤버변수가 사용됨
 *   
 * 왜 자손 클래스 타입의 인스턴스를 가리킴에도 조상 클래스 타입의 멤버변수를 가리키는가?
 * - Parent p = new Child();
 * - p.x = 100
 * - 조상 클래스 타입의 참조변수가 자손 클래스 타입의 인스턴스를 가리키게 되고 조상 클래스에서 
 * 오버라이딩된 메서드를 호출하면 조상 클래스 타입을 가진 참조변수 입장에서는 호출할 수 있고(조상 클래스는
 * 조상 클래스가 가진 멤버변수와 메서드만을 호출할 수 있음) 실제 가리키고 있는 주소에는 자손 클래스의
 * 인스턴스가 저장되어 있기 때문에 오버라이딩된 메서드를 호출합니다. 그래서 조상 클래스 참조변수가
 * 자손 클래스의 인스턴스를 저장하고 오버라이딩된 메서드를 호출할때 실제 인스턴스의 메서드(오버라이딩된)를
 * 호출하는 이유입니다. 
 * 
 * 
 */
public class BindingTest {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		
		System.out.println("p.x = " + p.x);	// 100
		p.method();	// 자손 클래스(Child)의 메서드 호출, "Child Method" 출력
		
		System.out.println("c.x = " + c.x);	// 200
		c.method();	// 자손 클래스에 오버라이딩된 메서드가 존재하면 자손 클래스의 메서드 호출
					// 만약 자손 클래스에 오버라이됭된 메서드가 존재하지 않으면 조상 클래스의
					// 메서드를 호출
	}
}

class Parent{
	int x = 100;
	
	public void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent{
	int x = 200;
	
	public void method() {
		System.out.println("Child Method");
	}
}