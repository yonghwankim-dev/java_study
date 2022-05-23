package ch07.ex_36_innerClass6;

/**
 * title : �͸� Ŭ����(anonymous class)
 * 1. �͸� Ŭ���� ����
 * new ���� Ŭ���� �̸�(){ // ��� ���� }
 * or
 * new �����������̽��̸�(){ // ��� ���� } 
 *
 * 2. �͸� Ŭ������ �̸��� ���� ������ �����ڸ� ���� �� ����
 * 3. ���� Ŭ������ �̸��̳� �����ϰ��� �ϴ� �������̽��� �̸��� ����ؼ� ������
 * 4. ���� �� �ϳ��� Ŭ������ ��ӹްų� �� �ϳ��� �������̽����� ������ �� ����
 */
public class InnerEx6{
	Object iv = new Object() { // �͸� Ŭ����
		void method() {
			System.out.println("call anonymous class method1");
		}
	};
	
	static Object cv = new Object() { // �͸� Ŭ����
		void method() {
			System.out.println("call anonymous class method2");
		}
	};
	
	void myMethod() {
		Object lv = new Object() {	// �͸� Ŭ����
			void method() {
				System.out.println("call nonymous class method3");
			}
		};
		
	}
}