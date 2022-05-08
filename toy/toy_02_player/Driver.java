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
		System.out.println("1. 재생");
		System.out.println("2. 특정 위치에서 재생");
		System.out.println("3. 재생/정지");
		System.out.println("4. 종료");
	}

	public static int input(int start, int end){
		br = new BufferedReader(new InputStreamReader(System.in));
		int menu = 0;
		
		while(true)
		{
			System.out.printf("입력 (%d ~ %d) : ", start, end);
			try {
				menu = Integer.parseInt(br.readLine());
				
				if(menu < start || menu > end) {
					System.out.printf("메뉴 범위에 있는 숫자를 입력해주세요 (%d ~ %d)\n"
							        , start, end);
					continue;
				}
				
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			} catch (IOException e) {
				System.out.println("IOException 발생");
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
			System.out.println("플레이어를 종료합니다.");
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
