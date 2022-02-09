package chap13.chap13_05_multithread;

/**
 * @title 멀티쓰레드 작업시간
 * context switching으로 인해서 단순 CPU만을 사용하는
 * 계산작업이라면 멀티쓰레드보다 싱글쓰레드가 더 좋은 경우가 있음
 */
public class Driver {
	static long startTime = 0;
	
	public static void main(String args[])
	{
		MyThread t1 = new MyThread();
		t1.start();	// Expected Output : 소요시간2:77ms
		startTime = System.currentTimeMillis();

		for(int i=0;i<300;i++)
		{
			System.out.printf("%s", new String("-"));
		}
		System.out.println();
		// Expected Output : 125ms
		System.out.print("소요시간1:"+(System.currentTimeMillis()-Driver.startTime)+"\n");
		
		
	}
}
