package ch10.ex_21_messageFormat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;

/**
 * ���� �����ڴ� �޸� �����Ͱ� ����Ǹ� �Ź� �迭�� �������� �ʾƵ� �˴ϴ�.
 * ������ ����ǵ� �ٽ� �������� �ʿ䰡 �����ϴ�.
 */
public class MessageFormatEx4 {

	public static void main(String[] args) throws IOException {
		String tableName = "CUST_INFO";
		String fileName = "data4.txt";
		String msg = "INSERT INTO " + tableName + " VALUES({0}, {1}, {2}, {3});";
		
		BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
		
		String pattern = "{0}, {1}, {2}, {3}";
		MessageFormat mf = new MessageFormat(pattern);
		String line = null;
		while((line = br.readLine()) != null) {
			
			try {
				Object[] objs = mf.parse(line);
				System.out.println(MessageFormat.format(msg, objs));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}				
	}
}
