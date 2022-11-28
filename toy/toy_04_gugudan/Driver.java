package toy.toy_04_gugudan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Driver {
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Gugudan gu = new Gugudan();
		String[] str = null;
		int dan, start, end;
		
		while(true)
		{
			System.out.println("������� �Է����ּ��� (�� [����] [����]), 0 0 0 ����");
			
			try {
				str = br.readLine().split(" ");
				dan = Integer.parseInt(str[0]);
				start = str.length>1 ? Integer.parseInt(str[1]) : 1;
				end = str.length>2 ? Integer.parseInt(str[2]) : 9;
			} catch (NumberFormatException | IOException e) {
				System.out.println("�Է��� �߸��Ǿ����ϴ�.");
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
