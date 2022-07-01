package ch13.ex_23_synchronized_wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * title : 식당에서 음식(Dish)를 만들어서 테이블(Table)에 추가(add)하는 요리사(Cook)와
 * 테이블의 음식을 소비(remove)하는 손님(Customer)을 구현하는 쓰레드 예제
 * 
 * 1. add(), remove() 메서드에 동기화를 수행함
 * 
 * 문제 발생
 * 1. 요리사(Cook) 쓰레드는 음식을 추가하지 않고 손님(Customer) 쓰레드를 계속 기다리게함
 * 
 * 문제 발생 원인
 * 손님 쓰레드가 테이블 객체의 lock을 쥐고 기다리고 있기 때문이다.
 *  
 */
public class Driver {

	public static void main(String[] args) throws InterruptedException {
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "taco"),  "CUST2").start();
		new Thread(new Customer(table, "soup"),  "CUST3").start();
		
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
			
			if(eatFood()) {
				System.out.println(name + " ate a " + food);
			}else {
				System.out.println(name + " failed to eat :(");
			}
			
		}
	}
	
	boolean eatFood() {
		return table.remove(food);
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
				Thread.sleep(100);
			}catch (InterruptedException e) {
			}
		}
	}
}



class Table{
	String[] dishNames = {"donut", "taco", "soup"};
	final int MAX_FOOD = 6;
	
	private List<String> dishes = new ArrayList<String>();
	
	public synchronized void add(String dish) {
		// 테이블에 음식이 가득찼으면, 테이블에 음식을 추가하지 않는다.
		if(dishes.size() >= MAX_FOOD) {
			return;
		}
		dishes.add(dish);
		System.out.println("Dishes : " + dishes);
	}
	
	public boolean remove(String dishName) {
		synchronized (this) {
			while(dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + "is waiting");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
			
			// 지정된 요리와 일치하는 요리를 테이블에서 제거합니다.
			for(int i = 0; i < dishes.size(); i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
		}// synchronized
		return false;
	}
	
	public int dishNum() {
		return dishNames.length;
	}
}