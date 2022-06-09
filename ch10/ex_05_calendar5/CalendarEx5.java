package ch10.ex_05_calendar5;

import java.util.Calendar;

public class CalendarEx5 {

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		
		date.set(2015, Calendar.JANUARY, 31); // 2015년 1월 31일
		System.out.println(toString(date));
		date.roll(Calendar.MONTH, 1);
		// roll로 인하여 2월로 변경되었는데 원래는 일은 영향을 받지는 않지만 2월은 28일까지 있기 때문에 일이 변경됨
		// add도 마찬가지로 다른 일에 영향을 줌
		System.out.println(toString(date));	

	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " 
	        + (date.get(Calendar.MONTH)+1) + "월 "
	        + date.get(Calendar.DATE) + "일 ";
	}

}
