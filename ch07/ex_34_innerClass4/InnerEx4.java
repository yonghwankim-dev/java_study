package ch07.ex_34_innerClass4;

/**
 * title : �ٸ� Ŭ�������� ���� Ŭ���� ���� �� ����
 * 1. �ܺ� Ŭ����(Outer)�� �ƴ� �ٸ� Ŭ����(InnerEx4)���� ���� Ŭ����(InstanceInner)��
 * �����ϰ� ���� Ŭ������ ����� �����ϴ� ���� �߻��ؼ��� �ȵ� 
 *
 */
class Outer{
	class InstanceInner{
		int iv = 100;
	}
	
	static class StaticInner{
		int iv = 200;
		static int cv = 300;
	}
	
	void myMethod() {
		class LocalInner{
			int iv = 400;
		}
	}
}

public class InnerEx4 {
	public static void main(String[] args) {
		// �ν��Ͻ� Ŭ����(InstanceInner)�� �ν��Ͻ��� �����Ϸ���
		// �ܺ� Ŭ����(Outer)�� �ν��Ͻ��� ���� �����ؾ���
		Outer oc = new Outer();
		Outer.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv : " + ii.iv);
		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);
		
		// static ���� Ŭ����(StaticInner)�� �ν��Ͻ��� �ܺ� Ŭ����(Outer)�� ���� �������� �ʾƵ���
		Outer.StaticInner si = new Outer.StaticInner();
		System.out.println("si.iv : " + si.iv);
	}
}
