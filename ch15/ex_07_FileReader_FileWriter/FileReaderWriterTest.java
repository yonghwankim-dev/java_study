package ch15.ex_07_FileReader_FileWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class FileReaderWriterTest {
	/**
	 * title : FileReader.read() 메서드를 사용하여 파일 읽기
	 * FileInputStream은 바이트기반 스트림이기 때문에 파일의 내용들을 1byte씩 읽게되어 한글(2byte)을
	 * 읽게될시 깨지게됩니다.
	 * 
	 * FileReader 인스턴스 메서드
	 * int read() : 입력소스로부터 하나의 문자를 읽어옵니다. char의 범위인 0~65535 범위의
	 * 정수를 반환하며, 입력 스트림의 마지막에 도달하면 -1을 반환합니다.
	 */
	@Order(1)
	@Test
	void fileReaderTest() {
		String fileName = "./src/ch15/ex_07_FileReader_FileWriter/test.txt";
		try(FileInputStream fis = new FileInputStream(fileName);
			FileReader fr = new FileReader(fileName)){
			
			int data = 0;
			
			// FileInputStream을 이용해서 파일 내용을 읽어 화면에 출력한다.
			while((data = fis.read()) != -1) { // 한글은 2byte인데 1byte씩 읽어서 깨지게됨
				System.out.print((char) data);
			}
			System.out.println();
			fis.close();
			
			// FileReader을 이용해서 파일 내용을 읽어 화면에 출력한다.
			while((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println();
			fr.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : 파일을 읽어서 파일의 공백을 모두 없애고 파일에 저장
	 * FileWriter 인스턴스 메서드
	 * void write(int b) : 주어진 값을 출력소스에 쓴다
	 */
	@Order(2)
	@Test
	void fileConversionTest() {
		try(FileReader fr = new FileReader("./src/ch15/ex_07_FileReader_FileWriter/FileReaderWriterTest.java");
			FileWriter fw = new FileWriter("./src/ch15/ex_07_FileReader_FileWriter/convert.txt")){
			
			int data = 0;
			while((data = fr.read()) != -1) {
				if(data != '\t' &&
				   data != '\n' &&
				   data != ' '  &&
				   data != '\r') {
					fw.write(data);
				}	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}