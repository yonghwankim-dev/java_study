package ch10.ex_14_simpleDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * "2015년 11월 07"일 -> pasing -> Date -> SimpleDateFormat.format(Date) ->
 * 2015/11/07
 *
 */
public class DateFormatEx3 {

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d = df.parse("2015년 11월 07일");
			System.out.println(df2.format(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	}

}
