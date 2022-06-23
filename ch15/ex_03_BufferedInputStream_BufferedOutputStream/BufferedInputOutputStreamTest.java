package ch15.ex_03_BufferedInputStream_BufferedOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class BufferedInputOutputStreamTest {
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : ������Ʈ���� BufferedOutputStream�� �̿��ؼ� 1~9�� ���Ͽ� �ۼ��ϱ�
	 * BufferedOutputStream�� ������
	 * BufferedOutputStream(OutputStream, int size) : size ũ���� ���۸� ������ ���۽�Ʈ�� ����
	 * 
	 * BufferedOutputStream�� �ν��Ͻ� �޼���
	 * void write(int b) : ���ۿ� b�� ����, ���� ���۰� ����á�ٸ� ��¼ҽ��� �����
	 *  
	 * ������ (123.txt)
	 * 12345
	 * 
	 * Q. �� 123.txt���� 123456789�� �ƴ� 12345�� ������ �Ǿ� �ִ°�?
	 * BufferedOutputStream�� ���۴� ���۰� ���� á������ ��¼ҽ��� ����� �ϱ� ������
	 * �ݺ����� ������������ 12345�� ��µǰ� BufferedOutputStream�� ���ۿ��� 6789�� ����ִ�
	 * ���¿��� ��� ��Ʈ���� FileOutputStream�� close�ǰ� ����Ǿ��� ������
	 * 6789�� ��µ��� �ʰ� ����Ȱ��Դϴ�.
	 */
	@Order(1)
	@Test
	void bufferedOutputStreamWriteTest() {
		printMethodName("bufferedOutputStreamWriteTest");
		
		try {
			FileOutputStream fos = new FileOutputStream("./src/ch15/ex_03_BufferedInputStream_BufferedOutputStream/123.txt");
			// BufferedOutputStream�� ���� ũ�⸦ 5���Ѵ�.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			
			// ���� 123.txt�� 1���� 9���� ���
			for(int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}
			
			fos.close();
		}catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
