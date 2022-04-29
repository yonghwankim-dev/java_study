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
