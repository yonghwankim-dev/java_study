package other.constructor.constructor_01_builder_pattern.ex03_javabean_pattern;

public class Student {
	private int stdno;	// 학번
	private String name;// 이름
	private String dept;// 학과
	private int age;	// 나이

	public Student() {
		
	}

	public Student(int stdno, String name, String dept, int age) {
		this.stdno = stdno;
		this.name = name;
		this.dept = dept;
		this.age = age;
	}
	
	public void setStdno(int stdno) {
		this.stdno = stdno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [stdno=" + stdno + ", name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}
	
}
