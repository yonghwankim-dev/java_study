package toy.toy_03_slaythespire.card;

import toy.toy_03_slaythespire.unit.Unit;

public abstract class Card {
	private String name;	// ī�� �̸�
	private int cost;		// ī�� ��� ���
	private KIND kind;
	
	public enum KIND {ATTACK, DEFEND, POWER};	// ī�� ����
	
	// Unit�� ������� ī�带 ���
	abstract public void use(Unit target);
	
	// ������
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
