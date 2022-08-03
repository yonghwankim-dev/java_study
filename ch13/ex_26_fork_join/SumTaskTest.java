package ch13.ex_26_fork_join;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class SumTaskTest {
	static final ForkJoinPool pool = new ForkJoinPool();     // ������ ������
	@Test
	void recursiveTaskTest() {
		long from = 1L, to = 100_000_000L;
		SumTask task = new SumTask(from, to);     // ������ �۾��� ����
		
		long start = System.currentTimeMillis();
		Long result = pool.invoke(task);
		long end = System.currentTimeMillis();
		System.out.println("Elapsed time(4Core) : " + (end - start));
		System.out.printf("sum of %d~%d=%d\n", from, to, result);
		System.out.println();

		result = 0L;
		start = System.currentTimeMillis();
		for(long i = from; i <= to; i++) {
			result += i;
		}
		end = System.currentTimeMillis();
		
		System.out.println("Elapsed time(1Core) : " + (end - start));
		System.out.printf("sum of %d~%d=%d\n", from, to, result);
	}
}
