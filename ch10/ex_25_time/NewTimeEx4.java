package ch10.ex_25_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

class DayAfterTomorrow implements TemporalAdjuster{

	@Override
	public Temporal adjustInto(Temporal temporal) {
		return temporal.plus(2, ChronoUnit.DAYS);
	}
}

public class NewTimeEx4 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate date = today.with(new DayAfterTomorrow());
		
		p(today);
		p(date);
		p(today.with(TemporalAdjusters.firstDayOfNextMonth())); 		    // 다음달의 첫날
		p(today.with(TemporalAdjusters.firstDayOfMonth()));                 // 이달의 첫날
		p(today.with(TemporalAdjusters.lastDayOfMonth()));                  // 이달의 마지막날
		p(today.with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY)));   // 이 달의 첫번째 화요일
		p(today.with(TemporalAdjusters.lastInMonth(DayOfWeek.TUESDAY)));    // 이 달의 마지막 화요일
		p(today.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY)));       // 제일 최근 이전의 화요일
		p(today.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY))); // 오늘을 포함하여 제일 최근 이전의 화요일
		p(today.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));			// 제일 최근 다음의 화요일
		p(today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));     // 오늘을 포함하여 제일 최근 다음의 화요일
		p(today.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.TUESDAY))); // 이 달의 4번째 화요일
			
	}
	
	public static void p(Object obj) {
		System.out.println(obj);
	}
}
