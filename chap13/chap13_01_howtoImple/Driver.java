package chap13.chap13_01_howtoImple;

/**
 * @title �����带 �����ϴ� 2���� ���
 * 1. Thread Ŭ������ ���
 * 2. Runnable �������̽��� ����
 *
 */
public class Driver {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		
		Runnable r = new MyThread2();
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}

}
