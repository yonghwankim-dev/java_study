package ch13.ex_04_singlethread;

/**
 * @title 싱글쓰레드 작업시간
 */
public class Driver {
	public static void main(String args[])
	{
		long startTime = System.currentTimeMillis();
		
		for(int i=0;i<300;i++)
		{
			System.out.printf("%s", new String("-"));
		}
		System.out.println();
		// Expected Output : 72ms
		System.out.print("소요시간1:"+(System.currentTimeMillis()-startTime)+"\n");
		
		for(int i=0;i<300;i++)
		{
			System.out.printf("%s", new String("|"));
		}
		System.out.println();
		// Expected Output : 96ms
		System.out.print("소요시간2:"+(System.currentTimeMillis()-startTime)+"\n");
	}
}
