package chap13.chap13_06_diffresource_singlethread;

import javax.swing.JOptionPane;
/**
 * @title 단일 쓰레드의 입력과 출력
 * 서로 다른 자원이라면 단일 쓰레드보다 멀티 쓰레드가 효과적
 *
 */
public class Driver {
	
	public static void main(String args[])
	{
		String input = JOptionPane.showInputDialog("아무값이나 입력하시오.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		
		for(int i=10; i>0; i--)
		{
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
