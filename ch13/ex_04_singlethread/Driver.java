package ch13.ex_04_singlethread;

/**
 * @title �̱۾����� �۾��ð�
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
		System.out.print("�ҿ�ð�1:"+(System.currentTimeMillis()-startTime)+"\n");
		
		for(int i=0;i<300;i++)
		{
			System.out.printf("%s", new String("|"));
		}
		System.out.println();
		// Expected Output : 96ms
		System.out.print("�ҿ�ð�2:"+(System.currentTimeMillis()-startTime)+"\n");
	}
}
