package ch13.ex_07_diffresource_multithread;

import javax.swing.JOptionPane;
/**
 * @title ���� �������� �Է°� ���
 * ���� �ٸ� �ڿ��̶�� ���� �����庸�� ��Ƽ �����尡 ȿ����
 *
 */
public class Driver {
	
	public static void main(String args[])
	{
		MyThread t1 = new MyThread();
		t1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ����̳� �Է��Ͻÿ�.");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		
		
	}
}
