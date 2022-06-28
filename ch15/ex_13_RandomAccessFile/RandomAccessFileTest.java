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
	 * title : RnadomAccessFile을 이용하여 파일에 출력작업이 수행될때 파일 포인터의 위치를 확인하는 예제
	 * RandomAccessFile 인스턴스 메서드
	 * int  getFilePoint()    : 파일 포인터의 위치를 알려줌
	 * void writeInt(int v)   : 파일에 v값을 씀, int는 4byte이기 때문에 파일 포인터도 4증가
	 * void writeLong(long v) : 파일에 v값을 씀, long는 8byte이기 때문에 파일 포인터도 8증가
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
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());
			raf.writeInt(100);
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());
			raf.writeLong(100L);
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : RandomAccessFile을 이용하여 파일에 정수를 출력 및 읽기
	 * RandomAccessFile 인스턴스 메서드
	 * void seek(long pos) : 파일 포인터의 위치를 변경한다. 위치는 파일의 첫 부분부터 pos 크기만큼
	 * 떨어진곳입니다. (단위 byte)
	 */
	@Order(2)
	@Test
	void writeInt_readIntMethodTest() {
		printMethodName("writeInt_readIntMethodTest");
		
		//             번호, 국어, 영어, 수학
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
		
			raf.seek(0); // 파일 포인터가 쓰기 연산때문에 뒤로 이동했기 때문에, 다시 읽기 위해서는
						 // 파일 포인터의 위치를 변경해야합니다.
			while(true) {
				System.out.println(raf.readInt());
			}
		}catch(EOFException e) {
			// readInt()를 호출했을때 더이상 읽을 내용이 없으면 EOFException이 발생합니다.
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : RandomAccessFile.seek() 메서드를 사용하여 국어점수의 합계 출력
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
