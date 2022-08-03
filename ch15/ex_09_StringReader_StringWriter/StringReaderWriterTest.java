package ch15.ex_09_StringReader_StringWriter;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWriterTest {
	/**
	 * title : StringReader, StringWriter 테스트
	 * 
	 * StringBuffer getBuffer() : StringWriter에 출력한 데이터가 저장된 StringBuffer를 반환
	 * String       toString()  : StringWriter에 출력된(StringBuffer에 저장된) 문자열을 반환
	 */
	
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
