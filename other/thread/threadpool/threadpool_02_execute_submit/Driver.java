package other.thread.threadpool.threadpool_02_execute_submit;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * title : execute()와 submit() 메서드의 차이
 * 대표적인 차이는 execute 메서드는 Future 객체를 반환하지 못하여 제어가 되지 않음
 */
public class Driver {
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		ExecutorService pool = Executors.newFixedThreadPool(5);
		Future<?> f = pool.submit(new Task());
		pool.execute(new Task());
		
		
		f.get();	// 테스크가 완료될때까지 대기
		//f.cancel(false);	// 비동기 테스크 취소
		f.isDone();	// 테스크가 완료되었는지 검사
		f.isCancelled();	// 테스크가 취소되었는지 검사
		
		pool.shutdown();
	}
}
