package toy.toy_03_slaythespire.card;

import toy.toy_03_slaythespire.unit.Unit;

public class AttackCard extends Card{
	private int damage;
			
	public AttackCard(String name, String kind, int cost, int damage) {
		super(name, kind, cost);
		this.damage = damage;
	}
	
	@Override
	public void use(Unit target) {
		target.hitPoint -= damage;
	}
}
