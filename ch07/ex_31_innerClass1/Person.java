package ch07.ex_31_innerClass1;

public class Person {
	String name;
	static final String KIND = "human"; // ����(Ŭ����) ���
	
	static void method() {
		// name �ν��Ͻ� ����� ���� ��ü������ ���� �ʾұ� ������ ���� ���(method)��
		// name�� ������ �� ����, ������ ����
//		System.out.println(name);
		// KIND ���� ����� Ŭ���� �ʱ�ȭ�� �Ҵ��� ������ ������ ������
		System.out.println(KIND);
	}
	
	void sayName() {
		// �ν��Ͻ� ����� sayName�� ���� �ν��Ͻ� ����� name �ʵ����� ������ ������
		System.out.println(name);
		// �ν��Ͻ� ����� sayName�� ��� ��ü�� �����ϴ� ����� ���� ����� ������ ������
		System.out.println(KIND);
	}	
}
