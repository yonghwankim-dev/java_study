package toy.toy_03_slaythespire.card;

import toy.toy_03_slaythespire.unit.Unit;

public class DefenseCard extends Card{
	private int defense;

	public DefenseCard(String name, int cost, KIND kind, int defense) {
		super(name, cost, kind);
		this.defense = defense;
	}

	@Override
	public void use(Unit target) {
		target.hitPoint += defense;
	}

	public int getDefense() {
		return defense;
	}
}
