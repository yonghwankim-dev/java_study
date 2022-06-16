package ch10.ex_18_messageFormat;

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
 * MessageFormat : �����͸� ������ ��Ŀ� �°� ����� �� �ֵ��� ������
 * ���ڿ����� {����}�� �־� �Ű������� ���� �ڸ��� �����մϴ�. (0���� ����)
 */
public class MessageFormatEx1 {

	public static void main(String[] args) {
		String msg = "Name: {0} \nTel: {1} \nAge: {2} \nBirthday: {3}";
		
		Object[] arguments = {"���ں�", "02-123-1234", "27", "07-09"};
		
		String result = MessageFormat.format(msg, arguments);
		System.out.println(result);
	}
}
