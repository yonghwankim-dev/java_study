package ch07.ex_32_innerClass2;

import ch07.ex_32_innerClass2.InnerEx2.StaticInner;

/**
 * title : �ν��Ͻ� Ŭ���� & static Ŭ����
 * 1. �ν��Ͻ� Ŭ������ �ܺ� Ŭ����(InnerEx2)�� �ν��Ͻ� ����� ��ü���� ���� �ٷ� ����� �� ����
 * 2. static Ŭ������ �ܺ� Ŭ����(InnerEx2)�� �ν��Ͻ� ����� ��ü���� ���� ����� �� ����
 * 3. �ν��Ͻ� Ŭ������ static Ŭ������ ������� ��ü�������� ����Ҽ� ����
 * 4. static Ŭ������ �ν��Ͻ� Ŭ������ ������� ��ü �������� ����� �� ����
 */
public class InnerEx2 {
	class InstanceInner{}
	static class StaticInner{}
	
	// �ν��Ͻ���� ������ ���� ���� ������ ������
	InstanceInner iv = new InstanceInner();
	
	// static ��������� ���� ���� ������ ������
	static StaticInner cv = new StaticInner();
	
	static void staticMethod() {
		// static ���(staticMethod)�� �ν��Ͻ� ���(InstanceInner Ŭ����)�� ������ �� ����
//		InstanceInner obj1 = new InstanceInner();
		
		// static ���(staticMethod)�� ���� ���(StaticInner Ŭ����)�� ������ �� ����
		StaticInner obj2 = new StaticInner();
		
		// �ν��Ͻ� Ŭ������ �����ϱ� ���ؼ��� �ܺ� Ŭ����(InnerEx2 Ŭ����)�� ��ü�� �����Ѵ���
		// ���� Ŭ����(InstanceInner)�� ��ü������ �� ����
		InnerEx2 outer = new InnerEx2();
		InstanceInner obj1 = outer.new InstanceInner();
		InstanceInner obj3 = outer.iv;	// Ŭ���� �ν��Ͻ� ����� ������
		
	}
	
	void myMethod() {
		class LocalInner{}
		LocalInner lv = new LocalInner();
	}
	
	void instanceMethod() {
		// �ν��Ͻ� �޼���(instanceMethod �޼���)������ �ν��Ͻ� ���(InstanceInner Ŭ����, iv)��
		// static ���(cv, staticMethod) ��� ������ ������
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		
		// �޼��� ���� ���������� ����� ���� ũ������ �ܺο��� ������ �� ����
//		LocalInner lv = new LocalInner();
		
	}
}
