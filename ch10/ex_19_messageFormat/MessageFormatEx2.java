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
 * MessageFormat의 용도
 * 다수의 데이터를 데이터베이스에 저장하기 위한 Insert문으로 변환하는 경우에 사용할 수 있음
 * 문자열에서 홑따옴표(')를 사용하기 위해서 ''와 같이 표현함
 */
public class MessageFormatEx2 {

	public static void main(String[] args) {
		String tableName = "CUST_INFO";
		String msg = "INSERT INTO " + tableName + " VALUES(''{0}'', ''{1}'', ''{2}'', ''{3}'');";
		
		Object[][] arguments = {{"이지아", "010-123-1234", "27", "11-07"}
							  , {"김프로", "010-123-1235", "28", "12-05"}};
		
		
		for(Object[] arg : arguments) {
			System.out.println(MessageFormat.format(msg, arg));
		}
				
	}
}
