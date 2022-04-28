package ch06.ex_30_constructorInit;

import java.util.Arrays;

/**
 * ������ �ʱ�ȭ ����
 * - ������ �����Ҷ����� �̸��� ���������� ������ ������ ��Ģ�� �����ؼ�
 * �ڵ����� �̸��� ������ (�������1, �������2, ...)
 */
public class Document {
	static int count = 0;
	String name;	// ������
	
	public Document() {
		this("�������" + (++count));
	}
	
	public Document(String name){
		this.name = name;
		System.out.printf("���� %s�� �����Ǿ����ϴ�.\n", name);
	}
	
	public static void main(String[] args)
	{
		Document d1 = new Document();
		Document d2 = new Document("�ڹ�.txt");
		Document d3 = new Document();
		Document d4 = new Document();
		
	}
}
