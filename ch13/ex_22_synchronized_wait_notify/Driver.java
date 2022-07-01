package ch13.ex_22_synchronized_wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * title : 식당에서 음식(Dish)를 만들어서 테이블(Table)에 추가(add)하는 요리사(Cook)와
 * 테이블의 음식을 소비(remove)하는 손님(Customer)을 구현하는 쓰레드 예제
 * 
 * 발생할 수 있는 문제점
 * 1. 요리사(Cook) 쓰레드가 테이블에 음식을 놓는 도중에, 손님(Customer) 쓰레드가 음식을 가져가려
 * 했기 때문에 예외(ConcurrentModificationException)가 발생함
 * 2. 손님 쓰레드가 테이블의 마지막 남은 음식을 가져가는 도중에 다른 손님 쓰레드가 먼저 음식을 낚아채버려서(remove)
 * 있지도 않은 음식을 테이블에서 제거하려 했기 대문에 발생하는 예외(IndexOutOfBoundsException)
 * 
 * 문제 발생 원인
 * 여러 쓰레드(Cusotmer, Cook)가 테이블을 공유하는데도 동기화를 하지 않기 때문이다.
 * 
 */
public class Driver {

	public static void main(String[] args) throws InterruptedException {
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "taco"),  "CUST2").start();
		
		Thread.sleep(100);
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
				Thread.sleep(1);
			}catch (InterruptedException e) {
			}
		}
	}
}



class Table{
	String[] dishNames = {"donut", "taco", "soup"};
	final int MAX_FOOD = 6;
	
	private List<String> dishes = new ArrayList<String>();
	
	public void add(String dish) {
		// 테이블에 음식이 가득찼으면, 테이블에 음식을 추가하지 않는다.
		if(dishes.size() >= MAX_FOOD) {
			return;
		}
		dishes.add(dish);
		System.out.println("Dishes : " + dishes);
	}
	
	public boolean remove(String dishName) {
		// 지정된 요리와 일치하는 요리를 테이블에서 제거합니다.
		for(int i = 0; i < dishes.size(); i++) {
			if(dishName.equals(dishes.get(i))) {
				dishes.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public int dishNum() {
		return dishNames.length;
	}
}