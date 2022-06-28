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
	 * title : UserInfo 클래스 타입의 인스턴스를 직렬화하는 에제
	 * 객체를 직렬화하기 위한 클래스 : ObjectOutputStream
	 * ObjectOutputStream은 OutputStream을 직접 상속받지만 기반스트림을 필요로하는 보조스트림임
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
			
			// 객체를 직렬화한다.
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(list);
			
			System.out.println("직렬화가 잘 끝났습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : 직렬화한 UserInfo.ser 파일을 역직렬화하여 객체 정보를 얻어 출력하는 예제
	 * 역직렬화하는데 사용되는 클래스 : ObjectInputStream
	 * Object ObjectInputStream.readObject() : 직렬화된 객체를 역직렬화함
	 * 리턴타입이 Object이므로 형변환이 필요함
	 * 
	 * 역직렬화시 직렬화한 순서대로 해야함
	 */
	@Order(2)
	@Test
	void UserInfoDeSerialTest() {
		printMethodName("UserInfoDeSerialTest");
		
		String fileName = "./src/ch15/ex_15_serialization/UserInfo.ser";
		try (FileInputStream fis = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream in = new ObjectInputStream(bis)){
						
						// 객체를 읽을 때는 출력한 순서와 일치해야한다.
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
	 * title : 부모 클래스(Person)가 직렬화 인터페이스를 구현하지 않은 상태에서
	 * 자식 클래스(Student)가 직렬화 하는 예제
	 * 
	 * 1. 자식 클래스에서 직렬화하기 위해서 Serializable 인터페이스 구현
	 * 2. writeObject() 정의
	 * 3. readObject() 정의  
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
			
			// 객체를 직렬화한다.
			out.writeObject(s1);	// s1.writeObject()가 호출됨
			out.writeObject(s2);
			out.writeObject(list);
			
			System.out.println("직렬화가 잘 끝났습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * title : 조상 클래스가 직렬화 인터페이스를 구현하지 않은 상태에서 자식 클래스가
	 * 역직렬화하는 예제
	 */
	@Order(4)
	@Test
	void StudentDeSerialTest() {
		printMethodName("StudentDeSerialTest");
		
		String fileName = "./src/ch15/ex_15_serialization/Student.ser";
		try (FileInputStream fis = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream in = new ObjectInputStream(bis)){
						
						// 객체를 읽을 때는 출력한 순서와 일치해야한다.
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
