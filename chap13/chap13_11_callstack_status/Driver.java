package chap13.chap13_11_callstack_status;

import java.util.concurrent.Executors;

/**
 * @title callstack 상태 확인
 * getAllStackTraces()를 호출하면 실행 중 또는 대기상태,
 * 즉, 작업이 완료되지 않은 모든 쓰레드의 호출 스택을 출력할 수 있음
 * JVM은 가비지 컬렉션, 이벤트 처리, 그래픽처리와 같이 프로그램이 실행되는데
 * 필요한 보조작업을 수행하는 데몬 쓰레드들을 자동적으로 생성해서 실행시킴
 * 이들은 system 쓰레드 그룹 또는 main 쓰레드 그룹에 속함
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
