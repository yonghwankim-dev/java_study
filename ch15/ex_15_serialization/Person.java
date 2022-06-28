package ch15.ex_15_serialization;

public class Person {
	String name;
	String password;
	
	public Person() {
		this("Unknown", "1111");
	}
	
	public Person(String name, String password) {
		this.name = name;
		this.password = password;
	}
}
