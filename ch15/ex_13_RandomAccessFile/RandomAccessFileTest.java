package ch15.ex_13_RandomAccessFile;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class RandomAccessFileTest {
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : RnadomAccessFile�� �̿��Ͽ� ���Ͽ� ����۾��� ����ɶ� ���� �������� ��ġ�� Ȯ���ϴ� ����
	 * RandomAccessFile �ν��Ͻ� �޼���
	 * int  getFilePoint()    : ���� �������� ��ġ�� �˷���
	 * void writeInt(int v)   : ���Ͽ� v���� ��, int�� 4byte�̱� ������ ���� �����͵� 4����
	 * void writeLong(long v) : ���Ͽ� v���� ��, long�� 8byte�̱� ������ ���� �����͵� 8����
	 *  
	 * int = 4byte
	 * long = 4byte
	 */
	@Order(1)
	@Test
	void filePointMethodTest() {
		printMethodName("filePointMethodTest");
		
		String filePath = "src/ch15/ex_13_RandomAccessFile/test.dat";
		try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")){
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());
			raf.writeInt(100);
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());
			raf.writeLong(100L);
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : RandomAccessFile�� �̿��Ͽ� ���Ͽ� ������ ��� �� �б�
	 * RandomAccessFile �ν��Ͻ� �޼���
	 * void seek(long pos) : ���� �������� ��ġ�� �����Ѵ�. ��ġ�� ������ ù �κк��� pos ũ�⸸ŭ
	 * ���������Դϴ�. (���� byte)
	 */
	@Order(2)
	@Test
	void writeInt_readIntMethodTest() {
		printMethodName("writeInt_readIntMethodTest");
		
		//             ��ȣ, ����, ����, ����
		int[] score = { 1, 100,  90,  90,
				        2,  70,  90, 100,
				        3, 100, 100, 100,
				        4,  70,  60,  80,
				        5,  70,  90, 100};
		
		String filePath = "src/ch15/ex_13_RandomAccessFile/score2.dat";
		try(RandomAccessFile raf = new RandomAccessFile(filePath, "rw")){
			for(int i = 0; i < score.length; i++) {
				raf.writeInt(score[i]);
			}
		
			raf.seek(0); // ���� �����Ͱ� ���� ���궧���� �ڷ� �̵��߱� ������, �ٽ� �б� ���ؼ���
						 // ���� �������� ��ġ�� �����ؾ��մϴ�.
			while(true) {
				System.out.println(raf.readInt());
			}
		}catch(EOFException e) {
			// readInt()�� ȣ�������� ���̻� ���� ������ ������ EOFException�� �߻��մϴ�.
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : RandomAccessFile.seek() �޼��带 ����Ͽ� ���������� �հ� ���
	 */
	@Order(3)
	@Test
	void seekMethodTest() {
		printMethodName("seekMethodTest");
		
		int sum = 0;
		String filePath = "src/ch15/ex_13_RandomAccessFile/score2.dat";
		
		try(RandomAccessFile raf = new RandomAccessFile(filePath, "r")){
			int i = 4;
			
			while(true) {
				raf.seek(i);
				sum += raf.readInt();
				i += 16;
			}
			
		}catch (EOFException e) {
			System.out.println("sum : " + sum);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
