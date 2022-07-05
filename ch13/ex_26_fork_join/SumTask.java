package ch13.ex_26_fork_join;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long>{
	long from, to;

	public SumTask(long from, long to) {
		this.from = from;
		this.to = to;
	}
	
	// ������ ���� ��ȯ. sum()�� from���� to������ ���� ���ؼ� ��ȯ	
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
		
		if(size <= 5) { // ���� ���ڰ� 5�� �����̸�
			return sum(); 
		}
		
		// ������ ������ ������ �� ���� �۾��� ����
		long half = (from + to) / 2;
		
		SumTask leftSum = new SumTask(from, half);
		SumTask rightSum = new SumTask(half+1, to);
		
		leftSum.fork(); // �۾�(leftSum)�� �۾� ť�� ����, �񵿱� �޼���
		
		return rightSum.compute() + leftSum.join(); // join : ���� �޼���
		
	}
}
