package ch07.ex_01_inheritance;

/**
 * ���
 * - extends Ű���带 ����Ͽ� �θ� Ŭ������ TV Ŭ������ ��ӹ���
 * - ��ӹ��� �ڼ� Ŭ����(CaptionTV)�� ���� Ŭ����(TV)�� ���(�ʵ���, �޼���)����
 * ���� ������
 */

class TV {
	String color;   // ����
	boolean power;  // ��������(on/off)
	int channel;    // ä��
	
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

class CaptionTV extends TV{
	boolean caption;	// ĸ�ǻ���(on/off)
	
	public void displayCaption(String text) {
		if(caption) {	// ĸ�ǻ��°� on�϶��� text�� ������
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
