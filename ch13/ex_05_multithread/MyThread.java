package ch13.ex_05_multithread;

public class MyThread extends Thread{

	@Override
	public void run() {
		for(int i=0;i<300;i++)
		{
			System.out.printf("%s", new String("|"));
		}
		System.out.println();
		// Expected Output : 96ms
		System.out.print("소요시간2:"+(System.currentTimeMillis()-Driver.startTime)+"\n");
	}

}
