package ch13.ex_10_daemon;

/**
 * @title 데몬 쓰레드
 * 데몬쓰레드는 다른 일반 쓰레의 작업을 도는 보조 쓰레드
 * 일반쓰레드가 모두 종료되면 데몬 쓰레드느는 강제적으로 종료됨
 *
 */
public class Driver {

	public static void main(String[] args) {
		Thread t = new Thread(new MyThread());
		t.setDaemon(true);
		t.start();
		
		for(int i=1;i<=10;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
			if(i==5)
			{
				MyThread.autoSave = true;
			}
		}
	}

}
