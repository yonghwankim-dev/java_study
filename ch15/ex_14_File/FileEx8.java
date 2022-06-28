package ch15.ex_14_File;

import java.io.File;

/**
 * title : 지정된 디렉토리와 하위 디렉토리에 있는 파일 중에서
 * 지정된 확장자를 가진 파일을 delete()를 호출해서 삭제하는 예제
 *
 */
public class FileEx8 {
	static int deletedFiles = 0;
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("USAGE : java FileEx8 Extension");
			System.exit(0);
		}
		
		String currDir = System.getProperty("user.dir");
		
		File dir = new File(currDir);
		String ext = "." + args[0];
		
		delete(dir, ext);
		System.out.println(deletedFiles + "개의 파일이 삭제되었습니다.");
	}
	

	public static void delete(File dir, String ext) {
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()) {
				delete(files[i], ext);
			}else {
				String filename = files[i].getAbsolutePath();
				
				if(filename.endsWith(ext)) {
					System.out.print(filename);
					if(files[i].delete()) {
						System.out.println(" - 삭제 성공");
						deletedFiles++;
					}else {
						System.out.println(" - 삭제 실패");
					}
				}
			}
		}
	}
}
