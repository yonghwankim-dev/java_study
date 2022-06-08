package ch08.ex_16_exception16;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * title : 예외를 전달하여 main 메서드에서 예외를 처리
 * - main 메서드는 예외 발생 사실을 알고 main 메서드 내에서 예외 처리 할 수 있음
 * - 메서드 내에서 자체적으로 해결이 되지 않는 경우의 방식 => 파일 이름이 부적절한 경우 다시 입력을
 * 받아서 넘길 수 있음
 */
public class ExceptionEx16 {

	
	public static void main(String[] args){
		// command line에서 입력받은 값을 이름으로 갖는 파일을 생성함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.print("파일 이름을 입력해주세요 : ");
			try {
				File f = createFile(br.readLine());
				System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다.");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage() + " 다시 입력해 주시기 바랍니다.");
			}
		}
		
	}
	
	static File createFile(String fileName) throws Exception {
		if(fileName == null || fileName.equals("")) {
			throw new Exception("파일이름이 유효하지 않습니다.");
		}
		File f = new File(fileName);
		f.createNewFile();
		return f;
	}

	
}
