package ch07.ex_01_inheritance;

/**
 * ��� ����
 * - extends Ű���带 ����Ͽ� �θ� Ŭ������ TV Ŭ������ ��ӹ���
 * - TV�� ����� �޼��带 ����� �� ����
 */
public class CaptionTV extends TV{
	boolean caption;	// ĸ�ǻ���(on/off)
	
	public void displayCaption(String text) {
		if(caption) {	// ĸ�ǻ��°� on�϶��� text�� ������
			System.out.println("text");
		}
	}
}
