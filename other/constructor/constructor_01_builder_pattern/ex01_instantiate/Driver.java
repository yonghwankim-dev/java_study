package other.constructor.constructor_01_builder_pattern.ex01_instantiate;

public class Driver {

	public static void main(String[] args) {
		// 한 생성자에 모든 필드 멤버를 정의하면 객체 생성시 어떠한 인자값이 어떤 필드멤버를 나타내는지 어려움
		// 이러한 상황은 가독성이 매우 떨어짐
		Student std1 = new Student(1, "홍길동", null, 20);
		
		System.out.println(std1);
	}
}
