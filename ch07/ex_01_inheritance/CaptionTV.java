package ch07.ex_01_inheritance;

/**
 * 상속 예제
 * - extends 키워드를 사용하여 부모 클래스인 TV 클래스를 상속받음
 * - TV의 멤버와 메서드를 사용할 수 있음
 */
public class CaptionTV extends TV{
	boolean caption;	// 캡션상태(on/off)
	
	public void displayCaption(String text) {
		if(caption) {	// 캡션상태가 on일때만 text를 보여줌
			System.out.println("text");
		}
	}
}
