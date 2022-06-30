package ch13.ex_20_join;

public class Driver {

	public static void main(String[] args) {
		MyThread gc = new MyThread();
		gc.setDaemon(true);
		gc.start();
		
		int requiredMemory = 0;
		
		for(int i = 0; i < 20; i++) {
			requiredMemory = (int) (Math.random() * 10) * 20;
			
			// �ʿ��� �޸𸮰� ����� �� �ִ� �纸�� ũ�ų� ��ü �޸��� 60% �̻���
			// ������� ��� gc�� �����.
			if(gc.freeMemory() < requiredMemory ||
			   gc.freeMemory() < gc.totalMemory() * 0.4) {
				gc.interrupt();
				
				try {
					gc.join(100);
				} catch (InterruptedException e) {
				}
			}
			
			gc.usedMemory += requiredMemory;
			System.out.println("usedMemory : " + gc.usedMemory);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}

class MyThread extends Thread{
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10 * 1000); // 10�� ���
			} catch (InterruptedException e) {
				System.out.println("Awaken  by interrupt().");
			} 
			
			gc();
			System.out.println("Garbage Collected. Free Memory : " + freeMemory());
			
		}
	}
	
	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) {
			usedMemory = 0;
		}
	}
	
	public int totalMemory(){ // �ִ� �޸� ũ��
		return MAX_MEMORY;
	}
	public int freeMemory() { // ��밡���� �޸� ��ȯ
		return MAX_MEMORY - usedMemory;
	}
	
	
}
