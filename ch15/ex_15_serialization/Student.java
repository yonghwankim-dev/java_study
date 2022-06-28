package ch15.ex_15_serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student extends Person implements Serializable{
	int stdNum;	// 학번
	
	public Student() {
		this("Unknown", "1111", 0);
	}

	public Student(String name, String password, int stdNum) {
		super(name, password);
		this.stdNum = stdNum;
	}

	@Override
	public String toString() {
		return "(" + name + "," + password + "," + stdNum +")";
	}
	
	// 부모 클래스의 멤버의 직렬화를 수행함. 나머지는 일반적인 직렬화를 수행
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(name);
		out.writeUTF(password);
		out.defaultWriteObject();
	}
	
	// 부모 클래스의 멤버의 역직렬화를 수행함. 나머지는 일밭적인 역직렬화를 수행
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		name = in.readUTF();
		password = in.readUTF();
		in.defaultReadObject();
	}
	
	
}
