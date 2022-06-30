package ch13.ex_02_callstack_start;

/**
 * @title : start(), run() 메서드 차이
 * start() 메서드 호출시 새로운 콜스택(callstack)이
 * 생성되어 새로운 콜스택에 run 쓰레드를 올림,
 * main 쓰레드와 다른 콜스택이므로 main쓰레드와 run
 * 쓰레드가 병렬적으로 수행가능함
 */
public class MyThread extends Thread{

	@Override
	public void run() {
		throwException();
	}
	
	public void throwException() {
		try {
			throw new Exception();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start();
	}
}
