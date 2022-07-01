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
		System.exit(0); // 프로그램 전체를 종료 (모든 쓰레드가 종료됨)
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
			// 임의의 요리를 하나 선택해서 table에 추가함
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
			// 이미 테이블에 음식이 꽉차있는 경우
			while(dishes.size() >= MAX_FOOD) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is wating");
				
				try {
					forCook.await(); // 요리사(COOK) 쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			
			dishes.add(dish);
			forCust.signal(); // 기다리고 있는 손님(CUSTOMER)에게 알려줌
			System.out.println("Dishes : " + dishes);
		}finally {
			lock.unlock();
		}		
	}
	
	public void remove(String dishName) {
		lock.lock();
		
		try {
			String name = Thread.currentThread().getName();
			// 손님이 테이블에 먹을 음식이 없는 경우
			while(dishes.size() == 0) {
				System.out.println(name + " is wating");
				
				try {
					forCust.await(); // 손님을 기다리게 한다.
					Thread.sleep(500);
				} catch (InterruptedException e) {} 
			}
			
			while(true) {
				// 손님이 먹고자 하는 요리가 나온 음식들 중에 있으면 먹는다.
				for(int i = 0; i < dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						forCook.signal(); // 요리사에게 음식을 먹었다고 알려줌
						return;
					}
				} // end for
			
				// 손님이 먹고자 하는 요리가 나온 음식들 중에 없는 경우
				try {
					System.out.println(name + " waiting");
					forCust.await(); // 원하는 음식이 없는 손님(CUSTOMER) 쓰레드는 대기합니다.
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