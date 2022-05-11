package ch07.ex_24_interface;

public class FighterTest {

	public static void main(String[] args) {
		Fighter f = new Fighter();
		
		if(f instanceof Unit) {
			System.out.println("f�� Unit Ŭ������ �ڼ��Դϴ�.");
		}
		if(f instanceof Fightable) {
			System.out.println("f�� Fightable �������̽��� �����߽��ϴ�.");
		}
		if(f instanceof Movable) {
			System.out.println("f�� Movable �������̽��� �����߽��ϴ�.");
		}		
		if(f instanceof Attackable) {
			System.out.println("f�� Attackable �������̽��� �����߽��ϴ�.");
		}
		if(f instanceof Object) {
			System.out.println("f�� Object Ŭ������ �ڼ��Դϴ�.");
		}
	}

}
