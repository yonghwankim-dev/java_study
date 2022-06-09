package ch10.ex_08_calendar8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/**
 * 문자열로 입력받은 년월간의 개월수 차이를 구함
 *
 */
public class CalendarEx8 {

	public static void main(String[] args) {
		String date1 = "201508";
		String date2 = "201405";
		
		// 년과 월을 substring으로 잘라서 정수로 변환
		// 년에 12을 곱해서 월로 변환한 다음에 뺄셈을 하면 개월치를 구할수 있다.
		int month1 = Integer.parseInt(date1.substring(0, 4))*12 +
					 Integer.parseInt(date1.substring(4));
		int month2 = Integer.parseInt(date2.substring(0, 4))*12 +
				 Integer.parseInt(date2.substring(4));
		
		System.out.println(date1 + "과 " + date2 +"의 차이는 " + Math.abs(month1-month2) + "개월입니다.");
	}

}
