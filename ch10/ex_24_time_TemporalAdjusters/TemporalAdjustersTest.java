package ch10.ex_24_time_TemporalAdjusters;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

class DayAfterTomorrow implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		return temporal.plus(2, ChronoUnit.DAYS);
	}
}

public class TemporalAdjustersTest {

	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	public static void p(Object obj) {
		System.out.println(obj);
	}

	/**
	 * title TemporalAdjusters 클래스의 메서드 테스트
	 * TemporalAdjusters 클래스의 정적 메소드
	 * - TemporalAdjuster firstDayOfNextMonth()            : 다음달의 첫날
	 * - TemporalAdjuster firstDayOfMonth()                : 이번달의 첫날
	 * - TemporalAdjuster lastDayOfMonth()                 : 이번달의 마지막날
	 * - TemporalAdjuster firstInMonth(DayOfWeek)          : 이 달의 첫번째 요일
	 * - TemporalAdjuster lastInMonth(DayOfWeek)           : 이 달의 마지막 요일
	 * - TemporalAdjuster previous(DayOfWeek)              : 이전의 요일
	 * - TemporalAdjuster previousOrSame(DayOfWeek)        : 이전의 요일 (당일 포함)
	 * - TemporalAdjuster next(DayOfWeek)                  : 다음의 요일
	 * - TemporalAdjuster nextOrSame(DayOfWeek)            : 다음의 요일 (당일 포함)
	 * - TemporalAdjuster dayOfWeekInMonth(int, DayOfWeek) : 이번달의 n번째 요일
	 */
	@Test
	void temporalAdjustersClassTest() {
		LocalDate today = LocalDate.of(2022, 06, 20);
		LocalDate date = today.with(new DayAfterTomorrow()); // TemporalAdjusters 직접 구현
		
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
	
}
