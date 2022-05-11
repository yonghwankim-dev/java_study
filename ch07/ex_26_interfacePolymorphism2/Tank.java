package ch07.ex_26_interfacePolymorphism2;

public class Tank extends GroundUnit implements Repairable{

	Tank() {
		super(150);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "Tank";
	}
}
