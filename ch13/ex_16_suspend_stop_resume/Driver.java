package ch13.ex_16_suspend_stop_resume;

public class Driver {
	public static void main(String[] args) {
		RunImplEx r1 = new RunImplEx();
		RunImplEx r2 = new RunImplEx();
		RunImplEx r3 = new RunImplEx();
		
		Thread th1 = new Thread(r1, "*");
		Thread th2 = new Thread(r1, "**");
		Thread th3 = new Thread(r1, "***");
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			r1.suspend();
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(3000);
			r1.resume();
			Thread.sleep(3000);
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
			
		}catch (InterruptedException e) {
		}
		
	}
}

class RunImplEx implements Runnable{
	boolean suspended = false;
	boolean stoped    = false;
	
	
	@Override
	public void run() {
		// ¸ØÃá »óÅÂ°¡ ¾Æ´Ñ °æ¿ì
		while(!stoped) {
			// ¸ØÃã »óÅÂ°¡ ¾Æ´Ñ °æ¿ì
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " - stopped");
	}
	
	public void suspend() {
		suspended = true;
	}
	public void resume() {
		suspended = false;
	}
	public void stop() {
		stoped = true;
	}
}
