package ch07.ex_03_relationship2;

public class Driver {
	public static void main(String[] args)
	{
		Deck d = new Deck();	// 카드 한벌을 생성
		Card c = d.pick(0);		// 섞기전 제일 위의 카드를 드로우
		
		System.out.println(c);
		
		d.shuffle();			// 덱을 석음
		c = d.pick(0);			// 제일 위의 카드를 드로우
		
		System.out.println(c);
		
	}
}

class Card {
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

class Deck {
	final int CARD_NUM = 52;				// 카드의 개수
	Card[] cardArr = new Card[CARD_NUM];	// Card 객체 배열을 포함
	
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
	 * Deck에서 지정한 위치에 있는 카드 하나 선택
	 * @param index 지정한 위치
	 * @return 선택한 카드
	 */
	public Card pick(int index) {
		return cardArr[index];
	}
	/**
	 * Deck에서 카드를 하나 선택
	 * @return 선택한 카드
	 */
	public Card pick() {
		int index = (int) (Math.random() * CARD_NUM);
		return pick(index);
	}
	/**
	 * 카드의 순서를 섞음
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
