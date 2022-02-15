package other.constructor.constructor_01_builder_pattern.ex04_builder_pattern;

public class Driver {

	public static void main(String[] args) {
		// builder 패턴
		// 점층적 생성자 패턴과 자바빈 패턴의 장점을 결합한 패턴
		// 새로운 객체가 필요한 곳에서 직접 생성하기 전에 필수 인자 값들을 전달하여
		// builder 객체를 만든 후 빌더 객체에 정의된 메서드를 호출해서 객체를 생성함
		Student std1 = new Student.Builder(1)
									.name("홍길동")
									.dept("컴퓨터공학과")
									.age(20)
									.build();
		
		System.out.println(std1);
							
	}

}
