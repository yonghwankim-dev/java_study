package ch13.ex_12_sleep;

public class Driver {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread("-", "t1"));
		Thread t2 = new Thread(new MyThread("*", "t2"));
		
		t1.start();
		t2.start();
		
		try {
			t1.sleep(2000); // 현재 실행중인 쓰레드인 main 쓰레드를 2초 멈춤
		} catch (InterruptedException e) {
		}
		System.out.println("main 스레드 종료");

	}

}

class MyThread implements Runnable{
	String name;
	String s;

	public MyThread(String s, String name) {
		this.s = s;
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print(s);
		}
		
		System.out.print(name + "종료");
	}
	
	
	
	
}