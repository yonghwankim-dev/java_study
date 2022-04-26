package ch06.ex_19_staticMethod;


/**
 * 클래스 메서드와 인스턴스 메서드
 * 
 * 클래스 메서드 : static 메서드
 * 인스턴스 메서드 : static x
 */
public class Driver {
		
	public static void main(String[] args) {
		// 클래스 메서드 호출
		System.out.println(MyMath.add(3, 5));
		System.out.println(MyMath.subtract(3, 5));
		System.out.println(MyMath.multiply(3, 5));
		System.out.println(MyMath.divide(3, 5));
		
		// 인스턴스 메서드 호출
		MyMath mm = new MyMath();
		
		mm.a = 3;
		mm.b = 5;
		
		System.out.println(mm.add());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
		
	}
}
