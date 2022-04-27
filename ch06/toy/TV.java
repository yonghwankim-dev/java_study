package ch06.toy;

public class TV {
	private boolean power;  // 전원상태(on/off)
	private int channel;    // 채널

	private static final int  WIDTH = 100;	// tv의 너비
	private static final int HEIGHT = 200;	// tv의 높이
	
	public TV() {
		this.power = false;
		this.channel = 0;
	}
	
	public TV(boolean power, int channel) {
		this.power = power;
		this.channel = channel;
	}

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

	public boolean isPower() {
		return power;
	}

	public int getChannel() {
		return channel;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}
	
	
}
