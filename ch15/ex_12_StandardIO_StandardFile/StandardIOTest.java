package ch15.ex_12_StandardIO_StandardFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class StandardIOTest {
	/**
	 * title : 표준인 입력인 System.in을 사용하여 입력받은 문장을 출력하기
	 * System.in  : InputStream 타입
	 * System.out : PrintStream 타입
	 * System.err : PrintStream 타입 
	 * 
	 * System.in 인스턴스 메서드
	 * int System.in.read() : 사용자로부터 콘솔을 통해서 문장을 최대 255까지 입력받음
	 *                        Enter 키 누를시 '\r'(캐리지리턴), '\n'이 같이 입력됨
	 *                        이를 보완하기 위해서 BufferedReader를 이용함
	 */
	@Order(1)
	@Test
	void systemInTest() {
		try {
			int input = 0;
			
			while((input = System.in.read()) != -1) {
				System.out.println("input : " + input + ", (char) input : " + (char) input);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * title : 기본 입출력 대상은 콘솔
	 * System.in(InputStream), System.out(PrintStream), System.err(PrintStream)
	 * 의 기본 입출력대상은 콘솔(console)입니다.
	 * 
	 */
	@Order(2)
	@Test
	void outputTargetIsConsoleTest() {
		System.out.println("out : Hello World!");
		System.err.println("err : Hello World!");
	}
	
	/**
	 * title : setOut(PrintStream)을 사용하여 표준 출력 대상을 FileOutputStream으로 변경
	 * 
	 * static void setOut(PrintStream out) : System.out의 출력을 지정된 PrintStream으로 변경
	 * static void setErr(PrintStream err) : System.err의 출력을 지정된 PrintStream으로 변경
	 * static void setIn(InputStream in)   : System.in의 입력을 지정한 InputStream으로 변경
	 */
	@Order(3)
	@Test
	void setOutMethodTest() {
		String filePath = "./src/ch15/ex_12_StandardIO_StandardFile/test.txt";
		try(FileOutputStream fos = new FileOutputStream(filePath);
			PrintStream ps = new PrintStream(fos)) {
			System.setOut(ps);
			
			System.out.println("Hello by System.out");
			System.err.println("Hello by System.err");
		}catch (FileNotFoundException e) {
			System.err.println("File not found.");
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
}
