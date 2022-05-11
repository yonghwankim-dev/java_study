package ch07.ex_24_interface;

public class Fighter extends Unit implements Fightable{

	@Override
	public void move(int x, int y) {
		System.out.printf("call move : (%d,%d)\n", x, y);
	}

	@Override
	public void attack(Unit u) {
		System.out.printf("unit is attacking");
	}

}
