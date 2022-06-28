package ch15.ex_12_StandardIO_StandardFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class StandardIOTest {
	/**
	 * title : ǥ���� �Է��� System.in�� ����Ͽ� �Է¹��� ������ ����ϱ�
	 * System.in  : InputStream Ÿ��
	 * System.out : PrintStream Ÿ��
	 * System.err : PrintStream Ÿ�� 
	 * 
	 * System.in �ν��Ͻ� �޼���
	 * int System.in.read() : ����ڷκ��� �ܼ��� ���ؼ� ������ �ִ� 255���� �Է¹���
	 *                        Enter Ű ������ '\r'(ĳ��������), '\n'�� ���� �Էµ�
	 *                        �̸� �����ϱ� ���ؼ� BufferedReader�� �̿���
	 */
	@Order(1)
	@Test
	void systemInTest() {
		try {
			int input = 0;
			
			while((input = System.in.read()) != -1) {
				System.out.println("input : " + input + ", (char) input : " + (char) input);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : �⺻ ����� ����� �ܼ�
	 * System.in(InputStream), System.out(PrintStream), System.err(PrintStream)
	 * �� �⺻ ����´���� �ܼ�(console)�Դϴ�.
	 * 
	 */
	@Order(2)
	@Test
	void outputTargetIsConsoleTest() {
		System.out.println("out : Hello World!");
		System.err.println("err : Hello World!");
	}
	
	/**
	 * title : setOut(PrintStream)�� ����Ͽ� ǥ�� ��� ����� FileOutputStream���� ����
	 * 
	 * static void setOut(PrintStream out) : System.out�� ����� ������ PrintStream���� ����
	 * static void setErr(PrintStream err) : System.err�� ����� ������ PrintStream���� ����
	 * static void setIn(InputStream in)   : System.in�� �Է��� ������ InputStream���� ����
	 */
	@Order(3)
	@Test
	void setOutMethodTest() {
		String filePath = "./src/ch15/ex_12_StandardIO_StandardFile/test.txt";
		try(FileOutputStream fos = new FileOutputStream(filePath);
			PrintStream ps = new PrintStream(fos)) {
			System.setOut(ps);
			
			System.out.println("Hello by System.out");
			System.err.println("Hello by System.err");
		}catch (FileNotFoundException e) {
			System.err.println("File not found.");
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
}
