package ch06.ex_28_staticBlock;

import java.util.Arrays;

/**
 * �ʱ�ȭ ��
 * - ����� �ʱ�ȭ�� ���� �迭 arr ����
 * - Ŭ���� �ʱ�ȭ�� ���ؼ� �迭�� �� ��ҵ鿡 ������ ���� ����
 *
 */
public class StaticBlockTest {
	static int[] arr = new int[10];
	
	static 
	{
		for(int i = 0; i < arr.length; i++)
		{
			// 1~10������ ���� ����
			arr[i] = (int) (Math.random() * 10) + 1;
		}
	}
	
	public static void main(String[] args)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
	}
}
