package ch13.ex_08_priority;

/**
 * @title �������� �켱����
 * �켱���� ���� 1~10
 * �켱���� ���� �������� �켱������ ����
 * setPriority(int newPriority)	������ �켱���� ����
 * getPriority()				������ �켱���� ��ȯ
 *
 */
public class Driver {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread("-"));
		Thread t2 = new Thread(new MyThread("*"));
		
		t2.setPriority(7);
		
		System.out.println("Priority of t1 (-) : " + t1.getPriority());
		System.out.println("Priority of t2 (*) : " + t2.getPriority());
		
		t1.start();
		t2.start();
	}

}
