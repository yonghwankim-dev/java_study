package ch07.ex_12_finalModifier;

class Card{
	final String KIND;
	final int NUMBER;
	static int width = 100;
	static int height = 250;
	
	public Card() {
		this("HEART", 1);
	}
	
	public Card(String kind, int number) {
		this.KIND = kind;
		this.NUMBER = number;
	}

	@Override
	public String toString() {
		return KIND + " " + NUMBER;
	}
}


public class FinalCardTest {
	public static void main(String[] args)
	{
		Card c = new Card("HEART", 10);
//		c.NUMBER = 5;	// error
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c);
	}
}
