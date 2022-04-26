package ch06.ex_05_variable;

public class Card {
	String kind;	// 카드의 종류, [하트,다이아,스페이드,클로버]
	int number;		// 카드의 숫자
	
	static int width = 100;		// 카드의 너비
	static int height = 250;	// 카드의 높이
	
	@Override
	public String toString() {
		return "Card [kind=" + kind + ", number=" + number + "]";
	}
}
