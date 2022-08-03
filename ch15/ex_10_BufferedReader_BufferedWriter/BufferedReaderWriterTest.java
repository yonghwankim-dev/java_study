package ch15.ex_10_BufferedReader_BufferedWriter;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class BufferedReaderWriterTest {
	/**
	 * title : BufferedReader를 이용하여 ";"를 포함한 라인을 탐색
	 * BufferedReader / BufferedWriter는 버퍼를 이용해서 입출력의 효율을 높일수 있도록
	 * 해주는 역할을 수행함
	 */
	
	@Test
	void bufferedReaderTest() {
		try(FileReader fr = new FileReader("./src/ch15/ex_10_BufferedReader_BufferedWriter/BufferedReaderWriterTest.java");
				BufferedReader br = new BufferedReader(fr)){
			
			String line = "";
			for(int i = 1; (line = br.readLine()) != null; i++) {
				// ";"를 포함한 라인을 출력한다.
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
