package ch10.ex_13_simpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * SimpleDateFormat.format(java.util.Date)
 * Calendar -> Date -> SimpleDateFormat.format(Date)
 *
 */
public class DateFormatEx2 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 9, 3);	// 2005년 10월 3일
		
		Date day = cal.getTime();
		
		SimpleDateFormat[] sdfs = new SimpleDateFormat[4];
		
		sdfs[0] = new SimpleDateFormat("yyyy-MM-dd");
		sdfs[1] = new SimpleDateFormat("yy-MM-dd E요일");
		sdfs[2] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdfs[3] = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		for(SimpleDateFormat sdf : sdfs) {
			System.out.println(sdf.format(day));
		}
	}

}
