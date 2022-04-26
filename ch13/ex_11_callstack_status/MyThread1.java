package ch13.ex_11_callstack_status;

public class MyThread1 extends Thread{

	public MyThread1(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		try {
			sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
