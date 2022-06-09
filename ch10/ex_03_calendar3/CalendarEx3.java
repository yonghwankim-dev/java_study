package ch10.ex_03_calendar3;

import java.util.Calendar;

public class CalendarEx3 {

	public static void main(String[] args) {
		final int[] TIME_UNIT = {3600, 60, 1};	// 시간단위, 큰 단위를 앞에 놓음
		final String[] TIME_UNIT_NAME = {"시간 ", "분 ", "초 "};
		
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		// time1을 10시 20분 30초로 설정
		time1.set(Calendar.HOUR_OF_DAY, 10); 
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);
		
		// time2을 20시 30분 10초로 설정
		time2.set(Calendar.HOUR_OF_DAY, 20);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);
		
		System.out.println("time1 : " + toString(time1));
		System.out.println("time2 : " + toString(time2));
		
		long diff = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000;
		System.out.println("time1과 time2의 차이는 " + diff + "초입니다.");
		
		String tmp = "";
		for(int i = 0; i < TIME_UNIT.length; i++) {
			tmp += ((diff / TIME_UNIT[i]) + TIME_UNIT_NAME[i]);
			diff %= TIME_UNIT[i];
		}
		System.out.println("time1과 time2의 차이는 " + tmp + "입니다.");
	}
	
	public static String toString(Calendar time) {
		return time.get(Calendar.HOUR_OF_DAY) + "시 " 
	         + time.get(Calendar.MINUTE) + "분 " 
			 + time.get(Calendar.SECOND) + "초";
	}

}
