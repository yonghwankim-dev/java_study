package ch15.ex_14_File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * title : ������ ���丮�� ���� ���丮�� ���Ե�, Ȯ���ڰ� 'java', 'txt', 'bak'��
 * ��� ������ ������ �о ������ Ű���尡 ���Ե� ���ε��� ����ϴ� ����
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
			System.out.println("��ȿ���� ���� ���͸��Դϴ�.");
			System.exit(0);
		}
		
		try {
			findInFiles(dir, keyword);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("�� " + found + "���� ���ο��� '" + keyword + "'��/�� �߰��Ͽ����ϴ�.");
	}
	public static void findInFiles(File dir, String keyword) throws IOException {
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()) { // ���丮�ΰ��
				findInFiles(files[i], keyword);
			}else {
				String fileName = files[i].getName();
				String extension = fileName.substring(fileName.lastIndexOf(".")+1);
				extension = "," + extension + ",";
				
				// Ȯ���ڰ� java, txt, bak�� ������ �ʴ� ���
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
