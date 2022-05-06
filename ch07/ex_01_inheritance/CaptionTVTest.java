package ch07.ex_01_inheritance;

/**
 * 상속
 * - extends 키워드를 사용하여 부모 클래스인 TV 클래스를 상속받음
 * - 상속받은 자손 클래스(CaptionTV)는 조상 클래스(TV)의 멤버(필드멤버, 메서드)들을
 * 참조 가능함
 */

class TV {
	String color;   // 색상
	boolean power;  // 전원상태(on/off)
	int channel;    // 채널
	
	/**
	 * TV를 키거나 끄는 기능을 하는 메서드
	 */
	public void power()
	{
		this.power = !this.power;
	}
	
	/**
	 * TV의 채널을 높이는 기능을 하는 메서드
	 */
	public void channelUp()
	{
		this.channel++;
	}
	
	/**
	 * TV의 채널을 낮추는 기능을 하는 메서드
	 */
	public void channelDown()
	{
		this.channel--;
	}
}

class CaptionTV extends TV{
	boolean caption;	// 캡션상태(on/off)
	
	public void displayCaption(String text) {
		if(caption) {	// 캡션상태가 on일때만 text를 보여줌
			System.out.println("text");
		}
	}
}



public class CaptionTVTest {
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
