package ch07.ex_36_innerClass6;

/**
 * title : 익명 클래스(anonymous class)
 * 1. 익명 클래스 형식
 * new 조상 클래스 이름(){ // 멤버 선언 }
 * or
 * new 구현인터페이스이름(){ // 멤버 선언 } 
 *
 * 2. 익명 클래스는 이름이 없기 때문에 생성자를 가질 수 없음
 * 3. 조상 클래스의 이름이나 구현하고자 하는 인터페이스의 이름을 사용해서 정의함
 * 4. 오직 단 하나의 클래스를 상속받거나 단 하나의 인터페이스만을 구현할 수 있음
 */
public class InnerEx6{
	Object iv = new Object() { // 익명 클래스
		void method() {
			System.out.println("call anonymous class method1");
		}
	};
	
	static Object cv = new Object() { // 익명 클래스
		void method() {
			System.out.println("call anonymous class method2");
		}
	};
	
	void myMethod() {
		Object lv = new Object() {	// 익명 클래스
			void method() {
				System.out.println("call nonymous class method3");
			}
		};
		
	}
}