package ch13.ex_23_synchronized_wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * title : �Ĵ翡�� ����(Dish)�� ���� ���̺�(Table)�� �߰�(add)�ϴ� �丮��(Cook)��
 * ���̺��� ������ �Һ�(remove)�ϴ� �մ�(Customer)�� �����ϴ� ������ ����
 * 
 * 1. add(), remove() �޼��忡 ����ȭ�� ������
 * 
 * ���� �߻�
 * 1. �丮��(Cook) ������� ������ �߰����� �ʰ� �մ�(Customer) �����带 ��� ��ٸ�����
 * 
 * ���� �߻� ����
 * �մ� �����尡 ���̺� ��ü�� lock�� ��� ��ٸ��� �ֱ� �����̴�.
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
			// ������ �丮�� �ϳ� �����ؼ� table�� �߰���
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
		// ���̺� ������ ����á����, ���̺� ������ �߰����� �ʴ´�.
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
			
			// ������ �丮�� ��ġ�ϴ� �丮�� ���̺��� �����մϴ�.
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