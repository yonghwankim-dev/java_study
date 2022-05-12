package toy.toy_03_slaythespire.unit;

import toy.toy_03_slaythespire.strategy.Attackable;

public class Monster extends Unit implements Attackable{
	int damage;
	
	public Monster(String name, int max_hp, int damage) {
		super(name, max_hp);
		this.damage = damage;
		hitPoint = max_hp;
	}
	
	@Override
	public void attack(Unit target) {
		target.hitPoint -= damage;
	}
}
