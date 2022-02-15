package other.constructor.constructor_01_builder_pattern.ex02_telescope_constructor_pattern;

public class Student {
	private int stdno;	// 학번
	private String name;// 이름
	private String dept;// 학과
	private int age;	// 나이
	
	public Student() {
		this(0,"","",0);
	}
	public Student(int stdno) {
		this(stdno,"","",0);
	}
	public Student(int stdno, String name) {
		this(stdno,name,"",0);
	}
	public Student(int stdno, String name, String dept) {
		this(stdno,name,dept,0);
	}
	public Student(int stdno, String name, String dept, int age) {
		this.stdno = stdno;
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [stdno=" + stdno + ", name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}
	
}
