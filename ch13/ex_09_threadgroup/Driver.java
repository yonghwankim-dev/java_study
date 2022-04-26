package ch13.ex_09_threadgroup;


public class Driver {

	public static void main(String[] args) {
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup group1 = new ThreadGroup("Group1");
		ThreadGroup group2 = new ThreadGroup("Group2");
		
		ThreadGroup subGroup1 = new ThreadGroup(group1, "SubGroup1");
		
		group1.setMaxPriority(3);	// �ִ�켱���� ������ ���Ŀ� �׷쿡 �߰��Ǵ� ��������� ������ ����
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(group1, r, "th1").start();
		new Thread(subGroup1, r, "th2").start();
		new Thread(group2, r, "th3").start();
		
		System.out.println(">>List of ThreadGroup : " + main.getName() +			// main
							", Active ThreadGroup: " + main.activeGroupCount()+		// 3(main, group1, group2)
							", Active Thread: " + main.activeCount());				// 4(main, th1, th2, th3)
		main.list();
		
		
	}

}
