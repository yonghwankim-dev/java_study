package other.thread.threadpool.threadpool_02_execute_submit;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * title : execute()�� submit() �޼����� ����
 * ��ǥ���� ���̴� execute �޼���� Future ��ü�� ��ȯ���� ���Ͽ� ��� ���� ����
 */
public class Driver {
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		ExecutorService pool = Executors.newFixedThreadPool(5);
		Future<?> f = pool.submit(new Task());
		pool.execute(new Task());
		
		
		f.get();	// �׽�ũ�� �Ϸ�ɶ����� ���
		//f.cancel(false);	// �񵿱� �׽�ũ ���
		f.isDone();	// �׽�ũ�� �Ϸ�Ǿ����� �˻�
		f.isCancelled();	// �׽�ũ�� ��ҵǾ����� �˻�
		
		pool.shutdown();
	}
}
