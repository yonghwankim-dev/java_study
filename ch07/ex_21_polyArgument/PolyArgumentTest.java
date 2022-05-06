package ch07.ex_21_polyArgument;

/**
 * �Ű������� ������
 * - ���������� �������� Ư¡�� �Ű��������� �����
 * - �Ű������� �������� Ÿ���� ���� Ŭ������ �����ϸ� �޼��� ȣ��� �����ϴ� ������ Ÿ����
 * �ش� ���� Ŭ���� Ÿ���̰ų� �ڼ� Ŭ���� Ÿ���� �ν��Ͻ��� �� �� �ֽ��ϴ�.
 * 
 * - b.buy(new TV()) => buy(Product p)
 * buy �޼��� ȣ��� Product Ŭ������ �ڼ� Ŭ������ TV Ŭ������ �����մϴ�.
 * �������� p�� ���� Ŭ�����̹Ƿ� �ν��Ͻ��� ����ų �� �ֽ��ϴ�. 
 */
public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new TV());
		b.buy(new Computer());
		
		System.out.printf("���� ���� ���� %d �����Դϴ�.\n", b.money);
		System.out.printf("���� ���ʽ������� %d ���Դϴ�.\n", b.bonusPoint);
	}
}

class Product{
	int price;		// ��ǰ ����
	int bonusPoint;	// ��ǰ���Ž� �����ϴ� ���ʽ� ����
	
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

class Buyer{	// ��, ������ ��� ���
	int money = 1000;	// �����ݾ�
	int bonusPoint = 0; // ���ʽ�����
	
	// �Ű������� Product Ŭ������ Product Ŭ������ �ڼ� Ŭ�������� ���� �� ����
	public void buy(Product p) {	
		if(money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ ��� �����ϴ�.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.printf("%s ��/�� �����Ͽ����ϴ�.\n", p);
	}
}