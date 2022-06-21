package ch10.ex_22_time_LocalDate_LocalTime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LocalDateLocalTimeTest {
	
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : LocalDate 인스턴스 생성
	 * LocalDate 클래스 메서드
	 * LocalDate LocalDate.now()               : 현재 날짜에 대한 LocalDate 인스턴스 생성
	 * LocalDate LocalDate.of(int year, 
	 *                        int month, 
	 *                        int dayOfMonth)  : 특정 년/월/일을 설정한 LocalDate 인스턴스 생성  
	 */
	@Order(1)
	@Test
	void LocalDateClassTest() {
		printMethodName("LocalDateClassTest");
		
		LocalDate today = LocalDate.now();                  // 오늘 날짜
		LocalDate birthDate = LocalDate.of(1998, 12, 31);	// 1998년 12월 31일
	
		System.out.println("today     : " + today);
		System.out.println("birthDate : " + birthDate);
	}
	
	/**
	 * title : LocalTime 인스턴스 생성
	 * LocalTime 클래스 메서드
	 * LocalTime LocalTime.now()          : 현재 시간을 가지는 LocalTime 인스턴스 생성
	 * LocalTime LocalTime.of(int hour, 
	 *                        int minute, 
	 *                        int second) : 특정 시/분/초를 설정한 LocalTime 인스턴스 생성
	 *                        
	 * LocalTime 인스턴스 메서드
	 * LocalTime truncatedTo(TemporalUnit field) : 특정 시간단위보다 작은 단위를 0으로 만든다음 반환
	 */
	@Order(2)
	@Test
	void LocalTimeClassTest() {
		printMethodName("LocalTimeClassTest");
		
		LocalTime now = LocalTime.now();	                // 현재 시간
		LocalTime birthTime = LocalTime.of(23, 59, 59);		// 23시 59분 59초
					
		System.out.println("now         : "   + now);	    // 12:33:35.859165600
		System.out.println("birthTime   : "   + birthTime); // 23:59:59
		System.out.println("truncatedTo : "                
		                 + birthTime.truncatedTo(ChronoUnit.HOURS)); // 23:00 
	}
	
	/**
	 * title : LocalDate 클래스의 withYear, plusDays, plus 메서드
	 * LocalDate 인스턴스 메서드
	 * LocalDate withYear(int year)                        : LocalDate 인스턴스의 년도 필드만을 변경하여 반환
	 * LocalDate plusDays(long daysToAdd)                  : LocalDate 인스턴스에 일자를 더하여 반환
	 * LocalDate plus(long amountToAdd, TemporalUnit unit) : 특정 날짜단위만큼 더하여 반환
	 */
	@Order(3)
	@Test
	void LocalDateMethodTest() {
		printMethodName("LocalDateMethodTest");
		
		LocalDate birthDate = LocalDate.of(1995, 12, 31);
		
		System.out.println(birthDate.withYear(2000));			// 2000-12-31
		System.out.println(birthDate.plusDays(1));				// 1996-01-01
		System.out.println(birthDate.plus(1, ChronoUnit.DAYS)); // 1996-01-01
	}
	
	/**
	 * title : ChronoField enum의 범위 확인
	 * ChronoField.상수목록.range() : 상수목록에 해당하는 범위 반환
	 * 
	 * ChronoField 상수목록
	 * - https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoField.html
	 */
	@Order(4)
	@Test
	void checkChronoFieldRangeTest() {
		System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range()); // 1-24
		System.out.println(ChronoField.HOUR_OF_DAY.range());	   // 0-23		
	}
	
	/**
	 * title : 날짜와 시간의 비교 - isAfter(), isBefore(), isEqual()
	 * LocalDate 인스턴스 메서드
	 * boolean isAfter(ChronoLocalDate other)  : 인자보다 앞서면 true, 오래되면 false
	 * boolean isBefore(ChronoLocalDate other) : 인자보다 앞서면 false, 오래되면 true
	 * boolean isEqual(ChronoLocalDate other)  : 인자와 같으면 true
	 * 
	 * LocalTime 인스턴스 메서드
	 * boolean isAfter(ChronoLocalTime other)  : 인자보다 앞서면 true, 오래되면 false
	 * boolean isBefore(ChronoLocalTime other) : 인자보다 앞서면 false, 오래되면 true
	 * boolean isEqual(ChronoLocalTime other)  : 인자와 같으면 true
	 * 
	 * equals()가 있는데도 isEqual()을 제공하는 이유
	 * - 연표(chronology)가 다른 두 날짜를 비교하기 위해서임
	 * - equals()는 모든 필드가 일치해야함
	 * - isEqual()은 오직 날짜만을 비교함
	 */
	@Order(5)
	@Test
	void compareLocalDateAndLocalTimeTest() {
		printMethodName("compareLocalDateAndLocalTimeTest");
		
		LocalDate date1 = LocalDate.of(2000, 1, 1);
		LocalDate date2 = LocalDate.of(2001, 12, 31);
		
		LocalTime time1 = LocalTime.of(1, 30);
		LocalTime time2 = LocalTime.of(3, 30);
		
		LocalDate kDate    = LocalDate.of(1999, 12, 31);
		JapaneseDate jDate = JapaneseDate.of(1999, 12, 31);
		
		System.out.println("date1.isAfter() : " + date1.isAfter(date2));	// false
		System.out.println("date1.isBefore() : " + date1.isBefore(date2));  // true
		System.out.println("date1.isEqual() : " + date1.isEqual(date2));    // false
		
		System.out.println("time1.isAfter() : " + time1.isAfter(time2));    // false
		System.out.println("time1.isBefore() : " + time1.isBefore(time2));	// true
		
		System.out.println("kDate.equals(jDate) : " + kDate.equals(jDate));  // false, YEAR_OF_EAR가 다름
		System.out.println("kDateisEqual(jDate) : " + kDate.isEqual(jDate)); // true
	}
}
