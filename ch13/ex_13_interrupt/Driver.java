package ch13.ex_13_interrupt;

import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		t1.interrupt(); // nterrupted()�� ȣ���ϸ�, interrupted ���°� true�� �ȴ�.
		System.out.println("isInterruped() : " + t1.isInterrupted());
	}

}

class MyThread extends Thread{

	@Override
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x = 0; x < 2500000000L; x++);// �ð�����
		}
		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	}	
}