package toy.toy_03_slaythespire.strategy;

import toy.toy_03_slaythespire.card.Card;
import toy.toy_03_slaythespire.unit.Unit;

public interface CardUsable {
	public void use(Unit target, Card card);
}
