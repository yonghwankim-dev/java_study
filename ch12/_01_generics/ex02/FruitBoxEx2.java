package ch12._01_generics.ex02;

import java.util.ArrayList;

/**
 * title : ���ѵ� ���׸� Ŭ����
 * <T extends Ŭ���� & �������̽�> 
 *
 */

class Fruit implements Eatable{
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

class Toy{
	@Override
	public String toString() {
		return "Toy";
	}
}

interface Eatable {
	
}

public class FruitBoxEx2 {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Grape> grapeBox = new FruitBox<Apple>(); // ����. Ÿ�� ����ġ
//		FruitBox<Toy>   toyBox   = new FruitBox<Toy>();   // ����.
		
		
		
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
//		appleBox.add(new Grape()); // ����. Grape�� Apple�� �ڼ��� �ƴ�
		grapeBox.add(new Grape());
		
		System.out.println("fruitBox-"+fruitBox);
		System.out.println("appleBox-"+appleBox);
		System.out.println("grapeBox-"+grapeBox);
		
	}

}

class FruitBox<T extends Fruit & Eatable> extends Box<T>{
	
}

class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	
	void add(T item) {
		list.add(item);
	}
	
	T get(int i) {
		return list.get(i);
	}

	int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
}