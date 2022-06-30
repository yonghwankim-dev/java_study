package ch13.ex_21_synchronized;

/**
 * title : 동기화의 필요성
 * 한 쓰레드가 출금을 하려는 순간 제어권이 넘어가서 다른 쓰레드가 잔고검사를 통과하여 출금을 하게되어
 * 잔고가 음수가 나오는 문제가 발생함
 * 
 * 공유자원 : balance
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
			// 100, 200, 300 중의 한 값을 임의로 선택해서 출금
			int money = (int) (Math.random() * 3 + 1) * 100;
			account.withdraw(money);
			System.out.println("balance:" + account.getBalance());
		}
	}
	
}