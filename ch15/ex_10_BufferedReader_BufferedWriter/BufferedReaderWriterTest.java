package ch15.ex_10_BufferedReader_BufferedWriter;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class BufferedReaderWriterTest {
	/**
	 * title : BufferedReader�� �̿��Ͽ� ";"�� ������ ������ Ž��
	 * BufferedReader / BufferedWriter�� ���۸� �̿��ؼ� ������� ȿ���� ���ϼ� �ֵ���
	 * ���ִ� ������ ������
	 */
	
	@Test
	void bufferedReaderTest() {
		try(FileReader fr = new FileReader("./src/ch15/ex_10_BufferedReader_BufferedWriter/BufferedReaderWriterTest.java");
				BufferedReader br = new BufferedReader(fr)){
			
			String line = "";
			for(int i = 1; (line = br.readLine()) != null; i++) {
				// ";"�� ������ ������ ����Ѵ�.
				if(line.indexOf(";") != -1) {
					System.out.println(i + ":" + line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
