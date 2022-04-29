package ch07.ex_03_relationship2;

public class Card {
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
