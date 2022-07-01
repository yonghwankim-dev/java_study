package ch13.ex_25_locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */
public class Driver {

	public static void main(String[] args) throws InterruptedException {
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"),  "CUST2").start();
		
		Thread.sleep(10000);
		System.exit(0); // ���α׷� ��ü�� ���� (��� �����尡 �����)
	}

}

class Customer implements Runnable{
	private Table table;
	private String food;
	
	public Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			table.remove(food);
			System.out.println(name + " ate a " + food);
			
		}
	}
}

class Cook implements Runnable{
	private Table table;

	public Cook(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		while(true) {
			// ������ �丮�� �ϳ� �����ؼ� table�� �߰���
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(10);
			}catch (InterruptedException e) {}
		}// end while
	}
}



class Table{
	String[] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	
	private List<String> dishes = new ArrayList<String>();
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition forCook = lock.newCondition();
	private Condition forCust = lock.newCondition();
	
	public void add(String dish) {
		lock.lock();
		try {
			// �̹� ���̺� ������ �����ִ� ���
			while(dishes.size() >= MAX_FOOD) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is wating");
				
				try {
					forCook.await(); // �丮��(COOK) �����带 ��ٸ��� �Ѵ�.
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			
			dishes.add(dish);
			forCust.signal(); // ��ٸ��� �ִ� �մ�(CUSTOMER)���� �˷���
			System.out.println("Dishes : " + dishes);
		}finally {
			lock.unlock();
		}		
	}
	
	public void remove(String dishName) {
		lock.lock();
		
		try {
			String name = Thread.currentThread().getName();
			// �մ��� ���̺� ���� ������ ���� ���
			while(dishes.size() == 0) {
				System.out.println(name + " is wating");
				
				try {
					forCust.await(); // �մ��� ��ٸ��� �Ѵ�.
					Thread.sleep(500);
				} catch (InterruptedException e) {} 
			}
			
			while(true) {
				// �մ��� �԰��� �ϴ� �丮�� ���� ���ĵ� �߿� ������ �Դ´�.
				for(int i = 0; i < dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						forCook.signal(); // �丮�翡�� ������ �Ծ��ٰ� �˷���
						return;
					}
				} // end for
			
				// �մ��� �԰��� �ϴ� �丮�� ���� ���ĵ� �߿� ���� ���
				try {
					System.out.println(name + " waiting");
					forCust.await(); // ���ϴ� ������ ���� �մ�(CUSTOMER) ������� ����մϴ�.
					Thread.sleep(500);
				}catch (InterruptedException e) {}
			}// end while			
		}finally {
			lock.unlock();
		}
	}
	
	public int dishNum() {
		return dishNames.length;
	}
}