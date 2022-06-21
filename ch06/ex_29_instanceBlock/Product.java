package ch06.ex_29_instanceBlock;

import java.util.Arrays;

/**
 * 인스턴스 블록 활용 예제 
 * - 인스턴스를 생성할때마다 인스턴스 초기화 블럭이 수행됨
 */
public class Product {
	static int count = 0;	// 생성된 인스턴의 수를 저장하기 위한 변수
	int serialNo;			// 인스턴스 고유 번호
	
	{
		count++;
		serialNo = count;
	}
	
	public Product() {
		
	}
	
	public static void main(String[] args)
	{
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.printf("p1의 제품번호(serialNo) = %d\n", p1.serialNo);
		System.out.printf("p2의 제품번호(serialNo) = %d\n", p2.serialNo);
		System.out.printf("p3의 제품번호(serialNo) = %d\n", p3.serialNo);
		System.out.printf("현재 생상한 제품 수 = %d\n", Product.count);
		
		
	}
}
