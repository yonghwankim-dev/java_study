package ch15.ex_02_FileInputStream_FileOutputStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamTest {
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : FileInputStream read() 메서드를 활용하여 파일 내용 보기
	 * FileInputStream 인스턴스 메서드
	 * int read() : 파일로부터 1byte 읽어옴, 읽어올 데이터가 없으면 -1을 반환함
	 * 
	 * 작은 데이터 단위(byte)에서 큰 데이터 단위(char)로 형변환시 데이터 손실이 없음, 단 반대는
	 * 손실이 발생함
	 * 
	 * @throws IOException
	 */
	
	@Test
	void fileViewerTest() throws IOException {
		printMethodName("fileViewerTest");
		
		FileInputStream fis = new FileInputStream("./src/ch15/ex_02_FileInputStream_FileOutputStream/note.txt");
		int data = 0;
		
		while((data = fis.read()) != -1) {
			char c = (char) data; // 1byte -> 2byte, 데이터 손실은 없음
			System.out.print(c);
		}
	}
	
	/**
	 * title : FileInputStream/FileOutputStream을 이용해서 파일을 복사하기
	 * FileOutputStream 인스턴스 메서드
	 * void write(int b) : b값을 파일에 작성함
	 */
	
	@Test
	void fileCopyTest(){
		printMethodName("fileCopyTest");
		
		try(FileInputStream fis = new FileInputStream("./src/ch15/ex_02_FileInputStream_FileOutputStream/note.txt");
				FileOutputStream fos = new FileOutputStream("./src/ch15/ex_02_FileInputStream_FileOutputStream/note_copy.txt")) {
			int data = 0;
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
