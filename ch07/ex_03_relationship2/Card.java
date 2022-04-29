package ch07.ex_03_relationship2;

public class Card {
	static final int KIND_MAX = 4;	// 카드 무늬 개수
	static final int NUM_MAX = 13;	// 무늬별 카드 수
	
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
		String numbers = "0123456789XJQK";	// 10은 X로 표현
		
		return "kind : " + kinds[this.kind] + ", number : " + numbers.charAt(number); 
	}
	
	
	
}
