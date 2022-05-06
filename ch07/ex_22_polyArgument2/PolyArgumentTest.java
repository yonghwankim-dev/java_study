package ch07.ex_22_polyArgument2;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� ������ ��ü�� �迭�� �ٷ��
 * - Product[] item = new Product[10]�� ���� �����ϸ� Buyer Ŭ������
 * �ڽ��� ������ �������� ��ǰ���� ������ �� �ֽ��ϴ�.
 */
public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new TV());
		b.buy(new Computer());
		b.buy(new Audio());
		
		b.summary();
	}
}

class Product{
	int price;		// ��ǰ ����
	int bonusPoint;	// ��ǰ���Ž� �����ϴ� ���ʽ� ����
	
	public Product() {
		
	}
	
	public Product(int price) {
		this.price = price;
		this.bonusPoint = (int) (price * 0.1);
	}
}

class TV extends Product{
	TV(){
		// ���� Ŭ����(Product)�� ������ Product(int price) ȣ��
		// TV�� ������ 100�������� ����
		super(100);	
	}

	@Override
	public String toString() {
		// Object Ŭ������ toString()�� �������̵���
		return "TV";
	}
}

class Computer extends Product{
	public Computer() {
		super(200);
	}

	@Override
	public String toString() {
		return "Computer";
	}
}

class Audio extends Product{
	public Audio() {
		super(50);
	}

	@Override
	public String toString() {
		return "Audio";
	}	
}

class Buyer{			// ��, ������ ��� ���
	int money;			// �����ݾ�
	int bonusPoint;		// ���ʽ�����
	Product[] item;		// ������ ��ǰ�� �����ϱ� ���� �迭
	int i;				// item �迭�� �ε���
	
	public Buyer() {
		this(10);
	}
	
	public Buyer(int capacity) {
		money = 1000;
		bonusPoint = 0;
		item = new Product[capacity];
		i = 0;
	}
	
	/**
	 * ��ǰ�� ����
	 * - �Ű������� Product Ŭ������ Product Ŭ������ �ڼ� Ŭ�������� ���� �� ���� (������)
	 * @param p �����ϰ��� �ϴ� ��ǰ
	 */
	public void buy(Product p) {	
		if(money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ ��� �����ϴ�.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.printf("%s ��/�� �����Ͽ����ϴ�.\n", p);
	}
	
	/**
	 * ������ ��ǰ�� ���� ������ ����ؼ� ������
	 */
	public void summary() {	
		int sum = 0;			// ������ ��ǰ�� �����հ�
		StringBuilder itemList = new StringBuilder();   // ������ ��ǰ���	
		
		// ������ ��ǰ���� ����Ʈ�� �߰�
		for(Product p : item)
		{
			if(p == null)
			{
				break;
			}
			sum += p.price;
			itemList.append(p+",");	
		}
		
		// ���� �� �޸� ����
		itemList.deleteCharAt(itemList.length()-1);
		
		System.out.printf("�����Ͻ� ��ǰ�� �ѱݾ��� %d �����Դϴ�.\n", sum);
		System.out.printf("�����Ͻ� ��ǰ�� %s �Դϴ�.\n", itemList.toString());
	}
}