package ch15.ex_14_File;

import java.io.File;

/**
 * title : 파일의 이름을 변경하는 예제
 *
 */
public class FileEx9 {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage : java FileEx9 DIRECTORY");
			System.exit(0);
		}
		
		File dir = new File(args[0]);
		
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		
		File[] list = dir.listFiles();
		for(int i = 0; i < list.length; i++) {
			String filename = list[i].getName();
			
			String newFileName = "0000" + filename;
			newFileName = newFileName.substring(newFileName.length() - 7);
			list[i].renameTo(new File(dir, newFileName));
		}
	}
}
