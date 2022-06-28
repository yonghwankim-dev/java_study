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
	 * title : File 인스턴스의 메서드 테스트
	 * References
	 * https://docs.oracle.com/javase/8/docs/api/java/io/File.html
	 * @throws IOException
	 */
	@Order(1)
	@Test
	void fileClassTest() throws IOException {
		printMethodName("fileClassTest");
		
		File f = new File("C:/Users/qkdlf/Study/Language/java_lang/[도서] Java의 정석/java/src/ch15/ex_14_File/FileTest.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");
		
		System.out.println("경로를 제외한 파일이름   	: " + f.getName());
		System.out.println("확장자를 제외한 파일이름  	: " + fileName.substring(0, pos));
		System.out.println("확장자				: " + fileName.substring(pos));
		
		System.out.println("경로를 포함한 파일 이름 	: " + f.getPath());
		System.out.println("파일의 절대경로         	: " + f.getAbsolutePath());
		System.out.println("파일의 정규경로         	: " + f.getCanonicalPath());
		System.out.println("파일이 속해 있는 디렉토리  	: " + f.getParent());
		System.out.println();
		
		System.out.println("File.pathSeparator 	: " + File.pathSeparator);
		System.out.println("File.separatorChar 	: " + File.separatorChar);
		System.out.println();
		
		System.out.println("user.dir           	: " + System.getProperty("user.dir"));	
		System.out.println("sun.boot.class.path	: " + System.getProperty("sun.boot.class.path"));
	}
	
	/**
	 * title : 지정한 디렉터리에 포함된 파일과 디렉토리의 목록을 보여주는 예제
	 */
	@Order(2)
	@Test
	void showFilesAndDirectoryTest() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		try {
			System.out.print("파일 이름을 입력 : ");
			String fileName = br.readLine();
			
			File f = new File(fileName);
			
			// 파일이 존재하지 않거나 디렉토리가 아닌 경우, 종료
			if(!f.exists() || !f.isDirectory()) {
				System.out.println("유효하지 않은 디렉터리입니다.");
				System.exit(0);
			}
			
			File[] files = f.listFiles(); // 디렉터리의 파일목록(디렉토리 포함)을 File 배열로 반환
			
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
	 * title : 서브 디렉토리와 그에 포함된 파일과 디렉터리의 목록까지 보여주는 예제
	 */
	@Order(3)
	@Test
	void showFilesAndSubDirectoryTest() {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.print("디렉터리 경로를 입력해주세요 : ");
			String fileName = br.readLine();
			File dir = new File(fileName);
			
			// 존재하지 않거나 디렉토리가 아닌 경우
			if(!dir.exists() || !dir.isDirectory()) {
				System.out.println("유효하지 않은 디렉터리입니다.");
				System.exit(0);
			}
			
			printFileList(dir);
			
			System.out.println();
			System.out.println("총 " + totalFiles + "개의 파일");
			System.out.println("총 " + totalDirs  + "개의 디렉토리");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void printFileList(File dir) {
		System.out.println(dir.getAbsolutePath() + " 디렉토리");
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
		
		int dirNum = subDir.size(); // 디렉터리 갯수
		int fileNum = files.length - dirNum;
		
		totalFiles += fileNum;
		totalDirs  += dirNum;
		
		System.out.println(fileNum + "개의 파일, " + dirNum + "개의 디렉토리");
		System.out.println();
		
		for(int i = 0; i < subDir.size(); i++) {
			int index = Integer.parseInt((String)subDir.get(i));
			printFileList(files[index]);
		}
	}
	
	/**
	 * title : 현재 딛렉토리에 속한 파일과 디렉토리의 이름과 크기 등 상세 정보를 보여주는 예제
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
