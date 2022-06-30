package ch13.ex_14_interrupt;

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
			try {
				Thread.sleep(1000); // sleep �� intterup()�� ȣ���ϸ� InterruptedException �߻��ǰ�
									// �������� interrupted ���´� false�� �ڵ� �ʱ�ȭ��
			} catch (InterruptedException e) {
				interrupt(); // interrupt()�� �߰��� ȣ���Ͽ� interrupted�� ���¸� true�� �ٽ� �ٲپ���
			}
		}
		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	}	
}