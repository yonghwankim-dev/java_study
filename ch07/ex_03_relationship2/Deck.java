package ch07.ex_03_relationship2;

public class Deck {
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
