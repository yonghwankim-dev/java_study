package ch13.ex_08_priority;

/**
 * @title 쓰레드의 우선순위
 * 우선순위 범위 1~10
 * 우선순위 값이 높을수록 우선순위가 높음
 * setPriority(int newPriority)	쓰레드 우선순위 설정
 * getPriority()				쓰레드 우선순위 반환
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
