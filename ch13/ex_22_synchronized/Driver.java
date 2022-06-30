package ch13.ex_22_synchronized;

/**
 * title : synchronized 적용
 * 메서드 또는 어느 일점 범위에 synchronized 키워드를 적용하여 동기화를 수행합니다.
 */
public class Driver {
	public static void main(String[] args) {
		Runnable r = new MyThread(new Account(1000));
		
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아닙니다.
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아닙니다.
		 
		
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
	
	public synchronized void withdraw(int money) {
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
			// 100, 200, 300 중의 한 값을 임의로 선택해서 출금
			int money = (int) (Math.random() * 3 + 1) * 100;
			account.withdraw(money);
			System.out.println("balance:" + account.getBalance());
		}
	}
	
}