package ch15.ex_14_File;

import java.io.File;
import java.io.FilenameFilter;

/**
 * title : FilenameFilter를 구현해서 특정조건에 맞는 파일의 목록을 얻는 예제
 *
 */
public class FileEx7 {
	static String pattern = null;
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("USAGE : java FileEx7 pattern");
			System.exit(0);
		}
		
		String currDir = System.getProperty("user.dir");
		
		File dir = new File(currDir);
		pattern = args[0];
		
		findInFiles(dir);	
	}
	
	public static FilenameFilter getFilenameFilter() {
		return new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.indexOf(pattern) != -1;
			}
		};
	}
	
	public static void printFiles(String[] files) {
		for(int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
	}
	
	public static void findInFiles(File dir) {
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()) {
				printFiles(files[i].list(getFilenameFilter()));
				findInFiles(files[i]);
			}
		}
	}

}
