package ch10.ex_24_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class NewTimeEx3 {
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2014, 1, 1);
		LocalDate date2 = LocalDate.of(2015, 12, 31);
		
		Period pe = Period.between(date1, date2);
		
		System.out.println("date1=" + date1);
		System.out.println("date2=" + date2);
		System.out.println("pe=" + pe); // P1Y11M30D : 1년 11월 30일 차이
		
		System.out.println("YEAR=" + pe.getYears());
		System.out.println("MONTH=" + pe.getMonths());
		System.out.println("DAY=" + pe.getDays());
		
		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(12, 23, 56); // 12시간 23분 56초
		
		Duration du = Duration.between(time1, time2);
		
		System.out.println("time1=" + time1);
		System.out.println("time2=" + time2);
		System.out.println("du=" + du); // PT12H23M56S : 12시간 23분 56초 차이
		
		LocalTime tmpTime = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
		
		System.out.println("HOUR=" + tmpTime.getHour());
		System.out.println("MINUTE=" + tmpTime.getMinute());
		System.out.println("SECOND=" + tmpTime.getSecond());
		System.out.println("NANO=" + tmpTime.getNano());		
	}
}
