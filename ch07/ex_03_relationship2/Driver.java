package ch07.ex_03_relationship2;

public class Driver {
	public static void main(String[] args)
	{
		Deck d = new Deck();	// ī�� �ѹ��� ����
		Card c = d.pick(0);		// ������ ���� ���� ī�带 ��ο�
		
		System.out.println(c);
		
		d.shuffle();			// ���� ����
		c = d.pick(0);			// ���� ���� ī�带 ��ο�
		
		System.out.println(c);
		
	}
}
