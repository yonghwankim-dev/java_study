package ch06.ex_05_variable;

/**
 * 
 */
public class Driver {

	public static void main(String[] args) {
		Card card1 = new Card();
		Card card2 = new Card();
		
		card1.kind = "Heart";
		card1.number = 7;
		
		card2.kind = "Spade";
		card2.number = 4;
		
		System.out.println(card1);
		System.out.println(card2);
		
		System.out.printf("Card.width : %d\n",Card.width);
		System.out.printf("Card.height : %d\n",Card.height);
		
	}

}
