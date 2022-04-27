package ch06.toy;

public class Remote {
	private TV tv;	// �������� �����ϴ� tv
	
	public Remote() {
		
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
		System.out.println("4. ����");
	}
	
	/**
	 * �������� ��ư�� ����
	 * @param n ��ư ����
	 */
	public void push(int n)
	{
		if(n == 1)
		{
			tv.power();
			isOnTV();
		}
		else if(n == 2)
		{
			if(isOnTV())
			{
				tv.channelUp();
				showCurrentChannel();	
			}
		}
		else if(n == 3)
		{
			if(isOnTV())
			{
				tv.channelDown();
				showCurrentChannel();				
			}	
		}
		else if(n == 4)
		{
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		}
		else
		{
			System.out.println("���ڸ� �߸� �Է��ϼ̽��ϴ�. (1~4)");
		}
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
