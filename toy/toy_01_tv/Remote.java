package toy.toy_01_tv;

public class Remote {
	private TV tv;	// 리모콘이 제어하는 tv
	
	public Remote() {
		this(null);
	}
	
	public Remote(TV tv) {
		this.tv = tv;
	}

	/**
	 * 리모컨의 메뉴를 보여주는 메서드
	 */
	public static void showMenu()
	{
		System.out.println("메뉴를 선택하십시오.");
		System.out.println("1. 전원 켜기/끄기");
		System.out.println("2. 채널업 버튼");
		System.out.println("3. 채널다운 버튼");
		System.out.println("4. 현재 TV의 일려번호 확인");
		System.out.println("5. 종료");
	}
	
	/**
	 * 리모컨의 버튼을 누름
	 * @param n 버튼 숫자
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
	 * 전원 켜기/끄기 버튼 클릭
	 */
	public void pushPowerBtn() {
		tv.power();
		isOnTV();
	}
	
	/**
	 * 채널업 버튼 클릭
	 */
	public void pushChannelUpBtn() {
		if(isOnTV())
		{
			tv.channelUp();
			showCurrentChannel();	
		}
	}
	
	/**
	 * 채널다운 버튼 클릭
	 */
	public void pushChannelDownBtn() {
		if(isOnTV())
		{
			tv.channelDown();
			showCurrentChannel();				
		}
	}
	
	/**
	 * TV 일련번호 확인 버튼 클릭
	 */
	public void pushShowTVSerialNo() {
		System.out.println("현재 TV의 일려번호 : " + tv.getSerialNo());
	}
	
	/**
	 * 프로그램 종료 버튼 클릭
	 */
	public void pushExit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
	
	/**
	 * 메뉴의 잘못된 숫자를 입력한 경우
	 */
	public void failPushBtn(){
		System.out.println("숫자를 잘못 입력하셨습니다.");
	}
	
	/**
	 * 현재 채널을 보여주는 메서드
	 */
	public void showCurrentChannel()
	{
		System.out.printf("현재 채널 : %d\n", tv.getChannel());
	}

	/**
	 * 현재 TV가 켜져있는지 확인하는 메서드
	 * @return true : TV가 켜져있음, false : TV가 꺼져있음
	 */
	public boolean isOnTV()
	{
		if(tv.isPower())
		{
			System.out.println("현재 TV가 켜져있습니다.");
			return true;
		}
		else
		{
			System.out.println("현재 TV가 꺼져있습니다.");
			return false;
		}
	}

	public void setTv(TV tv) {
		this.tv = tv;
	}
	
}
