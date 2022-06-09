package ch10.ex_02_calendar2;

import java.util.Calendar;

public class CalendarEx2 {
	public static void main(String[] args) {
		// 요일은 1부터 시작하기 때문에, DAY_OF_WEEK[0]은 비워두었습니다.
		final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		// month의 경우 0부터 시작하기 때문에 8월의 경우 7로 지정해야함
		date1.set(2015, Calendar.AUGUST, 15);
		//date1.set(2015, 7, 15);
		System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일");
		System.out.println("date2은 " + toString(date2) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일");
		
		// 두 날짜간의 차이를 얻으려면, getTimeInMillis() 천분의 일초 단위로 변환해야 한다.
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println("date1부터 date2까지 " + difference + "초가 지났습니다.");
		System.out.println("일(day)로 계산하면 " + difference / (24*60*60) + "일입니다.");	// 1일 = 24 * 60 * 60
		
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " 
	        + (date.get(Calendar.MONTH)+1) + "월 "
	        + date.get(Calendar.DATE) + "일 ";
	}
}
