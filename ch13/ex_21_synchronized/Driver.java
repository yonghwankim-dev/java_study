package ch13.ex_21_synchronized;

/**
 * title : ����ȭ�� �ʿ伺
 * �� �����尡 ����� �Ϸ��� ���� ������� �Ѿ�� �ٸ� �����尡 �ܰ��˻縦 ����Ͽ� ����� �ϰԵǾ�
 * �ܰ��� ������ ������ ������ �߻���
 * 
 * �����ڿ� : balance
 */
public class Driver {
	public static void main(String[] args) {
		Runnable r = new MyThread(new Account(1000));
		
		new Thread(r).start(); // ThreadGroup�� ���� �����ǹǷ� gc����� �ƴմϴ�.
		new Thread(r).start(); // ThreadGroup�� ���� �����ǹǷ� gc����� �ƴմϴ�.
		 
		
	}
}

class Account{
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			balance -= money;
		}
	}
}

class MyThread implements Runnable{
	Account account;

	public MyThread(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		while(account.getBalance() > 0) {
			// 100, 200, 300 ���� �� ���� ���Ƿ� �����ؼ� ���
			int money = (int) (Math.random() * 3 + 1) * 100;
			account.withdraw(money);
			System.out.println("balance:" + account.getBalance());
		}
	}
	
}