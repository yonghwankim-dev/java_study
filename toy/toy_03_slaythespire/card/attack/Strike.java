package toy.toy_03_slaythespire.card.attack;

import toy.toy_03_slaythespire.card.AttackCard;
import toy.toy_03_slaythespire.card.Card;

public class Strike extends AttackCard{
	
	private Strike(String name, int cost, KIND kind, int damage) {
		super(name, cost, kind, damage);
	}
	
	public static Card Strike() {
		return new Strike("strike", 1, KIND.ATTACK, 6);
	}
}
