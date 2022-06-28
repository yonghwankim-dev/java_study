package ch15.ex_15_serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student extends Person implements Serializable{
	int stdNum;	// �й�
	
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
	
	// �θ� Ŭ������ ����� ����ȭ�� ������. �������� �Ϲ����� ����ȭ�� ����
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(name);
		out.writeUTF(password);
		out.defaultWriteObject();
	}
	
	// �θ� Ŭ������ ����� ������ȭ�� ������. �������� �Ϲ����� ������ȭ�� ����
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		name = in.readUTF();
		password = in.readUTF();
		in.defaultReadObject();
	}
	
	
}
