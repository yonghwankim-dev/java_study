package ch07.ex_30_defaultMethod;

public class DefaultMethodTest {

	public static void main(String[] args) {
		Child c = new Child();
		c.method1();	// ���� �������̽��� ����Ʈ �޼��� ���� �浹 : 
						// �������̽��� ������ Ŭ����(Child)���� ����Ʈ �޼��带 �������̵��ؾ���
		
		c.method2();	// ����Ʈ �޼���� ����Ŭ���� ���� �޼��� �浹 : 
						//���� Ŭ������ �޼��尡 ��ӵ�
		MyInterface.staticMethod();
		MyInterface2.staticMethod();
	}

}
