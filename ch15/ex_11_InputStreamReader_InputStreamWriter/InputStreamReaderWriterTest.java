package ch15.ex_11_InputStreamReader_InputStreamWriter;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;




public class InputStreamReaderWriterTest {
	/**
	 * title : InputStreamReader를 사용하여 문장 입력받기
	 * InputStreamReader 생성자 / 메서드
	 * InputStreamReader(InputStream in)
	 *  : OS에서 사용하는 기본 인코딩의 문자로 변환하는 InputStreamReader를 생성한다.
	 * InputStreamReader(InputStream in, String encoding)
	 *  : 지정된 인코딩을 사용하는 InputStreamReader를 생성한다.
	 * String getEncdoing() : InputStreamReader의 인코딩을 알려 준다.
	 * 
	 * OutputStreamWriter 생성자 /메서드
	 * OutputStreamWriter(OutputStream out)
	 *  : OS에서 사용하는 기본 인코딩의 문자로 변환하는 OutputStreamWriter를 생성
	 * OutputStreamWriter(OutputStream out, String encoding)
	 *  : 지정된 인코딩을 사용하는 OutputStreamWriter를 생성
	 * String getEncoding()
	 *  : OutputStreamWriter의 인코딩을 알려줌
	 */
	
	@Test
	void InputStreamReaderTest() {
		String line = "";
		try (InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			OutputStreamWriter osw = 
					new OutputStreamWriter(
							new FileOutputStream(
									"./src/ch15/ex_11_InputStreamReader_InputStreamWriter/result.txt"))){
			System.out.println("사용중인 OS의 인코딩 : " + isr.getEncoding());
			
			do {
				System.out.println("문장을 입력하세요. 마치시려면 q를 입력하세요.>");
				line = br.readLine();
				System.out.println("입력하신 문장 : " + line);
				osw.append(line+"\n");
			}while(!line.equalsIgnoreCase("q"));
			
			System.out.println("프로그램을 종료합니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
