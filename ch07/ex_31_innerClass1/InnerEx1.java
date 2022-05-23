package ch07.ex_31_innerClass1;

/**
 * title : ���� Ŭ������ �����ڿ� ���ټ�
 * 1. ���� Ŭ���� �߿��� static Ŭ����(StaticInner)�� static ����� ���� �� ����
 * 2. final static�� ���ÿ� ���� ������ ����̹Ƿ� ��� ���� Ŭ�������� ���ǰ� ������
 */
public class InnerEx1 {
	class InstanceInner{
		int iv = 100;
//		static int cv = 100; // ����!, static ������ ������ �� ����
		final static int CONST = 100;	// final static�� ����̹Ƿ� ���
	}
	
	static class StaticInner{
		int iv = 200;
		static int cv = 200;	// static Ŭ������ static ����� ������ �� ����
	}
	
	public void myMethod() {
		class LocalInner{
			int iv = 300;
//			static int cv = 300;	// ����!, static ������ ������ �� ����
			final static int CONST = 300;	// final static�� ����̹Ƿ� ���
		}
		
		System.out.println(LocalInner.CONST);
	}
	
	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);	// �ν��Ͻ� ���(InstanceInner)�� Ŭ���� ��� ����
		System.out.println(StaticInner.cv);			// ���� ���(StaticInner)�� Ŭ���� ��� ����
		new InnerEx1().myMethod();
	}
}
