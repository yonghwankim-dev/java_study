package toy.toy_03_slaythespire.card;

import toy.toy_03_slaythespire.unit.Unit;

public abstract class Card {
	private String name;	// 카드 이름
	private int cost;		// 카드 사용 비용
	private KIND kind;
	
	public enum KIND {ATTACK, DEFEND, POWER};	// 카드 종류
	
	// Unit을 대상으로 카드를 사용
	abstract public void use(Unit target);
	
	// 생성자
	public Card(String name, int cost, KIND kind) {
		this.name = name;
		this.cost = cost;
		this.kind = kind;
	}	
	
	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return String.format("%s(%d, %s)", name, cost, kind);
	}
}
