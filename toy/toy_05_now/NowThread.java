package toy.toy_05_now;

public class NowThread implements Runnable{

	Now now;
	
	public NowThread(Now now)
	{
		this.now = now;
	}
	
	public NowThread() {
		this(null);
	}
	
	@Override
	public void run() {
		while(true)
		{
			try {
				System.out.println(now.getNow());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
