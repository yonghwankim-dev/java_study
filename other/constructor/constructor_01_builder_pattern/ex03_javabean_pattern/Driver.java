package other.constructor.constructor_01_builder_pattern.ex03_javabean_pattern;

public class Driver {

	public static void main(String[] args) {
		
		// 자바빈 패턴
		// 객체를 생성하고 나서 setter 메서드를 통해서 설정함
		// 생성자의 영향을 받지 않기 때문에 생성자를 많이 구현할 필요가 없음
		// 문제는 한번의 생성자 호출로 끝낼수 없기 때문에 일관성이 깨질 수 있음
		// 그리고 변하지 않는 immutable한 객체를 생성할 수 없음
		Student std1 = new Student();
		
		std1.setStdno(1);
		std1.setName("홍길동");
		std1.setDept("컴퓨터공학과");
		std1.setAge(20);
		
		System.out.println(std1);

	}
}
