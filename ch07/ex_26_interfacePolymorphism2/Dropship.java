package ch07.ex_26_interfacePolymorphism2;

public class Dropship extends AirUnit implements Repairable{

	Dropship() {
		super(125);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "Dropship";
	}
}
