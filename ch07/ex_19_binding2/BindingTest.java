package ch07.ex_19_binding2;

/**
 * ���������� �ν��Ͻ��� ���� 2
 * ���� ������ ���� ����(ex18)�ʹ� �ٸ��� �ڼ� Ŭ������ �ߺ��� ��������� �������̵��� �޼��尡 ���� 
 * ����Դϴ�.
 * 
 * - ���� Ŭ����(Parent) ���������� �ڼ� Ŭ����(Child) �������� ��� �ڼ� Ŭ���� Ÿ���� �ν��Ͻ��� 
 * ����Ŵ
 * - c.x ȣ��� �ڼ� Ŭ������ ����������� x������ �����Ƿ� ���� Ŭ������ �ö󰡼� x�� �ִ��� Ž���ϰ�
 * �ִٸ� ��ȯ�մϴ�. c.x = 100
 * - p.method() ȣ��� Child Ŭ������ �������̵��� �޼��尡 �����Ƿ� Parent Ŭ������ method()��
 * ȣ���մϴ�. (Parent Method)
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