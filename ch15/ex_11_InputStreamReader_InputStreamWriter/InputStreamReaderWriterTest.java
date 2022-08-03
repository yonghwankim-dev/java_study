package ch15.ex_11_InputStreamReader_InputStreamWriter;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;




public class InputStreamReaderWriterTest {
	/**
	 * title : InputStreamReader�� ����Ͽ� ���� �Է¹ޱ�
	 * InputStreamReader ������ / �޼���
	 * InputStreamReader(InputStream in)
	 *  : OS���� ����ϴ� �⺻ ���ڵ��� ���ڷ� ��ȯ�ϴ� InputStreamReader�� �����Ѵ�.
	 * InputStreamReader(InputStream in, String encoding)
	 *  : ������ ���ڵ��� ����ϴ� InputStreamReader�� �����Ѵ�.
	 * String getEncdoing() : InputStreamReader�� ���ڵ��� �˷� �ش�.
	 * 
	 * OutputStreamWriter ������ /�޼���
	 * OutputStreamWriter(OutputStream out)
	 *  : OS���� ����ϴ� �⺻ ���ڵ��� ���ڷ� ��ȯ�ϴ� OutputStreamWriter�� ����
	 * OutputStreamWriter(OutputStream out, String encoding)
	 *  : ������ ���ڵ��� ����ϴ� OutputStreamWriter�� ����
	 * String getEncoding()
	 *  : OutputStreamWriter�� ���ڵ��� �˷���
	 */
	
	@Test
	void InputStreamReaderTest() {
		String line = "";
		try (InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			OutputStreamWriter osw = 
					new OutputStreamWriter(
							new FileOutputStream(
									"./src/ch15/ex_11_InputStreamReader_InputStreamWriter/result.txt"))){
			System.out.println("������� OS�� ���ڵ� : " + isr.getEncoding());
			
			do {
				System.out.println("������ �Է��ϼ���. ��ġ�÷��� q�� �Է��ϼ���.>");
				line = br.readLine();
				System.out.println("�Է��Ͻ� ���� : " + line);
				osw.append(line+"\n");
			}while(!line.equalsIgnoreCase("q"));
			
			System.out.println("���α׷��� �����մϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
