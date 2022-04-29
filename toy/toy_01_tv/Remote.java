package toy.toy_01_tv;

public class Remote {
	private TV tv;	// �������� �����ϴ� tv
	
	public Remote() {
		this(null);
	}
	
	public Remote(TV tv) {
		this.tv = tv;
	}

	/**
	 * �������� �޴��� �����ִ� �޼���
	 */
	public static void showMenu()
	{
		System.out.println("�޴��� �����Ͻʽÿ�.");
		System.out.println("1. ���� �ѱ�/����");
		System.out.println("2. ä�ξ� ��ư");
		System.out.println("3. ä�δٿ� ��ư");
		System.out.println("4. ���� TV�� �Ϸ���ȣ Ȯ��");
		System.out.println("5. ����");
	}
	
	/**
	 * �������� ��ư�� ����
	 * @param n ��ư ����
	 */
	public void push(int n)
	{	
		switch(n)
		{
		case 1:
			pushPowerBtn();
			break;
		case 2:
			pushChannelUpBtn();
			break;
		case 3:
			pushChannelDownBtn();
			break;
		case 4:
			pushShowTVSerialNo();
			break;
		case 5:
			pushExit();
			break;
		default:
			failPushBtn();
			break;
		}
	}

	/**
	 * ���� �ѱ�/���� ��ư Ŭ��
	 */
	public void pushPowerBtn() {
		tv.power();
		isOnTV();
	}
	
	/**
	 * ä�ξ� ��ư Ŭ��
	 */
	public void pushChannelUpBtn() {
		if(isOnTV())
		{
			tv.channelUp();
			showCurrentChannel();	
		}
	}
	
	/**
	 * ä�δٿ� ��ư Ŭ��
	 */
	public void pushChannelDownBtn() {
		if(isOnTV())
		{
			tv.channelDown();
			showCurrentChannel();				
		}
	}
	
	/**
	 * TV �Ϸù�ȣ Ȯ�� ��ư Ŭ��
	 */
	public void pushShowTVSerialNo() {
		System.out.println("���� TV�� �Ϸ���ȣ : " + tv.getSerialNo());
	}
	
	/**
	 * ���α׷� ���� ��ư Ŭ��
	 */
	public void pushExit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
	
	/**
	 * �޴��� �߸��� ���ڸ� �Է��� ���
	 */
	public void failPushBtn(){
		System.out.println("���ڸ� �߸� �Է��ϼ̽��ϴ�.");
	}
	
	/**
	 * ���� ä���� �����ִ� �޼���
	 */
	public void showCurrentChannel()
	{
		System.out.printf("���� ä�� : %d\n", tv.getChannel());
	}

	/**
	 * ���� TV�� �����ִ��� Ȯ���ϴ� �޼���
	 * @return true : TV�� ��������, false : TV�� ��������
	 */
	public boolean isOnTV()
	{
		if(tv.isPower())
		{
			System.out.println("���� TV�� �����ֽ��ϴ�.");
			return true;
		}
		else
		{
			System.out.println("���� TV�� �����ֽ��ϴ�.");
			return false;
		}
	}

	public void setTv(TV tv) {
		this.tv = tv;
	}
	
}
