package chap13.chap13_06_diffresource_singlethread;

import javax.swing.JOptionPane;
/**
 * @title ���� �������� �Է°� ���
 * ���� �ٸ� �ڿ��̶�� ���� �����庸�� ��Ƽ �����尡 ȿ����
 *
 */
public class Driver {
	
	public static void main(String args[])
	{
		String input = JOptionPane.showInputDialog("�ƹ����̳� �Է��Ͻÿ�.");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		
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
