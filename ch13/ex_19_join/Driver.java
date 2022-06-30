package ch13.ex_19_join;

public class Driver {	
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread("-"));
		Thread t2 = new Thread(new MyThread("*"));
		
		t1.start();
		t2.start();
		
		try {
			t1.join();	// main�����尡 t1�� �۾��� �����밡�� ���
			t2.join();  // main�����尡 t2�� �۾��� �����밡�� ���
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("main ����");
	}
}


class MyThread implements Runnable{

	private String s;

	public MyThread(String s) {
		this.s = s;
	}

	@Override
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print(new String("-"));
		}
		System.out.println();
	}
	
}