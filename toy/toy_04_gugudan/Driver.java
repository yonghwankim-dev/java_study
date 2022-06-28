package toy.toy_04_gugudan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * title : 구구단 프로그램
 * content
 * - 단수를 입력받으면 해당 단의 구구단을 출력
 * - 구구단의 시작과 종료를 선택적으로 입력할 수 있음
 * example
 * - 3 2 9 => 3*2=6 ... 3*9=27 출력			
 * @author qkdlf
 *
 */
public class Driver {
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Gugudan gu = new Gugudan();
		String[] str = null;
		int dan, start, end;
		
		while(true)
		{
			System.out.println("몇단인지 입력해주세요 (단 [시작] [종료]), 0 0 0 종료");
			
			try {
				str = br.readLine().split(" ");
				dan = Integer.parseInt(str[0]);
				start = str.length>1 ? Integer.parseInt(str[1]) : 1;
				end = str.length>2 ? Integer.parseInt(str[2]) : 9;
			} catch (NumberFormatException | IOException e) {
				System.out.println("입력이 잘못되었습니다.");
				continue;
			}
			
			if(dan==0 && start==0 && end==0)
			{
				System.exit(0);
			}
			
			gu.printGugudan(dan, start, end);
			
		}
	}
}
