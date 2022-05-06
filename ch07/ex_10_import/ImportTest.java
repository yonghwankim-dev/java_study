package ch07.ex_10_import;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * import문 선언	
 */
public class ImportTest {
	public static void main(String[] args)
	{
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss a");
		
		System.out.println("오늘 날짜는 " + date.format(today));
		System.out.println("현재 시간은 " + time.format(today));
	}
}
