package ch10.ex_20_messageFormat;

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
 * 
 */
public class MessageFormatEx3 {

	public static void main(String[] args) {
		String[] data = {"INSERT INTO CUS_INFO VALUES('이지아', '010-123-1234', '27', '11-07');"
				       , "INSERT INTO CUS_INFO VALUES('김프로', '010-123-1235', '28', '12-05');"};
		
		String pattern = "INSERT INTO CUS_INFO VALUES({0}, {1}, {2}, {3});";
		MessageFormat mf = new MessageFormat(pattern);
		
		for(String d : data) {
			try {
				Object[] objs = mf.parse(d);
				for(Object obj : objs) {
					System.out.print(obj + " ");
				}
				System.out.println();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
				
	}
}
