package ch15.ex_14_File;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class FileTest {
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	/**
	 * title : File �ν��Ͻ��� �޼��� �׽�Ʈ
	 * References
	 * https://docs.oracle.com/javase/8/docs/api/java/io/File.html
	 * @throws IOException
	 */
	@Order(1)
	@Test
	void fileClassTest() throws IOException {
		printMethodName("fileClassTest");
		
		File f = new File("C:/Users/qkdlf/Study/Language/java_lang/[����] Java�� ����/java/src/ch15/ex_14_File/FileTest.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");
		
		System.out.println("��θ� ������ �����̸�   	: " + f.getName());
		System.out.println("Ȯ���ڸ� ������ �����̸�  	: " + fileName.substring(0, pos));
		System.out.println("Ȯ����				: " + fileName.substring(pos));
		
		System.out.println("��θ� ������ ���� �̸� 	: " + f.getPath());
		System.out.println("������ ������         	: " + f.getAbsolutePath());
		System.out.println("������ ���԰��         	: " + f.getCanonicalPath());
		System.out.println("������ ���� �ִ� ���丮  	: " + f.getParent());
		System.out.println();
		
		System.out.println("File.pathSeparator 	: " + File.pathSeparator);
		System.out.println("File.separatorChar 	: " + File.separatorChar);
		System.out.println();
		
		System.out.println("user.dir           	: " + System.getProperty("user.dir"));	
		System.out.println("sun.boot.class.path	: " + System.getProperty("sun.boot.class.path"));
	}
	
	/**
	 * title : ������ ���͸��� ���Ե� ���ϰ� ���丮�� ����� �����ִ� ����
	 */
	@Order(2)
	@Test
	void showFilesAndDirectoryTest() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		try {
			System.out.print("���� �̸��� �Է� : ");
			String fileName = br.readLine();
			
			File f = new File(fileName);
			
			// ������ �������� �ʰų� ���丮�� �ƴ� ���, ����
			if(!f.exists() || !f.isDirectory()) {
				System.out.println("��ȿ���� ���� ���͸��Դϴ�.");
				System.exit(0);
			}
			
			File[] files = f.listFiles(); // ���͸��� ���ϸ��(���丮 ����)�� File �迭�� ��ȯ
			
			for(File file : files) {
				String fileNm = file.getName();
				System.out.println(file.isDirectory() ? "["+fileNm+"]" : fileNm);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	static int totalFiles = 0;
	static int totalDirs  = 0;
	
	/**
	 * title : ���� ���丮�� �׿� ���Ե� ���ϰ� ���͸��� ��ϱ��� �����ִ� ����
	 */
	@Order(3)
	@Test
	void showFilesAndSubDirectoryTest() {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.print("���͸� ��θ� �Է����ּ��� : ");
			String fileName = br.readLine();
			File dir = new File(fileName);
			
			// �������� �ʰų� ���丮�� �ƴ� ���
			if(!dir.exists() || !dir.isDirectory()) {
				System.out.println("��ȿ���� ���� ���͸��Դϴ�.");
				System.exit(0);
			}
			
			printFileList(dir);
			
			System.out.println();
			System.out.println("�� " + totalFiles + "���� ����");
			System.out.println("�� " + totalDirs  + "���� ���丮");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void printFileList(File dir) {
		System.out.println(dir.getAbsolutePath() + " ���丮");
		File[] files = dir.listFiles();
		
		List<String> subDir = new ArrayList<String>();
		
		for(int i = 0; i < files.length; i++) {
			String fileName = files[i].getName();
			
			if(files[i].isDirectory()) {
				fileName = "[" + fileName + "]";
				subDir.add(i+"");
			}
			System.out.println(fileName);
		}
		
		int dirNum = subDir.size(); // ���͸� ����
		int fileNum = files.length - dirNum;
		
		totalFiles += fileNum;
		totalDirs  += dirNum;
		
		System.out.println(fileNum + "���� ����, " + dirNum + "���� ���丮");
		System.out.println();
		
		for(int i = 0; i < subDir.size(); i++) {
			int index = Integer.parseInt((String)subDir.get(i));
			printFileList(files[index]);
		}
	}
	
	/**
	 * title : ���� ���丮�� ���� ���ϰ� ���丮�� �̸��� ũ�� �� �� ������ �����ִ� ����
	 */
	@Order(4)
	@Test
	void showDetailInfoTest(){
		printMethodName("showDetailInfoTest");
		String curDir = System.getProperty("user.dir");
		File dir = new File(curDir);
		
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mma");
			String attribute = "";
			String size = "";
			
			if(files[i].isAbsolute()) {
				attribute = "DIR";
			}else {
				size = f.length() + "";
				attribute =  f.canRead() ? "R" : " ";
				attribute += f.canWrite() ? "W" : " ";
				attribute += f.isHidden() ? "H" : " ";
			}
			
			System.out.printf("%s %3s %6s %s\n"
								, sdf.format(new Date(f.lastModified()))
								, attribute
								, size
								, name);			
		}
	}	
	

	
}
