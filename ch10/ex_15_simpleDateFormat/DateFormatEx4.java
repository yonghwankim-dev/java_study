package ch10.ex_15_simpleDateFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 화면으로부터 날짜를 입력받아서 금일(today)과의 시간차이를 구하는 예제
 *
 */
public class DateFormatEx4 {

	public static void main(String[] args) {
		final String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Date inDate = null;
		
		System.out.print("날짜를 " + pattern + "의 형태로 입력해주세요. (입력예:2015/12/31)");
		while(true) {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
				inDate = df.parse(br.readLine());
				break;
			} catch (ParseException | IOException e) {
				System.out.println("날짜를 " + pattern + "의 형태로 다시 입력해주세요. (입력예:2015/12/31)");
			}	
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(inDate);
		Calendar today = Calendar.getInstance();
		long day = Math.abs((cal.getTimeInMillis() - today.getTimeInMillis()) / (60*60*1000));
		System.out.println("입력하신 날짜는 현재와 " + day + "시간 차이가 있습니다."); 
		
		
	}

}
