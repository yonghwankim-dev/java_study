package ch13.ex_07_diffresource_multithread;

public class MyThread extends Thread{

	@Override
	public void run() {
		for(int i=10; i>0; i--)
		{
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
