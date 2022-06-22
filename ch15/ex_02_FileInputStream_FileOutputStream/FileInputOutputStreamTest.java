package ch15.ex_02_FileInputStream_FileOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class FileInputOutputStreamTest {
	/**
	 * title : FileInputStream read() �޼��带 Ȱ���Ͽ� ���� ���� ����
	 * FileInputStream �ν��Ͻ� �޼���
	 * int read() : ���Ϸκ��� 1byte �о��, �о�� �����Ͱ� ������ -1�� ��ȯ��
	 * 
	 * ���� ������ ����(byte)���� ū ������ ����(char)�� ����ȯ�� ������ �ս��� ����, �� �ݴ��
	 * �ս��� �߻���
	 * 
	 * @throws IOException
	 */
	@Order(1)
	@Test
	void fileViewerTest() throws IOException {
		FileInputStream fis = new FileInputStream("./src/ch15/ex_02_FileInputStream_FileOutputStream/note.txt");
		int data = 0;
		
		while((data = fis.read()) != -1) {
			char c = (char) data; // 1byte -> 2byte, ������ �ս��� ����
			System.out.print(c);
		}
	}
	
	/**
	 * title : FileInputStream/FileOutputStream�� �̿��ؼ� ������ �����ϱ�
	 * FileOutputStream �ν��Ͻ� �޼���
	 * void write(int b) : b���� ���Ͽ� �ۼ���
	 */
	@Order(2)
	@Test
	void fileCopyTest(){
		
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
