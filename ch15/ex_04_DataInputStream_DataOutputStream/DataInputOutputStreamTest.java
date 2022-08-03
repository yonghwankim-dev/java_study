package ch15.ex_04_DataInputStream_DataOutputStream;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class DataInputOutputStreamTest {
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : DataOutputStream�� Ȱ���Ͽ� �⺻ ������ Ÿ��(int, float, ...)���� write�ϱ�
	 * DataOutputStream �ν��Ͻ� �޼���
	 * void writeInt(int v)          : ���Ͽ� 4byte ũ��� ���� ���
	 * void writeFloat(float v)      : ���Ͽ� 4byte ũ��� ���� ���
	 * void writeBoolean(boolean v)  : ���Ͽ� 2byte ũ��� ���� ���
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
	 * title : ������ ByteArrayOutputStream�� �̿��Ͽ� 16���� �ڵ带 �б�
	 * Ư�� ������ Ÿ������ �ۼ��� ������ byte�迭�� �̿��Ͽ� 16������ ���
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
			// 10���� : [0, 0, 0, 10, 65, -96, 0, 0, 1]
			// 16���� : [00, 00, 00, 0a, 41, a0, 00, 00, 01]
			System.out.println("10���� : " + Arrays.toString(result));
			System.out.println("16���� : " + Arrays.toString(hex));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : DataOutputStream.writeInt �޼��带 �̿��Ͽ� ���Ͽ� ���� ���
	 * writeInt() �޼��带 ���Ͽ� 4byte ũ���� 16������ ���
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
	 * title : DataInputStream.readInt() �޼��带 �̿��� ���� �б�
	 * DataIntputStream�� ���̻� ���� �� �ִ� �����Ͱ� ���ٸ� EOFExeption ���ܸ� �߻���Ŵ
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
			System.out.println("������ ������ " + sum + "�� �Դϴ�.");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}		   
	}
}
