package toy.toy_03_slaythespire.unit;

import java.util.ArrayList;
import java.util.List;

import toy.toy_03_slaythespire.card.Card;
import toy.toy_03_slaythespire.card.attack.Strike;
import toy.toy_03_slaythespire.card.defense.Defend;
import toy.toy_03_slaythespire.strategy.CardUsable;

public class Hero extends Unit implements CardUsable{

	public Hero(int max_hp) {
		super("Ironclad", max_hp);
	}
			
	@Override
	public void use(Unit target, Card card) {
		card.use(target);
	}	
}
