package ch13.ex_08_priority;

public class MyThread implements Runnable{
	private String s;
	
	public MyThread(String s) {
		this.s = s;
	}

	@Override
	public void run() {
		for(int i=0;i<300;i++)
		{
			System.out.print(s);
			for(int x=0;x<1000;x++);
		}
	}
	
}
