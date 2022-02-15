package other.constructor.constructor_01_builder_pattern.ex02_telescope_constructor_pattern;

public class Student {
	private int stdno;	// �й�
	private String name;// �̸�
	private String dept;// �а�
	private int age;	// ����
	
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
