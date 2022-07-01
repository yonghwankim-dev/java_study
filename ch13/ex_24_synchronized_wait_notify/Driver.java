package ch13.ex_24_synchronized_wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * title : 식당에서 음식(Dish)를 만들어서 테이블(Table)에 추가(add)하는 요리사(Cook)와
 * 테이블의 음식을 소비(remove)하는 손님(Customer)을 구현하는 쓰레드 예제
 * 
 *  문제 발생
 *  1. 만약 waiting pool에 요리사 쓰레드와 손님 쓰레드가 같이 기다리는 경우
 *  2. notify() 호출시 손님 쓰레드가 선택받을 수 있다.
 *  
 *  해결 방법
 *  1. notifyAll()을 통하여 대기중인 요리사, 손님 쓰레드를 모두 깨우는 방법
 *  => 요리사는 결국 lock을 얻어 요리를 만들 것이다.
 *  => 그러나 요리사 쓰레드는 손님 쓰레드와 경쟁하여 lock을 얻어야함 (race condition 상태)
 *  => 경재상태(race condition)를 개선하기 위해서 요리사 쓰레드와 손님 쓰레드를 구별해서 통지하는 것이 필요함
 */
public class Driver {

	public static void main(String[] args) throws InterruptedException {
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"),  "CUST2").start();
		
		Thread.sleep(2000);
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
	
	public synchronized void add(String dish) {
		// 이미 테이블에 음식이 꽉차있는 경우
		while(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is wating");
			
			try {
				wait(); // 요리사(COOK) 쓰레드를 기다리게 한다.
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		dishes.add(dish);
		notify(); // 기다리고 있는 손님(CUSTOMER)에게 알려줌
		System.out.println("Dishes : " + dishes);
	}
	
	public void remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();
			// 손님이 테이블에 먹을 음식이 없는 경우
			while(dishes.size() == 0) {
				System.out.println(name + " is wating");
				
				try {
					wait(); // 손님을 기다리게 한다.
					Thread.sleep(500);
				} catch (InterruptedException e) {} 
			}
			
			while(true) {
				// 손님이 먹고자 하는 요리가 나온 음식들 중에 있으면 먹는다.
				for(int i = 0; i < dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify(); // 요리사에게 음식을 먹었다고 알려줌
						return;
					}
				} // end for
			
				try {
					System.out.println(name + " waiting");
					wait(); // 원하는 음식이 없는 손님(CUSTOMER) 쓰레드는 대기합니다.
					Thread.sleep(500);
				}catch (InterruptedException e) {}
			}// end while
		}// end synchronized
	}
	
	public int dishNum() {
		return dishNames.length;
	}
}