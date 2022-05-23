package ch07.ex_31_innerClass1;

/**
 * title : inner class (�ν��Ͻ� Ŭ����)�� inner static class (���� ��� Ŭ����)�� ����
 * 1. �ν��Ͻ� Ŭ���� ��ü ������ ����
 * - �������� ��ƾ� �ϱ� ������ �ν��Ͻ� ������ �ð���, ���������� ������ ������
 * - �ܺ� �ν��Ͻ��� ���� ������ �����ϱ� ������, ������ �÷����� �ν��Ͻ� ���Ÿ� ���� ���Ͽ� �޸� ����
 * �� �߻��� �� ����
 * 
 * ���
 * 1. �ν��Ͻ� Ŭ������ �����ؾ� �ϴ� ��찡 �߻��� �ܺ� Ŭ������ ��������
 * 2. �ٸ� �ܺ� Ŭ������ �������� ���ϰ� �ؾ��Ѵٸ� ���� Ŭ���� ������ static�� �����Ͽ�
 * ���� ��� Ŭ������ ������
 * 
 */
public class MyClass {
	void myMethod() {
		System.out.println("call myMethod");
	}
	
	// ���� Ŭ���� (�ν��Ͻ� Ŭ����)
	class InnerClass{
		void innerClassMethod() {
			MyClass.this.myMethod();	// ���� �ܺ� ������ �ֱ� ������ ������
		}
	}
	
	// ���� ��� Ŭ���� (static Ŭ����)
	static class StaticInnerClass{
		void staticInnerClassMethod() {
			// myMethod �޼���� �ν��Ͻ� ����̱� ������ ������ �� ����
//			MyClass.this.myMethod();	// ������ ����
		}
	}
	
	public static void main(String[] args) {
		// Case1 : ���� Ŭ���� ��ü ����
		// InnerClass ���� Ŭ���� Ÿ���� ��ü�� �����ϱ� ���ؼ� �ܺ� Ŭ������ MyClass ��ü��
		// ������ ���� ��ü�� �����ؾ���
		MyClass.InnerClass obj1 = new MyClass().new InnerClass();
		MyClass.InnerClass obj2 = new MyClass().new InnerClass();
		// �� ��ü(obj1, obj2)�� Ÿ���� ������ ���� �ٸ� ��ü�̹Ƿ� ���� �ٸ�
		System.out.println("obj1 == obj2 : " + (obj1 == obj2));	// false
		
		// Case2 : ���� ��� Ŭ���� ��ü ����
		// StaticInnerClass ���� ��� Ŭ���� Ÿ���� ��ü�� �����ϱ� ���ؼ� �ܺ� Ŭ������ MyClass
		// ��ü�� �������� �ʾƵ� �ٷ� �����Ͽ� ��ü�� ������ �� ����
		MyClass.StaticInnerClass obj3 = new MyClass.StaticInnerClass();
		MyClass.StaticInnerClass obj4 = new MyClass.StaticInnerClass();
		// �� ��ü(obj3, obj4)�� Ÿ���� ������ ���� �ٸ� ��ü�̹Ƿ� ���� �ٸ�
		System.out.println("obj3 == obj4 : " + (obj3 == obj4));	// false
		
		// Case1, Case2 ����� ����
		// ���� Ŭ���� ���� ���� �ν��Ͻ� ����̹Ƿ� �ܺ� Ŭ������ ��ü ������ ������
		// ���� ��� Ŭ������ Ŭ���� �ʱ�ȭ�� �����Ǳ� ������ �ܺ� Ŭ������ ��ü ������ �������� �ʰ�
		// �ٷ� ������ ������
		
		MyClass obj5 = new MyClass();
		// obj6�� obj5�� ���� ���� �ܺ� ������ ���� 
		MyClass.InnerClass obj6 = obj5.new InnerClass();
		// obj7�� ���� �ܺ� ������ ���� ����
		MyClass.StaticInnerClass obj7 = new MyClass.StaticInnerClass();
		
	}
	
	
}
