package ch06.ex_27_initblock;

/**
 * �ʱ�ȭ ��
 * Ŭ���� �ʱ�ȭ �� : Ŭ������ �޸𸮿� �ε��ɶ� �� �ѹ��� ����
 * �ν��Ͻ� �ʱ�ȭ �� : ��ü�� �����ɶ����� �����
 *
 */
public class BlockTest {
	static 
	{
		System.out.println("static { }");
	}
	
	{
		System.out.println("{ }");
	}
	
	public BlockTest() {
		System.out.println("������");
	}
	
	public static void main(String[] args)
	{
		System.out.println("BlockTest bt = new BlockTest();");
		BlockTest bt = new BlockTest();
		
		System.out.println("BlockTest bt2 = new BlockTest();");
		BlockTest bt2 = new BlockTest();
	}
}
