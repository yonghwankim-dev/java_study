package ch08.ex_15_exception15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * title : 예외 처리 분담
 * - 이 예제는 예외가 발생한 메서드(createFile)에서 직접 예외를 처리하도록 되어 있음
 * - main 메서드는 예외가 발생한 사실을 알지 못함
 */
public class ExceptionEx15 {

	
	public static void main(String[] args) throws IOException{
		// command line에서 입력받은 값을 이름으로 갖는 파일을 생성함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File f = createFile(br.readLine());
		
		System.out.println("생성한 파일 : " + f);
	}
	
	static File createFile(String fileName) {
		try {
			if(fileName == null || fileName.equals("")) {
				throw new Exception("파일이름이 유효하지 않습니다.");
			}			
		}catch (Exception e) {
			// fileName이 부적절한 경우, 파일 이름을 "제목없음.txt"로 한다.
			fileName = "제목없음.txt";
		}finally {
			File f = new File(fileName);	// File 클래스타입 인스턴스 생성
			createNewFile(f);				// 생성된 객체를 이용해서 파일을 생성
			return f;
		}

	}
	static void createNewFile(File f) {
		try {
			f.createNewFile();	// 파일을 생성함
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
