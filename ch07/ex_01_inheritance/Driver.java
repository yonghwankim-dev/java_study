package ch07.ex_01_inheritance;

public class Driver {
	public static void main(String[] args)
	{
		CaptionTV ct = new CaptionTV();
		
		ct.channel = 10;
		ct.channelUp();
		
		System.out.printf("%d\n", ct.channel);
		
		ct.displayCaption("Hello, World!");
		ct.caption = true;
		ct.displayCaption("Hello, World!");
	}
}
