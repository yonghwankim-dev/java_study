package ch07.ex_05_super;

/**
 * super
 * - this는 현재 클래스의 객체를 가리킴, 
 * 만약 멤버변수가 현재 클래스에 없으면 상위 클래스의 멤버 변수를 참조
 * - super는 부모 클래스의 객체를 가리킴
 */
public class SuperTest {
	public static void main(String[] args)
	{
		Child c = new Child();
		c.method();
	}
}

class Parent{
	int x = 10;
}

class Child extends Parent{
	public void method() {
		System.out.printf("x=%d\n", x);
		System.out.printf("this.x=%d\n", this.x);
		System.out.printf("super.x=%d\n", super.x);
	}
}
