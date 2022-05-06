package ch07.ex_21_polyArgument;

/**
 * 매개변수의 다형성
 * - 참조변수의 다형적인 특징은 매개변수에도 적용됨
 * - 매개변수의 참조변수 타입을 조상 클래스로 정의하면 메서드 호출시 전달하는 인자의 타입은
 * 해당 조상 클래스 타입이거나 자손 클래스 타입의 인스턴스가 될 수 있습니다.
 * 
 * - b.buy(new TV()) => buy(Product p)
 * buy 메서드 호출시 Product 클래스의 자손 클래스인 TV 클래스를 전달합니다.
 * 참조변수 p는 조상 클래스이므로 인스턴스를 가리킬 수 있습니다. 
 */
public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new TV());
		b.buy(new Computer());
		
		System.out.printf("현재 남은 돈은 %d 만원입니다.\n", b.money);
		System.out.printf("현재 보너스점수는 %d 점입니다.\n", b.bonusPoint);
	}
}

class Product{
	int price;		// 제품 가격
	int bonusPoint;	// 제품구매시 제공하는 보너스 점수
	
	public Product(int price) {
		this.price = price;
		this.bonusPoint = (int) (price * 0.1);
	}
}

class TV extends Product{
	TV(){
		// 조상 클래스(Product)의 생성자 Product(int price) 호출
		// TV의 가격을 100만원으로 설정
		super(100);	
	}

	@Override
	public String toString() {
		// Object 클래스의 toString()을 오버라이딩함
		return "TV";
	}
}

class Computer extends Product{
	public Computer() {
		super(200);
	}

	@Override
	public String toString() {
		return "Computer";
	}
}

class Buyer{	// 고객, 물건을 사는 사람
	int money = 1000;	// 소유금액
	int bonusPoint = 0; // 보너스점수
	
	// 매개변수로 Product 클래스와 Product 클래스의 자손 클래스들을 받을 수 있음
	public void buy(Product p) {	
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살수 없습니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.printf("%s 을/를 구입하였습니다.\n", p);
	}
}