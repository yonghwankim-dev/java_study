package ch13.ex_10_daemon;

/**
 * @title ���� ������
 * ���󾲷���� �ٸ� �Ϲ� ������ �۾��� ���� ���� ������
 * �Ϲݾ����尡 ��� ����Ǹ� ���� ��������� ���������� �����
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
