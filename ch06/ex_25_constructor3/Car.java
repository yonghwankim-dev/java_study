package ch06.ex_25_constructor3;

/**
 * 생성자에서 다른 생성자 호출하기
 * - 메서드 오버로딩 기술 적용
 * - 생성자의 이름으로 클래스 이름 대신 this 사용
 * - 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫줄에서만 호출이 가능함
 * - this는 인스턴스 자신을 가리키는 참조변수
 */
public class Car {
	String color;		// 색상
	String gearType;	// 변속기 종류 - auto(자동), manual(수동)
	int door;			// 문의 개수
	
	public Car() {
		this("white", "auto", 4);
	}
	
	public Car(String color) {
		this(color, "auto", 4);
	}
	
	public Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}
