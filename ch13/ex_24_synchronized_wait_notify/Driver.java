package ch13.ex_24_synchronized_wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * title : �Ĵ翡�� ����(Dish)�� ���� ���̺�(Table)�� �߰�(add)�ϴ� �丮��(Cook)��
 * ���̺��� ������ �Һ�(remove)�ϴ� �մ�(Customer)�� �����ϴ� ������ ����
 * 
 *  ���� �߻�
 *  1. ���� waiting pool�� �丮�� ������� �մ� �����尡 ���� ��ٸ��� ���
 *  2. notify() ȣ��� �մ� �����尡 ���ù��� �� �ִ�.
 *  
 *  �ذ� ���
 *  1. notifyAll()�� ���Ͽ� ������� �丮��, �մ� �����带 ��� ����� ���
 *  => �丮��� �ᱹ lock�� ��� �丮�� ���� ���̴�.
 *  => �׷��� �丮�� ������� �մ� ������� �����Ͽ� lock�� ������ (race condition ����)
 *  => �������(race condition)�� �����ϱ� ���ؼ� �丮�� ������� �մ� �����带 �����ؼ� �����ϴ� ���� �ʿ���
 */
public class Driver {

	public static void main(String[] args) throws InterruptedException {
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"),  "CUST2").start();
		
		Thread.sleep(2000);
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
	
	public synchronized void add(String dish) {
		// �̹� ���̺� ������ �����ִ� ���
		while(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is wating");
			
			try {
				wait(); // �丮��(COOK) �����带 ��ٸ��� �Ѵ�.
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		dishes.add(dish);
		notify(); // ��ٸ��� �ִ� �մ�(CUSTOMER)���� �˷���
		System.out.println("Dishes : " + dishes);
	}
	
	public void remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();
			// �մ��� ���̺� ���� ������ ���� ���
			while(dishes.size() == 0) {
				System.out.println(name + " is wating");
				
				try {
					wait(); // �մ��� ��ٸ��� �Ѵ�.
					Thread.sleep(500);
				} catch (InterruptedException e) {} 
			}
			
			while(true) {
				// �մ��� �԰��� �ϴ� �丮�� ���� ���ĵ� �߿� ������ �Դ´�.
				for(int i = 0; i < dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify(); // �丮�翡�� ������ �Ծ��ٰ� �˷���
						return;
					}
				} // end for
			
				try {
					System.out.println(name + " waiting");
					wait(); // ���ϴ� ������ ���� �մ�(CUSTOMER) ������� ����մϴ�.
					Thread.sleep(500);
				}catch (InterruptedException e) {}
			}// end while
		}// end synchronized
	}
	
	public int dishNum() {
		return dishNames.length;
	}
}