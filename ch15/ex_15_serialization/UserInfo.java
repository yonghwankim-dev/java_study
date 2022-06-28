package ch15.ex_15_serialization;

import java.io.Serializable;

public class UserInfo implements Serializable {
		
	String name;
	String password;
	int age;
	
	public UserInfo() {
		this("Unknown", "1111", 0);
	}
	
	public UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}

	@Override
	public String toString() {
		return "(" + name + "," + password + "," + age + ")";
	}
}
