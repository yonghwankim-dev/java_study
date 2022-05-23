package ch07.ex_33_innerClass3;

/**
 * title : ���� Ŭ�������� �ܺ� Ŭ������ ���� ���� 
 * 1. �ν��Ͻ� Ŭ����(InstanceInner)���� �ܺ� Ŭ����(InnerEx3)�� ����(outerIv, outerCv) ����
 * - outerIv : ��������
 * - outerCv : ��������
 * 
 * 2. static Ŭ����(StaticInner)���� �ܺ� Ŭ����(InnerEx3)�� ����(outerIv, outerCv) ����
 * - outerIv : �����Ұ��� => static ����� �ν��Ͻ� ����� ������ �� ����
 * - outerCv : ��������
 * 
 * 3. ���� Ŭ����(LocalInner)���� �ܺ� Ŭ����(InnerEx3)�� ����(outerIv, outerCv) ����
 * - outerIv : ��������
 * - outerCv : ��������
 * - lv : ��������
 * - LV : ��������
 */
public class InnerEx3 {
	private int outerIv = 0;
	static int outerCv = 0;
	
	class InstanceInner{
		int iiv = outerIv;	// �ܺ� Ŭ����(InnerEx3)�� private ����� ������ ������
		int iiv2 = outerCv;
	}
	
	static class StaticInner{
		// static Ŭ������ �ܺ� Ŭ����(InnerEx3)�� �ν��Ͻ� ���(outerIv)�� ������ �� ����
//		int siv = outerIv;
		static int scv = outerCv;
	}
	
	void myMethod() {
		int lv = 0;
		final int LV = 0;	// jdk 1.8���� final ���� ����
		
		class LocalInner{
			int liv = outerIv;
			int liv2 = outerCv;
			// �ܺ� Ŭ������ ���������� final�� ���� ����(���)�� ������ ������
			int liv3 = lv;	// jdk 1.8���� ������ �ƴ�
			int liv4 = LV;
		}
	}
}
