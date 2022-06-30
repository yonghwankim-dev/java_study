package ch13.ex_19_join;

public class Driver {	
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread("-"));
		Thread t2 = new Thread(new MyThread("*"));
		
		t1.start();
		t2.start();
		
		try {
			t1.join();	// main쓰레드가 t1의 작업이 끝날대가지 대기
			t2.join();  // main쓰레드가 t2의 작업이 끝날대가지 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("main 종료");
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