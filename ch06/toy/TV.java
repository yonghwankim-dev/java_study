package ch06.toy;

public class TV {
	private boolean power;  // ��������(on/off)
	private int channel;    // ä��

	private static final int  WIDTH = 100;	// tv�� �ʺ�
	private static final int HEIGHT = 200;	// tv�� ����
	
	public TV() {
		this.power = false;
		this.channel = 0;
	}
	
	public TV(boolean power, int channel) {
		this.power = power;
		this.channel = channel;
	}

	/**
	 * TV�� Ű�ų� ���� ����� �ϴ� �޼���
	 */
	public void power()
	{
		this.power = !this.power;
	}
	
	/**
	 * TV�� ä���� ���̴� ����� �ϴ� �޼���
	 */
	public void channelUp()
	{
		this.channel++;
	}
	
	/**
	 * TV�� ä���� ���ߴ� ����� �ϴ� �޼���
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
