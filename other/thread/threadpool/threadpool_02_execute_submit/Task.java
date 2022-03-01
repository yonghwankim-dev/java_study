package other.thread.threadpool.threadpool_02_execute_submit;

public class Task implements Runnable{

	@Override
	public void run() {
		System.out.println("call " + Thread.currentThread().getName());
	}

}
