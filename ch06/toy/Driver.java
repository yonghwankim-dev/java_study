package ch06.toy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TV tv = new TV();
		Remote remote = new Remote(tv);
		int n;	// 메뉴 번호
		
		while(true)
		{	
			remote.showMenu();
			try {
				n = Integer.parseInt(br.readLine());
				remote.push(n);
			} catch (NumberFormatException e) {
				System.out.println("메뉴에 존재하는 숫자를 입력해주세요.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
