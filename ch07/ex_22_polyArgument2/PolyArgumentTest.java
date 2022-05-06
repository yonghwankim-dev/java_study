package ch07.ex_22_polyArgument2;

import java.util.ArrayList;
import java.util.List;

/**
 * 여러 종류의 객체를 배열로 다루기
 * - Product[] item = new Product[10]과 같이 선언하면 Buyer 클래스가
 * 자신이 구입한 여러개의 제품들을 저장할 수 있습니다.
 */
public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new TV());
		b.buy(new Computer());
		b.buy(new Audio());
		
		b.summary();
	}
}

class Product{
	int price;		// 제품 가격
	int bonusPoint;	// 제품구매시 제공하는 보너스 점수
	
	public Product() {
		
	}
	
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

class Audio extends Product{
	public Audio() {
		super(50);
	}

	@Override
	public String toString() {
		return "Audio";
	}	
}

class Buyer{			// 고객, 물건을 사는 사람
	int money;			// 소유금액
	int bonusPoint;		// 보너스점수
	Product[] item;		// 구입한 제품을 저장하기 위한 배열
	int i;				// item 배열의 인덱스
	
	public Buyer() {
		this(10);
	}
	
	public Buyer(int capacity) {
		money = 1000;
		bonusPoint = 0;
		item = new Product[capacity];
		i = 0;
	}
	
	/**
	 * 제품을 구매
	 * - 매개변수로 Product 클래스와 Product 클래스의 자손 클래스들을 받을 수 있음 (다형성)
	 * @param p 구매하고자 하는 물품
	 */
	public void buy(Product p) {	
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살수 없습니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.printf("%s 을/를 구입하였습니다.\n", p);
	}
	
	/**
	 * 구입한 물품에 대한 정보를 요약해서 보여줌
	 */
	public void summary() {	
		int sum = 0;			// 구입한 물품의 가격합계
		StringBuilder itemList = new StringBuilder();   // 구입한 물품목록	
		
		// 구입한 제품들을 리스트에 추가
		for(Product p : item)
		{
			if(p == null)
			{
				break;
			}
			sum += p.price;
			itemList.append(p+",");	
		}
		
		// 제일 뒤 콤마 제거
		itemList.deleteCharAt(itemList.length()-1);
		
		System.out.printf("구입하신 물품의 총금액은 %d 만원입니다.\n", sum);
		System.out.printf("구입하신 제품은 %s 입니다.\n", itemList.toString());
	}
}