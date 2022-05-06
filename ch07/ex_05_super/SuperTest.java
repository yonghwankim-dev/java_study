package ch07.ex_05_super;

/**
 * super
 * - this�� ���� Ŭ������ ��ü�� ����Ŵ, 
 * ���� ��������� ���� Ŭ������ ������ ���� Ŭ������ ��� ������ ����
 * - super�� �θ� Ŭ������ ��ü�� ����Ŵ
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
