package ch06.ex_05_variable;

public class Card {
	String kind;	// ī���� ����, [��Ʈ,���̾�,�����̵�,Ŭ�ι�]
	int number;		// ī���� ����
	
	static int width = 100;		// ī���� �ʺ�
	static int height = 250;	// ī���� ����
	
	@Override
	public String toString() {
		return "Card [kind=" + kind + ", number=" + number + "]";
	}
}
