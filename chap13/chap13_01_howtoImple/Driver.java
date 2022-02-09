package chap13.chap13_01_howtoImple;

/**
 * @title 쓰레드를 구현하는 2가지 방법
 * 1. Thread 클래스를 상속
 * 2. Runnable 인터페이스를 구현
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
