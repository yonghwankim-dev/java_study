package ch07.ex_04_singleInheritance;

public class TV {
	// TV의 속성
	String color;   // 색상
	boolean power;  // 전원상태(on/off)
	int channel;    // 채널
	
	//TV의 기능
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
