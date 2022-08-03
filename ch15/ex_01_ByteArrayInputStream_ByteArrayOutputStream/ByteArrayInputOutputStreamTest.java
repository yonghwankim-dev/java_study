package ch15.ex_01_ByteArrayInputStream_ByteArrayOutputStream;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayInputOutputStreamTest {
	
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : InputStream, OutputStream�� read(), write() ���
	 * ByteArrayInputStream �ν��Ͻ� �޼���
	 * int read() : 1byte(0~255 ������ ��)�� �о��. ���̻� �о�� �����Ͱ� ������ -1�� ��ȯ��
	 * 
	 * ByteArrayOutputStream �ν��Ͻ� �޼���
	 * void write(int b)    : �־��� ���� ��¼ҽ��� ��
	 * byte[] toByteArray() : ��Ʈ���� ������ byte �迭�� ��ȯ  
	 */
	
	@Test
	void readWriteMethodTest() {
		printMethodName("readWriteMethodTest");
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		ByteArrayInputStream input  = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data = 0;
		
		while((data = input.read()) != -1) {
			output.write(data);
		}
		
		outSrc = output.toByteArray(); // ��Ʈ���� ������ byte�迭�� ��ȯ�Ѵ�.
		
		System.out.println("Input Source  : " + Arrays.toString(inSrc));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
	}
	
	/**
	 * title : byte�迭�� �о�ö� �迭�� �̿��Ͽ� read/write
	 * readWriteMethodTest�� byte�迭�� 1byte�� �о���� ������ ��ȿ�����̴�.
	 * byte �迭�� �̿��ؼ� �о������ ����
	 * 
	 * ByteArrayInputStream �ν��Ͻ� �޼���
	 * int read(byte[] b, int off, int len) 
	 *  : �ִ� len���� byte�� �о, �迭 b�� ������ ��ġ(off)���� �����Ѵ�.
	 *    ������ �о�� �� �ִ� �����Ͱ� len������ ���� �� ����
	 *    
	 * ByteArrayOutputStream �ν��Ͻ� �޼���
	 * void write(byte[] b, int off, int len)
	 *  : �־��� �迭 b�� ����� ���� �߿��� off��°���� len�� ��ŭ���� �о ��� �ҽ��� ����.
	 */
	
	@Test
	void readWriteByusingArrayTest() {
		printMethodName("readWriteByusingArrayTest");
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		byte[] temp = new byte[10];
		
		ByteArrayInputStream  input  = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
				
		input.read(temp, 0, temp.length); // �о�� �����͸� �迭 temp�� ��´�.
		output.write(temp, 5, 5);         // temp[5]���� 5���� �����͸� write�� ��´�.
		
		outSrc = output.toByteArray(); // ��Ʈ���� ������ byte�迭�� ��ȯ�Ѵ�.
		
		System.out.println("Input Source  : " + Arrays.toString(inSrc));
		System.out.println("temp          : " + Arrays.toString(temp));
		System.out.println("Output Source : " + Arrays.toString(outSrc));		
	}
	
	/**
	 * title : ByteArrayInputStream.available() �޼���
	 * ByteArrayInputStream �ν��Ͻ� �޼���
	 * int available() : ��Ʈ�����κ��� �о�ü� �ִ� �������� ũ�⸦ ��ȯ��
	 * 
	 * ��°��
	 * �������� ���� �迭�� 9��°�� 10��° ��Ұ��� 8�� 9���� ����ؾ� �ϴµ� temp�� �����ִ�
	 * 6, 7���� ��µ˴ϴ�.
	 * temp ���� ��ȭ
	 * [4, 5, 6, 7] -> [8, 9, 6, 7]
	 */
	
	@Test
	void availableMethodTest() {
		printMethodName("availableMethodTest");
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		ByteArrayInputStream  input  = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		System.out.println("Input Source  : " + Arrays.toString(inSrc));
		
		try {
			while(input.available() > 0) {
				input.read(temp);
				output.write(temp);
				
				outSrc = output.toByteArray();
				System.out.println("temp          : " + Arrays.toString(temp));
				System.out.println("Output Source : " + Arrays.toString(outSrc));				
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : available �޼��� ����
	 * ByteArrayOutputStream.write() �޼��� ���� �о�� ������ ������ŭ write�ϵ��� ���� 
	 */
	
	@Test
	void availableMethodImprovingTest() {
		printMethodName("availableMethodImprovingTest");
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		ByteArrayInputStream  input  = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			while(input.available() > 0) {
				int len = input.read(temp); // �о� �� �������� ������ ��ȯ�Ѵ�.
				output.write(temp, 0, len); // �о� �� ��ŭ�� write�Ѵ�.				
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		outSrc = output.toByteArray();
		System.out.println("Input Source  : " + Arrays.toString(inSrc));
		System.out.println("temp          : " + Arrays.toString(temp));
		System.out.println("Output Source : " + Arrays.toString(outSrc));		
	}

	
	
}
