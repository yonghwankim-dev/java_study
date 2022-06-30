package ch13.ex_14_interrupt;

import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		System.out.println("입력하신 값은 " + input + "입니다.");
		t1.interrupt(); // nterrupted()를 호출하면, interrupted 상태가 true가 된다.
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
				Thread.sleep(1000); // sleep 중 intterup()를 호출하면 InterruptedException 발생되고
									// 쓰레드의 interrupted 상태는 false로 자동 초기화됨
			} catch (InterruptedException e) {
				interrupt(); // interrupt()를 추가로 호출하여 interrupted의 상태를 true로 다시 바꾸어줌
			}
		}
		System.out.println("카운트가 종료되엇습니다.");
	}	
}