package chap13.chap13_01_howtoImple;

import java.util.stream.IntStream;

public class MyThread2 implements Runnable{

	@Override
	public void run() {
		IntStream.range(0, 5).forEach(i->{
			// Thread.currentThread() - ���� �������� Thread ��ȯ
			System.out.println(Thread.currentThread().getName());
		});
	}

}
