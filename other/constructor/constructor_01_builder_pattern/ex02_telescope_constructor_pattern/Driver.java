package other.constructor.constructor_01_builder_pattern.ex02_telescope_constructor_pattern;

public class Driver {

	public static void main(String[] args) {
		
		// 인스턴스화의 가독성 문제를 해결하기 위해서 생성자 오버로딩을 통해서
		// 생성자를 오버로딩함
		// 객체 생성시에는 가독성이 좋아질 순 있어도 Student 클래스는 그렇지 않음
		Student std1 = new Student(1, "홍길동");
		
		System.out.println(std1);

	}

}
