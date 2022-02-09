package chap13.chap13_11_callstack_status;

import java.util.concurrent.Executors;

/**
 * @title callstack ���� Ȯ��
 * getAllStackTraces()�� ȣ���ϸ� ���� �� �Ǵ� ������,
 * ��, �۾��� �Ϸ���� ���� ��� �������� ȣ�� ������ ����� �� ����
 * JVM�� ������ �÷���, �̺�Ʈ ó��, �׷���ó���� ���� ���α׷��� ����Ǵµ�
 * �ʿ��� �����۾��� �����ϴ� ���� ��������� �ڵ������� �����ؼ� �����Ŵ
 * �̵��� system ������ �׷� �Ǵ� main ������ �׷쿡 ����
 * 
 *
 */
public class Driver {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("Thread1");
		MyThread2 t2 = new MyThread2("Thread2");
		t1.start();
		t2.start();
	}

}
