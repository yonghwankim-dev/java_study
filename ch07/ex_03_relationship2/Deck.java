package ch07.ex_03_relationship2;

public class Deck {
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
