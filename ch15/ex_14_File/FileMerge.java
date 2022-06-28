package ch15.ex_14_File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMerge {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("USAGE : java FileMerge filename");
			System.exit(0);
		}
		
		String mergeFileName = args[0];
		
		try {
			File tempFile = File.createTempFile("~mergetemp", ".tmp");
			tempFile.deleteOnExit();
			
			FileOutputStream fos = new FileOutputStream(tempFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			BufferedInputStream bis = null;
			
			int number = 1;
			
			File f = new File(mergeFileName + "_." + number);
			
			while(f.exists()) {
				f.setReadOnly(); // 작업중에 파일이 변경되지 않도록 한다.
				bis = new BufferedInputStream(new FileInputStream(f));
				
				int data = 0;
				while((data = bis.read()) != -1) {
					bos.write(data);
				}
				
				bis.close();				
			}

			File oldFile = new File(mergeFileName);
			if(oldFile.exists()) {
				oldFile.delete();
			}
			tempFile.renameTo(oldFile);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
