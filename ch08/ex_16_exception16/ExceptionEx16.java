package ch08.ex_16_exception16;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * title : ���ܸ� �����Ͽ� main �޼��忡�� ���ܸ� ó��
 * - main �޼���� ���� �߻� ����� �˰� main �޼��� ������ ���� ó�� �� �� ����
 * - �޼��� ������ ��ü������ �ذ��� ���� �ʴ� ����� ��� => ���� �̸��� �������� ��� �ٽ� �Է���
 * �޾Ƽ� �ѱ� �� ����
 */
public class ExceptionEx16 {

	
	public static void main(String[] args){
		// command line���� �Է¹��� ���� �̸����� ���� ������ ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.print("���� �̸��� �Է����ּ��� : ");
			try {
				File f = createFile(br.readLine());
				System.out.println(f.getName() + "������ ���������� �����Ǿ����ϴ�.");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage() + " �ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
			}
		}
		
	}
	
	static File createFile(String fileName) throws Exception {
		if(fileName == null || fileName.equals("")) {
			throw new Exception("�����̸��� ��ȿ���� �ʽ��ϴ�.");
		}
		File f = new File(fileName);
		f.createNewFile();
		return f;
	}

	
}
