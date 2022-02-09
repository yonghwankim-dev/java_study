package chap13.chap13_01_howtoImple;

import java.util.stream.IntStream;

public class MyThread1 extends Thread{

	@Override
	public void run() {
		IntStream.range(0, 5).forEach(i->{
			System.out.println(getName());	// 조상인 Thread의 getName() 호출
		});
	}

	
}
