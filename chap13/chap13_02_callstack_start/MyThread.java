package chap13.chap13_02_callstack_start;

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
	
}
