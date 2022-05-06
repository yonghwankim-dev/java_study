package ch07.ex_20_binding3;

/**
 * 참조변수와 인스턴스의 연결 
 * - 조상 클래스에서 멤버 변수와 메서드에 private 사용시 자손 클래스에서 상속받지 못하고 오버라이딩 메서드를
 * 정의할 수 없음
 * 
 * - 왜 p.method() 호출시 (x, this.x)가 100이 아닌 200이 나오는가?
 * 참조변수 p는 자손 클래스(Child)의 인스턴스를 가리키고 p.method() 호출시 실제 인스턴스 메서드인
 * Child 클래스의 method()를 실행합니다. 이때 메서드 안에서 this는 실제 인스턴스인 Child 클래스
 * 인스턴스를 가리키기 때문에 this.x 참조시 100이 나옵니다. (메서드 안에서 x 참조시 this.x와 동일함)
 * 
 * 정리하면 조상 클래스 참조변수로 자손 클래스 타입의 실제 인스턴스의 오버라이딩된 메서드를 호출시 
 * 자손 클래스의 오버라이딩된 메서드를 호출하게 되고 그 메서드 안에서 멤버변수를 참조시 this는
 * 실제 인스턴스인 자손 클래스 인스턴스를 가리키고 super는 조상 클래스를 가리킵니다. 만약
 * this, super가 명시되지 않은 멤버변수 참조시에는 this.x와 동일합니다.
 */
public class BindingTest {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		
		System.out.println("p.x = " + p.x);			// 100
		System.out.println("p.x = " + p.getX());	// 200
		p.method();	// 왜 여기서 x를 참조할때 100이 아닌 200이 나오는거지?

		System.out.println();
		
		System.out.println("c.x = " + c.x);	// 200
		c.method();
	}
}

class Parent{
	int x = 100;
	
	public void method() {
		System.out.println("Parent Method");
	}
	
	public int getX() {
		return x;
	}
}

class Child extends Parent{
	int x = 200;
	
	public void method() {
		System.out.println("x = " + x);	// this.x와 동일
		System.out.println("super.x = " + super.x);
		System.out.println("this.x = " + this.x);
	}
	
	public int getX() {
		return x;
	}
}