package ch13.ex_02_callstack_start;

/**
 * @title : start(), run() �޼��� ����
 * start() �޼��� ȣ��� ���ο� �ݽ���(callstack)��
 * �����Ǿ� ���ο� �ݽ��ÿ� run �����带 �ø�,
 * main ������� �ٸ� �ݽ����̹Ƿ� main������� run
 * �����尡 ���������� ���డ����
 */
public class Driver {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start();
	}

}
