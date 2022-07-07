package ch12._01_generics.ex01;

import java.util.ArrayList;

/**
 * title : 지네릭 클래스의 객체 생성과 사용
 *
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

class Toy{
	@Override
	public String toString() {
		return "Toy";
	}
}

public class FruitBoxEx1 {

	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy>   toyBox = new Box<Toy>();
//		Box<Grape> grapeBox = new Box<Apple>(); // 에러. 타입 불일치
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple()); // ok. void add(Fruit item)
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
//		appleBox.add(new Toy()); // 에러. Box<Apple>에는 Apple만 담을 수 있음
		
		toyBox.add(new Toy());
//		toyBox.add(new Apple()); // 에러. Box<Toy>에는 Apple을 담을 수 없음
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
		
	}

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