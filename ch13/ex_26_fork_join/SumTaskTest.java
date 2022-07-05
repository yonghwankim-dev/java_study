package ch13.ex_26_fork_join;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SumTaskTest {
	static final ForkJoinPool pool = new ForkJoinPool();     // 쓰레드 풒생성
	@Order(1)
	@Test
	void recursiveTaskTest() {
		long from = 1L, to = 100_000_000L;
		SumTask task = new SumTask(from, to);     // 수행할 작업을 생성
		
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
