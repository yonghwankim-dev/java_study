package toy.toy_03_slaythespire.card.defense;

import toy.toy_03_slaythespire.card.Card;
import toy.toy_03_slaythespire.card.DefenseCard;

public class Defend extends DefenseCard{

	private Defend(String name, int cost, KIND kind, int defense) {
		super(name, cost, kind, defense);
	}
	
	public static Card Defend() {
		return new Defend("defend", 1, KIND.DEFEND, 5);
	}

}
