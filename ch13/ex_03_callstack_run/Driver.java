package ch13.ex_03_callstack_run;

/**
 * @title : start(), run() �޼��� ����
 * run() �޼��� ȣ��� ���ο� �ݽ���(callstack)��
 * ���� �������� �ʱ� ������ main ������ ���� run �����尡
 * �ö�, ���� ���������� ������� �ʰ� run() �����尡
 * ����� ���� main �����尡 �����
 */
public class Driver {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.run();
	}

}
