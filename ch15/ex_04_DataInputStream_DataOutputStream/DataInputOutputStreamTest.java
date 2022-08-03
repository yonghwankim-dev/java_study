package ch15.ex_04_DataInputStream_DataOutputStream;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class DataInputOutputStreamTest {
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : DataOutputStream을 활용하여 기본 데이터 타입(int, float, ...)으로 write하기
	 * DataOutputStream 인스턴스 메서드
	 * void writeInt(int v)          : 파일에 4byte 크기로 값을 출력
	 * void writeFloat(float v)      : 파일에 4byte 크기로 값을 출력
	 * void writeBoolean(boolean v)  : 파일에 2byte 크기로 값을 출력
	 */
	
	@Test
	void writeIntFloatBooleanMethodTest() {
		printMethodName("writeIntFloatBooleanMethodTest");
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("./src/ch15/ex_04_DataInputStream_DataOutputStream/sample.dat");
			dos = new DataOutputStream(fos);
			
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);
			
			dos.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("./src/ch15/ex_04_DataInputStream_DataOutputStream/sample.dat");
			dis = new DataInputStream(fis);
			
			int   a   = dis.readInt();
			float b   = dis.readFloat();
			boolean c = dis.readBoolean();
			
			System.out.println(a); // 10
			System.out.println(b); // 20.0
			System.out.println(c); // true
			
			dis.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : 파일을 ByteArrayOutputStream을 이용하여 16진수 코드를 읽기
	 * 특정 데이터 타입으로 작성한 내용을 byte배열을 이용하여 16진수로 출력
	 */
	
	@Test
	void readHexCodeTest() {
		printMethodName("readHexCodeTest");
		
		ByteArrayOutputStream bos = null;
		DataOutputStream dos = null;
		
		byte[] result = null;
		
		try {
			bos = new ByteArrayOutputStream();
			dos = new DataOutputStream(bos);
			
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);
			
			result = bos.toByteArray();
			
			String[] hex = new String[result.length];
			
			for(int i = 0; i < result.length; i++) {
				if(result[i] < 0) {
					hex[i] = String.format("%02x", result[i] + 256);
				}else {
					hex[i] = String.format("%02x", result[i]);
				}
			}
			// Expected Output
			// 10진수 : [0, 0, 0, 10, 65, -96, 0, 0, 1]
			// 16진수 : [00, 00, 00, 0a, 41, a0, 00, 00, 01]
			System.out.println("10진수 : " + Arrays.toString(result));
			System.out.println("16진수 : " + Arrays.toString(hex));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : DataOutputStream.writeInt 메서드를 이용하여 파일에 정수 출력
	 * writeInt() 메서드를 통하여 4byte 크기의 16진수로 출력
	 */
	
	@Test
	void writeIntTest() {
		int[] scores = {100, 90, 95, 85, 50};
		
		try {
			FileOutputStream fos = new FileOutputStream("./src/ch15/ex_04_DataInputStream_DataOutputStream/score.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			
			for(int score : scores) {
				dos.writeInt(score);
			}
			
			dos.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : DataInputStream.readInt() 메서드를 이용한 정수 읽기
	 * DataIntputStream은 더이상 읽을 수 있는 데이터가 없다면 EOFExeption 예외를 발생시킴
	 */
	
	@Test
	void readIntTest() {
		printMethodName("readIntTest");
		
		int sum = 0;
		int score = 0;
		
		try(FileInputStream fis = new FileInputStream("./src/ch15/ex_04_DataInputStream_DataOutputStream/score.dat");
		    DataInputStream dis = new DataInputStream(fis)) {
			while(true) {
				score = dis.readInt();
				System.out.println(score);
				sum += score;
			}
		}catch(EOFException e) {
			System.out.println("점수의 총합은 " + sum + "점 입니다.");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}		   
	}
}
