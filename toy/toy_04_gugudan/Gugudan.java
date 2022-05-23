package toy.toy_04_gugudan;

public class Gugudan {
	public void printGugudan(int dan)
	{
		printGugudan(dan, 1, 9);
	}
	
	public void printGugudan(int dan, int start)
	{
		printGugudan(dan, start, 9);
	}
	
	public void printGugudan(int dan, int start, int end)
	{
		for(int i=start; i<=end; i++)
		{
			System.out.printf("%d * %d = %d\n",dan,i,dan*i);
		}
	}
}
