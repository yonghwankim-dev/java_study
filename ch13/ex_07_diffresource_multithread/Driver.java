package ch13.ex_07_diffresource_multithread;

import javax.swing.JOptionPane;
/**
 * @title 단일 쓰레드의 입력과 출력
 * 서로 다른 자원이라면 단일 쓰레드보다 멀티 쓰레드가 효과적
 *
 */
public class Driver {
	
	public static void main(String args[])
	{
		MyThread t1 = new MyThread();
		t1.start();
		
		String input = JOptionPane.showInputDialog("아무값이나 입력하시오.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		
		
	}
}
