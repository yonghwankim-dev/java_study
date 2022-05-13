package toy.toy_03_slaythespire.unit;

public abstract class Unit {
	public String name;
	public int hitPoint;
	public final int MAX_HP;	// �ִ� ü��
	
	public Unit(String name, int max_hp) {
		this.name = name;
		this.MAX_HP = max_hp;
	}

	@Override
	public String toString() {
		return String.format("%s(%d/%d)", name, hitPoint, MAX_HP);
	}	
}
