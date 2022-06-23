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
	 * title : FileReader.read() �޼��带 ����Ͽ� ���� �б�
	 * FileInputStream�� ����Ʈ��� ��Ʈ���̱� ������ ������ ������� 1byte�� �аԵǾ� �ѱ�(2byte)��
	 * �аԵɽ� �����Ե˴ϴ�.
	 * 
	 * FileReader �ν��Ͻ� �޼���
	 * int read() : �Է¼ҽ��κ��� �ϳ��� ���ڸ� �о�ɴϴ�. char�� ������ 0~65535 ������
	 * ������ ��ȯ�ϸ�, �Է� ��Ʈ���� �������� �����ϸ� -1�� ��ȯ�մϴ�.
	 */
	@Order(1)
	@Test
	void fileReaderTest() {
		String fileName = "./src/ch15/ex_07_FileReader_FileWriter/test.txt";
		try(FileInputStream fis = new FileInputStream(fileName);
			FileReader fr = new FileReader(fileName)){
			
			int data = 0;
			
			// FileInputStream�� �̿��ؼ� ���� ������ �о� ȭ�鿡 ����Ѵ�.
			while((data = fis.read()) != -1) { // �ѱ��� 2byte�ε� 1byte�� �о �����Ե�
				System.out.print((char) data);
			}
			System.out.println();
			fis.close();
			
			// FileReader�� �̿��ؼ� ���� ������ �о� ȭ�鿡 ����Ѵ�.
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
	 * title : ������ �о ������ ������ ��� ���ְ� ���Ͽ� ����
	 * FileWriter �ν��Ͻ� �޼���
	 * void write(int b) : �־��� ���� ��¼ҽ��� ����
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