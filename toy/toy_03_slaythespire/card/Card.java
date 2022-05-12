package toy.toy_03_slaythespire.card;

import toy.toy_03_slaythespire.unit.Unit;

public abstract class Card {
	String name;
	String kind;	// ī���� ���� : ����/��ų/�Ŀ�
	int cost;		// ī�� ��� ���

	public Card(String name, String kind, int cost) {
		this.name = name;
		this.kind = kind;
		this.cost = cost;
	}

	abstract public void use(Unit target);

	
	
	public String getName() {
		return name;
	}

	public String getKind() {
		return kind;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return "cost : " + cost + " name : " + name + " kind : " + kind;
	}
}
