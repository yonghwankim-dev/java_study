package chap13.chap13_03_callstack_run;

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
