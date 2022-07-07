package ch12._01_generics.ex02;

import java.util.ArrayList;

/**
 * title : 제한된 지네릭 클래스
 * <T extends 클래스 & 인터페이스> 
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
//		FruitBox<Grape> grapeBox = new FruitBox<Apple>(); // 에러. 타입 불일치
//		FruitBox<Toy>   toyBox   = new FruitBox<Toy>();   // 에러.
		
		
		
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
//		appleBox.add(new Grape()); // 에러. Grape는 Apple의 자손이 아님
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