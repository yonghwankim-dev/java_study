package ch15.ex_14_File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * title : 지정한 디렉토리와 서브 디렉토리에 포함된, 확장자가 'java', 'txt', 'bak'인
 * 모든 파일의 내용을 읽어서 지정한 키워드가 포함된 라인들을 출력하는 예제
 */
public class FileEx6 {
	static int found = 0;
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("USAGE : java FileEx6 DIRECTORY KEYWORD");
			System.exit(0);
		}
		
		File dir = new File(args[0]);
		String keyword = args[1];
		
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉터리입니다.");
			System.exit(0);
		}
		
		try {
			findInFiles(dir, keyword);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("총 " + found + "개의 라인에서 '" + keyword + "'을/를 발견하였습니다.");
	}
	public static void findInFiles(File dir, String keyword) throws IOException {
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()) { // 디렉토리인경우
				findInFiles(files[i], keyword);
			}else {
				String fileName = files[i].getName();
				String extension = fileName.substring(fileName.lastIndexOf(".")+1);
				extension = "," + extension + ",";
				
				// 확장자가 java, txt, bak에 속하지 않는 경우
				if(",java,txt,bak,".indexOf(extension) == -1) {
					continue;
				}
				
				fileName = dir.getAbsolutePath() + File.separator + fileName;
				
				FileReader fr     = new FileReader(files[i]);
				BufferedReader br = new BufferedReader(fr);
				
				String data = "";
				int lineNum = 0;
				
				while((data = br.readLine()) != null) {
					lineNum++;
					
					if(data.indexOf(keyword) != -1) {
						found++;
						System.out.println("[" + fileName + "(" + lineNum + ")]" + data);
						
					}
				} // while
				br.close();
			}
		} // for
	}// findInFiles
}// class
