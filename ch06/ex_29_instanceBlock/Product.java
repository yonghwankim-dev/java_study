package ch06.ex_29_instanceBlock;

import java.util.Arrays;

/**
 * �ν��Ͻ� ��� Ȱ�� ���� 
 * - �ν��Ͻ��� �����Ҷ����� �ν��Ͻ� �ʱ�ȭ ���� �����
 */
public class Product {
	static int count = 0;	// ������ �ν����� ���� �����ϱ� ���� ����
	int serialNo;			// �ν��Ͻ� ���� ��ȣ
	
	{
		count++;
		serialNo = count;
	}
	
	public Product() {
		
	}
	
	public static void main(String[] args)
	{
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.printf("p1�� ��ǰ��ȣ(serialNo) = %d\n", p1.serialNo);
		System.out.printf("p2�� ��ǰ��ȣ(serialNo) = %d\n", p2.serialNo);
		System.out.printf("p3�� ��ǰ��ȣ(serialNo) = %d\n", p3.serialNo);
		System.out.printf("���� ������ ��ǰ �� = %d\n", Product.count);
		
		
	}
}
