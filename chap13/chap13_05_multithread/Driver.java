package chap13.chap13_05_multithread;

/**
 * @title ��Ƽ������ �۾��ð�
 * context switching���� ���ؼ� �ܼ� CPU���� ����ϴ�
 * ����۾��̶�� ��Ƽ�����庸�� �̱۾����尡 �� ���� ��찡 ����
 */
public class Driver {
	static long startTime = 0;
	
	public static void main(String args[])
	{
		MyThread t1 = new MyThread();
		t1.start();	// Expected Output : �ҿ�ð�2:77ms
		startTime = System.currentTimeMillis();

		for(int i=0;i<300;i++)
		{
			System.out.printf("%s", new String("-"));
		}
		System.out.println();
		// Expected Output : 125ms
		System.out.print("�ҿ�ð�1:"+(System.currentTimeMillis()-Driver.startTime)+"\n");
		
		
	}
}
