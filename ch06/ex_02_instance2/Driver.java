package ch06.ex_02_instance2;

/**
 * ���� Ŭ���� Ÿ���� ��ü������
 * tv1�� tv2 ���������� ���� �ٸ� ��ü�� ����Ű��
 * ������ channel ���� ���� �ٸ� ���� �����ϴ�.
 *
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

	}

}
