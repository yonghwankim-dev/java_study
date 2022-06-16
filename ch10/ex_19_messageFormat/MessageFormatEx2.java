package ch10.ex_19_messageFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * MessageFormat�� �뵵
 * �ټ��� �����͸� �����ͺ��̽��� �����ϱ� ���� Insert������ ��ȯ�ϴ� ��쿡 ����� �� ����
 * ���ڿ����� Ȭ����ǥ(')�� ����ϱ� ���ؼ� ''�� ���� ǥ����
 */
public class MessageFormatEx2 {

	public static void main(String[] args) {
		String tableName = "CUST_INFO";
		String msg = "INSERT INTO " + tableName + " VALUES(''{0}'', ''{1}'', ''{2}'', ''{3}'');";
		
		Object[][] arguments = {{"������", "010-123-1234", "27", "11-07"}
							  , {"������", "010-123-1235", "28", "12-05"}};
		
		
		for(Object[] arg : arguments) {
			System.out.println(MessageFormat.format(msg, arg));
		}
				
	}
}
