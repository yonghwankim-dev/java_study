package ch15.ex_15_serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SerialTest {
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : UserInfo Ŭ���� Ÿ���� �ν��Ͻ��� ����ȭ�ϴ� ����
	 * ��ü�� ����ȭ�ϱ� ���� Ŭ���� : ObjectOutputStream
	 * ObjectOutputStream�� OutputStream�� ���� ��ӹ����� ��ݽ�Ʈ���� �ʿ���ϴ� ������Ʈ����
	 * 
	 */
	@Order(1)
	@Test
	void UserInfoSerialTest() {
		printMethodName("UserInfoSerialTest");
		
		String fileName = "./src/ch15/ex_15_serialization/UserInfo.ser";
		try(FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream out = new ObjectOutputStream(bos)){
			
			UserInfo u1 = new UserInfo("kim", "1234", 20);
			UserInfo u2 = new UserInfo("lee", "4567", 21);
			
			List<UserInfo> list = new ArrayList<UserInfo>();
			list.add(u1);
			list.add(u2);
			
			// ��ü�� ����ȭ�Ѵ�.
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(list);
			
			System.out.println("����ȭ�� �� �������ϴ�.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : ����ȭ�� UserInfo.ser ������ ������ȭ�Ͽ� ��ü ������ ��� ����ϴ� ����
	 * ������ȭ�ϴµ� ���Ǵ� Ŭ���� : ObjectInputStream
	 * Object ObjectInputStream.readObject() : ����ȭ�� ��ü�� ������ȭ��
	 * ����Ÿ���� Object�̹Ƿ� ����ȯ�� �ʿ���
	 * 
	 * ������ȭ�� ����ȭ�� ������� �ؾ���
	 */
	@Order(2)
	@Test
	void UserInfoDeSerialTest() {
		printMethodName("UserInfoDeSerialTest");
		
		String fileName = "./src/ch15/ex_15_serialization/UserInfo.ser";
		try (FileInputStream fis = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream in = new ObjectInputStream(bis)){
						
						// ��ü�� ���� ���� ����� ������ ��ġ�ؾ��Ѵ�.
						UserInfo u1 =(UserInfo) in.readObject();
						UserInfo u2 = (UserInfo) in.readObject();
						List<UserInfo> list = (ArrayList<UserInfo>) in.readObject();
						
						System.out.println(u1);
						System.out.println(u2);
						System.out.println(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : �θ� Ŭ����(Person)�� ����ȭ �������̽��� �������� ���� ���¿���
	 * �ڽ� Ŭ����(Student)�� ����ȭ �ϴ� ����
	 * 
	 * 1. �ڽ� Ŭ�������� ����ȭ�ϱ� ���ؼ� Serializable �������̽� ����
	 * 2. writeObject() ����
	 * 3. readObject() ����  
	 */
	@Order(3)
	@Test
	void StudentSerialTest() {
		printMethodName("StudentSerialTest");
		
		String fileName = "./src/ch15/ex_15_serialization/Student.ser";
		try(FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream out = new ObjectOutputStream(bos)){
			
			UserInfo u1 = new UserInfo("kim", "1234", 20);
			UserInfo u2 = new UserInfo("lee", "4567", 21);
			
			Student s1 = new Student("kim", "1234", 201456386);
			Student s2 = new Student("lee", "4567", 201504138);
			
			
			
			List<Student> list = new ArrayList<Student>();
			list.add(s1);
			list.add(s2);
			
			// ��ü�� ����ȭ�Ѵ�.
			out.writeObject(s1);	// s1.writeObject()�� ȣ���
			out.writeObject(s2);
			out.writeObject(list);
			
			System.out.println("����ȭ�� �� �������ϴ�.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * title : ���� Ŭ������ ����ȭ �������̽��� �������� ���� ���¿��� �ڽ� Ŭ������
	 * ������ȭ�ϴ� ����
	 */
	@Order(4)
	@Test
	void StudentDeSerialTest() {
		printMethodName("StudentDeSerialTest");
		
		String fileName = "./src/ch15/ex_15_serialization/Student.ser";
		try (FileInputStream fis = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream in = new ObjectInputStream(bis)){
						
						// ��ü�� ���� ���� ����� ������ ��ġ�ؾ��Ѵ�.
						Student s1 = (Student) in.readObject();
						Student s2 = (Student) in.readObject();
						List<Student> list = (ArrayList<Student>) in.readObject();
						
						System.out.println(s1);
						System.out.println(s2);
						System.out.println(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
}
