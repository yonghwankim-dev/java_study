package toy.toy_03_slaythespire.card;

import toy.toy_03_slaythespire.unit.Unit;
public class AttackCard extends Card{
	private int damage;
				
	public AttackCard(String name, int cost, KIND kind, int damage) {
		super(name, cost, kind);
		this.damage = damage;
	}
		
	@Override
	public void use(Unit target) {
		target.hitPoint -= damage;
	}

	public int getDamage() {
		return damage;
	}
}
