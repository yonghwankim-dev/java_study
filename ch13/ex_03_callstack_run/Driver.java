package ch13.ex_03_callstack_run;

/**
 * @title : start(), run() 메서드 차이
 * run() 메서드 호출시 새로운 콜스택(callstack)이
 * 새로 생성되지 않기 때문에 main 쓰레드 위에 run 쓰레드가
 * 올라감, 따라서 병렬적으로 수행되지 않고 run() 쓰레드가
 * 종료된 다음 main 쓰레드가 수행됨
 */
public class Driver {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.run();
	}

}
