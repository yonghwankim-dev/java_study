package ch13.ex_26_fork_join;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long>{
	long from, to;

	public SumTask(long from, long to) {
		this.from = from;
		this.to = to;
	}
	
	// 숫자의 합을 반환. sum()은 from부터 to까지의 수를 더해서 반환	
	public Long sum() {
		long sum = 0;
		for(long i = from; i <= to; i++) {
			sum += i;
		}
		return sum;
	}

	@Override
	protected Long compute() {
		long size = to - from + 1; // from <= i <= to
		
		if(size <= 5) { // 더할 숫자가 5개 이하이면
			return sum(); 
		}
		
		// 범위를 반으로 나눠서 두 개의 작업을 생성
		long half = (from + to) / 2;
		
		SumTask leftSum = new SumTask(from, half);
		SumTask rightSum = new SumTask(half+1, to);
		
		leftSum.fork(); // 작업(leftSum)을 작업 큐에 넣음, 비동기 메서드
		
		return rightSum.compute() + leftSum.join(); // join : 동기 메서드
		
	}
}
