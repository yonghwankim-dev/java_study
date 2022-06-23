package ch15.ex_03_BufferedInputStream_BufferedOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class BufferedInputOutputStreamTest {
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : 보조스트림인 BufferedOutputStream을 이용해서 1~9를 파일에 작성하기
	 * BufferedOutputStream의 생성자
	 * BufferedOutputStream(OutputStream, int size) : size 크기의 버퍼를 가지는 버퍼스트림 생성
	 * 
	 * BufferedOutputStream의 인스턴스 메서드
	 * void write(int b) : 버퍼에 b를 저장, 만약 버퍼가 가득찼다면 출력소스에 출력함
	 *  
	 * 실행결과 (123.txt)
	 * 12345
	 * 
	 * Q. 왜 123.txt에는 123456789가 아닌 12345로 저장이 되어 있는가?
	 * BufferedOutputStream의 버퍼는 버퍼가 전부 찼을때만 출력소스에 출력을 하기 때문에
	 * 반복문이 끝나있을때는 12345는 출력되고 BufferedOutputStream의 버퍼에는 6789가 들어있는
	 * 상태에서 기반 스트림인 FileOutputStream이 close되고 종료되었기 때문에
	 * 6789는 출력되지 않고 종료된것입니다.
	 */
	@Order(1)
	@Test
	void bufferedOutputStreamWriteTest() {
		printMethodName("bufferedOutputStreamWriteTest");
		
		try {
			FileOutputStream fos = new FileOutputStream("./src/ch15/ex_03_BufferedInputStream_BufferedOutputStream/123.txt");
			// BufferedOutputStream의 버퍼 크기를 5로한다.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			
			// 파일 123.txt에 1부터 9까지 출력
			for(int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}
			
			fos.close();
		}catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
