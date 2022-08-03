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
	 * title : InputStream, OutputStream의 read(), write() 사용
	 * ByteArrayInputStream 인스턴스 메서드
	 * int read() : 1byte(0~255 사이의 값)를 읽어옴. 더이상 읽어올 데이터가 없으면 -1을 반환함
	 * 
	 * ByteArrayOutputStream 인스턴스 메서드
	 * void write(int b)    : 주어진 값을 출력소스에 씀
	 * byte[] toByteArray() : 스트림의 내용을 byte 배열로 반환  
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
		
		outSrc = output.toByteArray(); // 스트림의 내용을 byte배열로 반환한다.
		
		System.out.println("Input Source  : " + Arrays.toString(inSrc));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
	}
	
	/**
	 * title : byte배열을 읽어올때 배열을 이용하여 read/write
	 * readWriteMethodTest는 byte배열을 1byte씩 읽어오기 때문에 비효율적이다.
	 * byte 배열을 이용해서 읽어오도록 개선
	 * 
	 * ByteArrayInputStream 인스턴스 메서드
	 * int read(byte[] b, int off, int len) 
	 *  : 최대 len개의 byte를 읽어서, 배열 b의 지정된 위치(off)부터 저장한다.
	 *    실제로 읽어올 수 있는 데이터가 len개보다 적을 수 있음
	 *    
	 * ByteArrayOutputStream 인스턴스 메서드
	 * void write(byte[] b, int off, int len)
	 *  : 주어진 배열 b에 저장된 내용 중에서 off번째부터 len개 만큼만을 읽어서 출력 소스에 쓴다.
	 */
	
	@Test
	void readWriteByusingArrayTest() {
		printMethodName("readWriteByusingArrayTest");
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		byte[] temp = new byte[10];
		
		ByteArrayInputStream  input  = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
				
		input.read(temp, 0, temp.length); // 읽어온 데이터를 배열 temp에 담는다.
		output.write(temp, 5, 5);         // temp[5]부터 5개의 데이터를 write에 담는다.
		
		outSrc = output.toByteArray(); // 스트림의 내용을 byte배열로 반환한다.
		
		System.out.println("Input Source  : " + Arrays.toString(inSrc));
		System.out.println("temp          : " + Arrays.toString(temp));
		System.out.println("Output Source : " + Arrays.toString(outSrc));		
	}
	
	/**
	 * title : ByteArrayInputStream.available() 메서드
	 * ByteArrayInputStream 인스턴스 메서드
	 * int available() : 스트림으로부터 읽어올수 있는 데이터의 크기를 반환함
	 * 
	 * 출력결과
	 * 마지막에 읽은 배열의 9번째와 10번째 요소값이 8과 9만을 출력해야 하는데 temp에 남아있던
	 * 6, 7끼지 출력됩니다.
	 * temp 내용 변화
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
	 * title : available 메서드 개선
	 * ByteArrayOutputStream.write() 메서드 사용시 읽어온 데이터 개수만큼 write하도록 개선 
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
				int len = input.read(temp); // 읽어 온 데이터의 개수를 반환한다.
				output.write(temp, 0, len); // 읽어 온 만큼만 write한다.				
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
