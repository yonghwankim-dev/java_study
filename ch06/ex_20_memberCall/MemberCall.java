package ch06.ex_20_memberCall;

public class MemberCall {
	int iv = 10;		// �ν��Ͻ� ����
	static int cv = 20;	// Ŭ���� ����
	
	int iv2 = cv;
//	static int cv2 = iv;	// ����, Ŭ���������� �ν��ϼ� ������ ����� �� ����
	static int cv2 = new MemberCall().iv;	// ��ü�� �����Ŀ� ����� �� ����
	
	public static void staticMethod1()
	{
		System.out.println(cv);
//		System.out.println(iv);	// ����, Ŭ�����޼��忡�� �ν��Ͻ� ���� ���Ұ�
		MemberCall c= new MemberCall();
		System.out.println(c.iv);	// ��ü�� �������Ŀ� ��� ����
	}
	
	public void instanceMethod1() 
	{
		System.out.println(cv);
		System.out.println(iv);	// �ν��Ͻ� �޼��忡���� �ν��Ͻ����� ��밡��
	}
	
	public static void staticMethod2()
	{
		staticMethod1();
//		instanceMethod1();	// ����, Ŭ�����޼��忡���� �ν��Ͻ� �޼��� ȣ�� �Ұ���
		MemberCall c = new MemberCall();
		c.instanceMethod1(); // ��ü�� ������ �Ŀ� ȣ�� ������
	}
	
	public void instanceMethod2()
	{
		staticMethod1();	// �ν��Ͻ� �޼���� Ŭ���� �޼��� ȣ�� ����
		instanceMethod1();	// �ν��Ͻ� �޼���� �ν��Ͻ� �޼��� ȣ�� ����
	}
	
}
