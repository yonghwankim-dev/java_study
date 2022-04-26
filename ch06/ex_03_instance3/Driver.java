package ch06.ex_03_instance3;

/**
 * tv2 = tv1
 * tv1�� ����Ű�� �ִ� �ּҸ� tv2�� ����Ű�� ��
 * 
 * ���� tv2�� ����Ű�� �ִ� ��ü�� ������ �÷��Ϳ� ���� ���ŵ�
 */
public class Driver {

	public static void main(String[] args) {
		TV tv1 = new TV();
		TV tv2 = new TV();
		
		System.out.println("tv1�� ���� ä�� : " + tv1.channel);
		System.out.println("tv2�� ���� ä�� : " + tv2.channel);
		
		tv1.channel = 5;
		tv2.channel = 7; 
		
		System.out.println("tv1�� ���� ä�� : " + tv1.channel);
		System.out.println("tv2�� ���� ä�� : " + tv2.channel);
		
		tv2 = tv1;	// tv2�� tv1�� ����Ű�� �ִ� ��ü�� ����Ŵ

		System.out.println("tv1�� ���� ä�� : " + tv1.channel);
		System.out.println("tv2�� ���� ä�� : " + tv2.channel);
	}

}
