package ch07.ex_06_super2;

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
	int x = 20;
	public void method() {
		System.out.printf("x=%d\n", x);
		System.out.printf("this.x=%d\n", this.x);
		System.out.printf("super.x=%d\n", super.x);
	}
}
