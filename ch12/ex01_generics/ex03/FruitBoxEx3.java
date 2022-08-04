package ch12.ex01_generics.ex03;

import java.util.ArrayList;

/**
 * title : 와일드 카드를 통하여 상한 클래스를 지정
 * <? extends Fruit>
 */

class Fruit{
	@Override
	public String toString() {
		return "Fruit";
	}
}
class Apple extends Fruit{

	@Override
	public String toString() {
		return "Apple";
	}	
}

class Grape extends Fruit{

	@Override
	public String toString() {
		return "Grape";
	}
}
public class FruitBoxEx3 {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
		
	}

}

class Juice{
	String name;

	public Juice(String name) {
		this.name = name + "Juice";
	}

	@Override
	public String toString() {
		return name;
	}
}

class Juicer{
	static Juice makeJuice(FruitBox<? extends Fruit> box) {
		String tmp = "";
		
		for(Fruit f : box.getList()) {
			tmp += f + " ";
		}
		return new Juice(tmp);
	}
}

class FruitBox<T extends Fruit> extends Box<T>{
	
}

class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	
	void add(T item) {
		list.add(item);
	}
	
	T get(int i) {
		return list.get(i);
	}
	
	ArrayList<T> getList(){
		return list;
	}

	int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
}