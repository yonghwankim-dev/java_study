package ch06.ex_03_instance3;

public class TV {
	// TV�� �Ӽ�
	String color;   // ����
	boolean power;  // ��������(on/off)
	int channel;    // ä��
	
	//TV�� ���
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
}
