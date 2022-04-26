package ch13.ex_10_daemon;

public class MyThread implements Runnable{
	static boolean autoSave = false;
	
	
	@Override
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(autoSave)
			{
				autoSave();
			}
			
		}		
	}
	
	public void autoSave()
	{
		System.out.println("�۾������� �ڵ�����Ǿ����ϴ�.");
	}

}
