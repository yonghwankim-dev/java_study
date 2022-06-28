package ch15.ex_09_StringReader_StringWriter;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class StringReaderWriterTest {
	/**
	 * title : StringReader, StringWriter �׽�Ʈ
	 * 
	 * StringBuffer getBuffer() : StringWriter�� ����� �����Ͱ� ����� StringBuffer�� ��ȯ
	 * String       toString()  : StringWriter�� ��µ�(StringBuffer�� �����) ���ڿ��� ��ȯ
	 */
	@Order(1)
	@Test
	void StringReaderWriterTest() {
		String inputData = "ABCD";
		StringReader input  = new StringReader(inputData);
		StringWriter output = new StringWriter();
		
		int data = 0;
		
		try {
			while((data = input.read()) != -1) {
				output.write(data);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Input Data  : " + inputData);
		System.out.println("Output Data : " + output.toString());
		
	}
}