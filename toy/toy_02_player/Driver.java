package toy.toy_02_player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.w3c.dom.ranges.RangeException;

public class Driver {

	static BufferedReader br;
	static final int MENU_START = 1;
	static final int MENU_END = 4;
	
	public static void showMenu() {
		System.out.println("1. ���");
		System.out.println("2. Ư�� ��ġ���� ���");
		System.out.println("3. ���/����");
		System.out.println("4. ����");
	}

	public static int input(int start, int end){
		br = new BufferedReader(new InputStreamReader(System.in));
		int menu = 0;
		
		while(true)
		{
			System.out.printf("�Է� (%d ~ %d) : ", start, end);
			try {
				menu = Integer.parseInt(br.readLine());
				
				if(menu < start || menu > end) {
					System.out.printf("�޴� ������ �ִ� ���ڸ� �Է����ּ��� (%d ~ %d)\n"
							        , start, end);
					continue;
				}
				
				break;
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է����ּ���.");
			} catch (IOException e) {
				System.out.println("IOException �߻�");
			}
		}
		
		return menu;
	}
		
	public static void process(Player p, int menu) {
		if(menu == 1){
			p.play();
		}
		else if(menu == 2) {
			int pos = input(1, 100);
			p.play(pos);
		}
		else if(menu == 3) {
			p.pause();
		}
		else {
			System.out.println("�÷��̾ �����մϴ�.");
			System.exit(0);
		}	
	}
	
	public static void main(String[] args) {
		Player p = new CDPlayer();
		int menu = 0;
		while(true) {
			showMenu();
			menu = input(MENU_START, MENU_END);
			process(p, menu);
		}

	}

}
