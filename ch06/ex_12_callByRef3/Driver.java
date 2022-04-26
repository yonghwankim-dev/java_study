package ch06.ex_12_callByRef3;

/**
 * ��ȯ���� ���� callbyref ���
 * ������ �Ű������� Ȱ���ϸ� ��ȯ���� ��� return���� ������� �ʾƵ�
 * ���� ����� ���� �� ����
 */
public class Driver {
	
	public static int add(int a, int b)
	{
		return a + b;
	}
	
	public static void add(int a, int b, int[] result)
	{
		result[0] = a + b;
	}
	
	public static void main(String[] args) {
		Driver r = new Driver();
		
		int result = r.add(3, 5);
		System.out.printf("r.add(3,5) = %d\n", result);
		
		int[] result2 = {0};
		r.add(3, 5, result2);
		System.out.printf("r.add(3,5,result) = %d\n", result2[0]);
		
			
	}
}
