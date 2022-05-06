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

class Card {
	static final int KIND_MAX = 4;	// ī�� ���� ����
	static final int NUM_MAX = 13;	// ���̺� ī�� ��
	
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	
	int kind;
	int number;
	
	public Card() {
		this(SPADE, 1);
	}

	public Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	@Override
	public String toString() {
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		String numbers = "0123456789XJQK";	// 10�� X�� ǥ��
		
		return "kind : " + kinds[this.kind] + ", number : " + numbers.charAt(number); 
	}	
}

class Deck {
	final int CARD_NUM = 52;				// ī���� ����
	Card[] cardArr = new Card[CARD_NUM];	// Card ��ü �迭�� ����
	
	public Deck() {
		int i = 0;
		for(int k = Card.KIND_MAX; k > 0; k--)
		{
			for(int n = 0; n < Card.NUM_MAX; n++)
			{
				cardArr[i++] = new Card(k, n+1);
			}
		}
	}
	/**
	 * Deck���� ������ ��ġ�� �ִ� ī�� �ϳ� ����
	 * @param index ������ ��ġ
	 * @return ������ ī��
	 */
	public Card pick(int index) {
		return cardArr[index];
	}
	/**
	 * Deck���� ī�带 �ϳ� ����
	 * @return ������ ī��
	 */
	public Card pick() {
		int index = (int) (Math.random() * CARD_NUM);
		return pick(index);
	}
	/**
	 * ī���� ������ ����
	 */
	public void shuffle() {
		for(int i = 0; i < CARD_NUM; i++)
		{
			int r = (int) (Math.random() * CARD_NUM);
			Card temp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = temp;
		}		
	}
}
