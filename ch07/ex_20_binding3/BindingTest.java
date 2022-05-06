package ch07.ex_20_binding3;

/**
 * ���������� �ν��Ͻ��� ���� 
 * - ���� Ŭ�������� ��� ������ �޼��忡 private ���� �ڼ� Ŭ�������� ��ӹ��� ���ϰ� �������̵� �޼��带
 * ������ �� ����
 * 
 * - �� p.method() ȣ��� (x, this.x)�� 100�� �ƴ� 200�� �����°�?
 * �������� p�� �ڼ� Ŭ����(Child)�� �ν��Ͻ��� ����Ű�� p.method() ȣ��� ���� �ν��Ͻ� �޼�����
 * Child Ŭ������ method()�� �����մϴ�. �̶� �޼��� �ȿ��� this�� ���� �ν��Ͻ��� Child Ŭ����
 * �ν��Ͻ��� ����Ű�� ������ this.x ������ 100�� ���ɴϴ�. (�޼��� �ȿ��� x ������ this.x�� ������)
 * 
 * �����ϸ� ���� Ŭ���� ���������� �ڼ� Ŭ���� Ÿ���� ���� �ν��Ͻ��� �������̵��� �޼��带 ȣ��� 
 * �ڼ� Ŭ������ �������̵��� �޼��带 ȣ���ϰ� �ǰ� �� �޼��� �ȿ��� ��������� ������ this��
 * ���� �ν��Ͻ��� �ڼ� Ŭ���� �ν��Ͻ��� ����Ű�� super�� ���� Ŭ������ ����ŵ�ϴ�. ����
 * this, super�� ��õ��� ���� ������� �����ÿ��� this.x�� �����մϴ�.
 */
public class BindingTest {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		
		System.out.println("p.x = " + p.x);			// 100
		System.out.println("p.x = " + p.getX());	// 200
		p.method();	// �� ���⼭ x�� �����Ҷ� 100�� �ƴ� 200�� �����°���?

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
		System.out.println("x = " + x);	// this.x�� ����
		System.out.println("super.x = " + super.x);
		System.out.println("this.x = " + this.x);
	}
	
	public int getX() {
		return x;
	}
}