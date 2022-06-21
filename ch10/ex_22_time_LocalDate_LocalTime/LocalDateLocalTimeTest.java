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
	 * title : LocalDate �ν��Ͻ� ����
	 * LocalDate Ŭ���� �޼���
	 * LocalDate LocalDate.now()               : ���� ��¥�� ���� LocalDate �ν��Ͻ� ����
	 * LocalDate LocalDate.of(int year, 
	 *                        int month, 
	 *                        int dayOfMonth)  : Ư�� ��/��/���� ������ LocalDate �ν��Ͻ� ����  
	 */
	@Order(1)
	@Test
	void LocalDateClassTest() {
		printMethodName("LocalDateClassTest");
		
		LocalDate today = LocalDate.now();                  // ���� ��¥
		LocalDate birthDate = LocalDate.of(1998, 12, 31);	// 1998�� 12�� 31��
	
		System.out.println("today     : " + today);
		System.out.println("birthDate : " + birthDate);
	}
	
	/**
	 * title : LocalTime �ν��Ͻ� ����
	 * LocalTime Ŭ���� �޼���
	 * LocalTime LocalTime.now()          : ���� �ð��� ������ LocalTime �ν��Ͻ� ����
	 * LocalTime LocalTime.of(int hour, 
	 *                        int minute, 
	 *                        int second) : Ư�� ��/��/�ʸ� ������ LocalTime �ν��Ͻ� ����
	 *                        
	 * LocalTime �ν��Ͻ� �޼���
	 * LocalTime truncatedTo(TemporalUnit field) : Ư�� �ð��������� ���� ������ 0���� ������� ��ȯ
	 */
	@Order(2)
	@Test
	void LocalTimeClassTest() {
		printMethodName("LocalTimeClassTest");
		
		LocalTime now = LocalTime.now();	                // ���� �ð�
		LocalTime birthTime = LocalTime.of(23, 59, 59);		// 23�� 59�� 59��
					
		System.out.println("now         : "   + now);	    // 12:33:35.859165600
		System.out.println("birthTime   : "   + birthTime); // 23:59:59
		System.out.println("truncatedTo : "                
		                 + birthTime.truncatedTo(ChronoUnit.HOURS)); // 23:00 
	}
	
	/**
	 * title : LocalDate Ŭ������ withYear, plusDays, plus �޼���
	 * LocalDate �ν��Ͻ� �޼���
	 * LocalDate withYear(int year)                        : LocalDate �ν��Ͻ��� �⵵ �ʵ常�� �����Ͽ� ��ȯ
	 * LocalDate plusDays(long daysToAdd)                  : LocalDate �ν��Ͻ��� ���ڸ� ���Ͽ� ��ȯ
	 * LocalDate plus(long amountToAdd, TemporalUnit unit) : Ư�� ��¥������ŭ ���Ͽ� ��ȯ
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
	 * title : ChronoField enum�� ���� Ȯ��
	 * ChronoField.������.range() : �����Ͽ� �ش��ϴ� ���� ��ȯ
	 * 
	 * ChronoField ������
	 * - https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoField.html
	 */
	@Order(4)
	@Test
	void checkChronoFieldRangeTest() {
		System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range()); // 1-24
		System.out.println(ChronoField.HOUR_OF_DAY.range());	   // 0-23		
	}
	
	/**
	 * title : ��¥�� �ð��� �� - isAfter(), isBefore(), isEqual()
	 * LocalDate �ν��Ͻ� �޼���
	 * boolean isAfter(ChronoLocalDate other)  : ���ں��� �ռ��� true, �����Ǹ� false
	 * boolean isBefore(ChronoLocalDate other) : ���ں��� �ռ��� false, �����Ǹ� true
	 * boolean isEqual(ChronoLocalDate other)  : ���ڿ� ������ true
	 * 
	 * LocalTime �ν��Ͻ� �޼���
	 * boolean isAfter(ChronoLocalTime other)  : ���ں��� �ռ��� true, �����Ǹ� false
	 * boolean isBefore(ChronoLocalTime other) : ���ں��� �ռ��� false, �����Ǹ� true
	 * boolean isEqual(ChronoLocalTime other)  : ���ڿ� ������ true
	 * 
	 * equals()�� �ִµ��� isEqual()�� �����ϴ� ����
	 * - ��ǥ(chronology)�� �ٸ� �� ��¥�� ���ϱ� ���ؼ���
	 * - equals()�� ��� �ʵ尡 ��ġ�ؾ���
	 * - isEqual()�� ���� ��¥���� ����
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
		
		System.out.println("kDate.equals(jDate) : " + kDate.equals(jDate));  // false, YEAR_OF_EAR�� �ٸ�
		System.out.println("kDateisEqual(jDate) : " + kDate.isEqual(jDate)); // true
	}
}
