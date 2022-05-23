package ch07.ex_35_innerClass5;

/**
 * title : 외부 클래스(Outer)와 내부 클래스(Inner)에 선언된 변수 이름이 같을때 구별
 * 1. 외부 클래스(Outer)와 내부 클래스(Inner)에 선언된 변수 이름(value)이 같을 때 'this' 또는
 * '외부 클래스.this'를 붙여서 서로 구별할 수 있음
 *
 */
class Outer{
	int value = 10; // Outer.this.value
	
	class Inner{
		int value = 20;	// this.value
		
		void method1() {
			int value = 30;
			
			System.out.println("           value : " + value); // 30
			System.out.println("      this.value : " + this.value); // 20
			System.out.println("Outer.this.value : " + Outer.this.value); // 10
		}
	}
	
}

public class InnerEx5 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method1();
	}
}
