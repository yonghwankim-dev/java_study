package ch07.ex_23_polyArgument3;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * ���� ������ ��ü�� �迭�� �ٷ��
 * - ���� ProductŸ�� �迭�� ũ�Ⱑ �������̾ 10���� �ʰ��ϴ� ��ǰ�� ������ �� �����ϴ�.
 * - �� ������ �ذ��ϱ� ���ؼ� Product Ÿ�� �迭�� Vector Ŭ������ �����
 * - Vector Ŭ������ ����ϸ� ũ�⸦ �������� �߰��� �� ����
 */
public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		TV tv = new TV();
		Computer com = new Computer();
		Audio audio = new Audio();
		
		b.buy(tv);
		b.buy(com);
		b.buy(audio);		
		b.summary();
		
		System.out.println();
		
		b.refund(com);
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
	Vector<Product> item;		// ������ ��ǰ�� �����ϱ� ���� �迭
	
	public Buyer() {
		money = 1000;
		bonusPoint = 0;
		item = new Vector<Product>();
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
		item.add(p);
		System.out.printf("%s ��/�� �����Ͽ����ϴ�.\n", p);
	}
	
	/**
	 * ��ǰ p�� ��ǰ�ϴ� ���
	 * @param p ��ǰ�ϰ��� �ϴ� ��ǰ
	 */
	public void refund(Product p) {
		if(item.contains(p)) {	// ��ǰ ������ ���
			item.remove(p);
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.printf("%s ��/�� ��ǰ�ϼ̽��ϴ�.\n", p);
		}
		else	// ��ǰ ������ ���
		{
			System.out.printf("�����Ͻ� ��ǰ �� �ش� ��ǰ�� �����ϴ�.");
		}
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
			sum += p.price;
			itemList.append(p+",");	
		}
		
		// ���� �� �޸� ����
		itemList.deleteCharAt(itemList.length()-1);
		
		System.out.printf("�����Ͻ� ��ǰ�� �ѱݾ��� %d �����Դϴ�.\n", sum);
		System.out.printf("�����Ͻ� ��ǰ�� %s �Դϴ�.\n", itemList.toString());
		System.out.printf("���� ������ ���ʽ� ����Ʈ�� %d ���Դϴ�.\n", bonusPoint);
	}
}