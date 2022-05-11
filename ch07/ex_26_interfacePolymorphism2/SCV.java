package ch07.ex_26_interfacePolymorphism2;

public class SCV extends GroundUnit implements Repairable{

	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}

	void repair(Repairable r) {
		if(r instanceof Unit) {
			Unit u = (Unit) r;
			while(u.hitPoint != u.MAX_HP) {
				// Unit의 HP를 증가시킨다
				u.hitPoint++;
			}
			System.out.printf("%s의 수리가 끝났습니다.\n", u);
		}
		
	}
	
	@Override
	public String toString() {
		return "SCV";
	}
}
