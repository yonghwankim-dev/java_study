package chap13.chap13_01_howtoImple;

import java.util.stream.IntStream;

public class MyThread1 extends Thread{

	@Override
	public void run() {
		IntStream.range(0, 5).forEach(i->{
			System.out.println(getName());	// ������ Thread�� getName() ȣ��
		});
	}

	
}
