package toy.toy_03_slaythespire.card;

import toy.toy_03_slaythespire.unit.Unit;

public class DefenseCard extends Card{

	private int defense;
		
	public DefenseCard(String name, String kind, int cost, int defense) {
		super(name, kind, cost);
		this.defense = defense;
	}

	@Override
	public void use(Unit target) {
		target.hitPoint += defense;
	}
}
