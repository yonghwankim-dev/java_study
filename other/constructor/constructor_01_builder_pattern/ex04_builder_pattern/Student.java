package other.constructor.constructor_01_builder_pattern.ex04_builder_pattern;

public class Student {
	private int stdno;	// 학번
	private String name;// 이름
	private String dept;// 학과
	private int age;	// 나이

	
	public Student(Builder builder) {
		this.stdno = builder.stdno;
		this.name = builder.name;
		this.dept = builder.dept;
		this.age = builder.age;
	}

	static class Builder{
		private int stdno;	// 학번
		private String name;// 이름
		private String dept;// 학과
		private int age;	// 나이
		
		public Builder(int stdno) {
			this.stdno = stdno;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder dept(String dept) {
			this.dept = dept;
			return this;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		public Student build() {
			return new Student(this);
		}
	}

	@Override
	public String toString() {
		return "Student [stdno=" + stdno + ", name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}
	
}
