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
 * MessageFormat : 데이터를 정해진 양식에 맞게 출력할 수 있도록 도와줌
 * 문자열에서 {숫자}를 넣어 매개변수가 넣을 자리를 지정합니다. (0부터 시작)
 */
public class MessageFormatEx1 {

	public static void main(String[] args) {
		String msg = "Name: {0} \nTel: {1} \nAge: {2} \nBirthday: {3}";
		
		Object[] arguments = {"이자비", "02-123-1234", "27", "07-09"};
		
		String result = MessageFormat.format(msg, arguments);
		System.out.println(result);
	}
}
