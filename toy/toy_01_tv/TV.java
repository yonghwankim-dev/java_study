package toy.toy_01_tv;

public class TV {
	private int serialNo;	// �Ϸù�ȣ
	private boolean power;  // ��������(on/off)
	private int channel;    // ä��

	private static int count = 0;	// TV ��ü�� ������ ����
	private static final int  WIDTH = 100;	// tv�� �ʺ�
	private static final int HEIGHT = 200;	// tv�� ����

	// �ν��Ͻ� �ʱ�ȭ ��
	{
		count++;
		serialNo = count;
	}
	
	public TV() {
		this(false, 0);
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

	public int getSerialNo() {
		return serialNo;
	}
	
	public boolean isPower() {
		return power;
	}

	public int getChannel() {
		return channel;
	}

	public static int getCount() {
		return count;
	}
	
	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}





	
	
}
