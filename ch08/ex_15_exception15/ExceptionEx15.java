package ch08.ex_15_exception15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * title : ���� ó�� �д�
 * - �� ������ ���ܰ� �߻��� �޼���(createFile)���� ���� ���ܸ� ó���ϵ��� �Ǿ� ����
 * - main �޼���� ���ܰ� �߻��� ����� ���� ����
 */
public class ExceptionEx15 {

	
	public static void main(String[] args) throws IOException{
		// command line���� �Է¹��� ���� �̸����� ���� ������ ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File f = createFile(br.readLine());
		
		System.out.println("������ ���� : " + f);
	}
	
	static File createFile(String fileName) {
		try {
			if(fileName == null || fileName.equals("")) {
				throw new Exception("�����̸��� ��ȿ���� �ʽ��ϴ�.");
			}			
		}catch (Exception e) {
			// fileName�� �������� ���, ���� �̸��� "�������.txt"�� �Ѵ�.
			fileName = "�������.txt";
		}finally {
			File f = new File(fileName);	// File Ŭ����Ÿ�� �ν��Ͻ� ����
			createNewFile(f);				// ������ ��ü�� �̿��ؼ� ������ ����
			return f;
		}

	}
	static void createNewFile(File f) {
		try {
			f.createNewFile();	// ������ ������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
