package ch10.ex_23_time_LocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LocalDateTimeEx {
	
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}

	/**
	 * title : LocalDateTime 인스턴스 생성
	 * 방법 1 : of(), now()을 이용한 방법
	 * LocalDateTime.of(int year, int months, int days, int hours, int minutes, int seconds) 
	 *  : 특정 날짜 및 시간을 명시한 LocalDateTime 인스턴스 생성
	 * LocalDateTime.now() : 현재 시간을 가지는 LocalDateTime 인스턴스 생성
	 * 
	 * 방법 2 : LocalDate 인스턴스와 LocalTime 인스턴스를 이용한 방법
	 * LocalDateTime.of(LocalDate localDate, LocalTime localTime) 
	 *  : LocalDate 인스턴스의 날짜와 LocalTime 인스턴스의 시간을 결합하여 LocalDateTime 인스턴스 생성
	 *  
	 * 방법 3 : atTime 메서드
	 * LocalDate 인스턴스 메서드 
	 * LocalDateTime atTime(LocalTime localTime)
	 * LocalDateTime atTime(int hours, int minutes, int seconds)
	 * 
	 * 방법 4 : atDate 메서드
	 * LocalTime 인스턴스 메서드
	 * LocalDateTime atDate(LocalDate localDate)
	 * 
	 * 방법 5 : atStartOfDay()
	 * LocalDate 인스턴스 메서드
	 * LocalDateTime atStartOfDay() : LocalDate를 LocalDateTime으로 변환하고 시/분/초는 0:0:0으로 설정
	 */
	@Order(1)
	@Test
	void localDateTimeCreateTest() {
		printMethodName("localDateTimeCreateTest");
		
		// 1. of(), now()를 이용하여 LocalDateTime 인스턴스 생성
		LocalDateTime dateTime = LocalDateTime.of(2015, 12, 31, 12, 34, 56);
		LocalDateTime today    = LocalDateTime.now();
				
		// 2. LocalDate와 LocalTime을 이용하여 LocalDateTime 인스턴스 생성
		LocalDate date = LocalDate.of(2015, 12, 31);
		LocalTime time = LocalTime.of(12, 34, 56);
		
		LocalDateTime dt1 = LocalDateTime.of(date, time);
		LocalDateTime dt2 = date.atTime(time);
		LocalDateTime dt3 = date.atTime(12, 34, 56);
		LocalDateTime dt4 = time.atDate(date);
		LocalDateTime dt5 = time.atDate(LocalDate.of(2015, 12, 31));
		LocalDateTime dt6 = date.atStartOfDay(); // dt6 = date.atTime(0,0,0);
		
		System.out.println("dateTime : " + dateTime); // 2015-12-31T12:34:56
		System.out.println("today    : " + today);    // 2022-06-16T17:27:08.260516800
		System.out.println("dt1      : " + dt1);      // 2015-12-31T12:34:56
		System.out.println("dt2      : " + dt2);      // 2015-12-31T12:34:56
		System.out.println("dt3      : " + dt3);      // 2015-12-31T12:34:56
		System.out.println("dt4      : " + dt4);      // 2015-12-31T12:34:56
		System.out.println("dt5      : " + dt5);      // 2015-12-31T12:34:56
		System.out.println("dt6      : " + dt6);      // 2015-12-31T00:00
	}
	
	/**
	 * title : LocalDateTime을 LocalDate, LoocalTime으로 변환
	 * LocalDateTime 인스턴스 메서드
	 * - LocalDate toLocalDate() : LocalDateTime을 LocalDate로 변환
	 * - LocalTime toLocalTime() : LocalDateTime을 LocalTime으로 변환
	 */
	@Order(2)
	@Test
	void ConvertLocalDateTimeToLocalDateAndLocalTimeTest() {
		printMethodName("ConvertLocalDateTimeToLocalDateAndLocalTimeTest");
		
		LocalDateTime dt1 = LocalDateTime.of(2015, 1, 1, 12, 0, 0);
		LocalDate localDate = dt1.toLocalDate();
		LocalTime localTime = dt1.toLocalTime();
		
		System.out.println("localDate : " + localDate); // 2015-01-01
		System.out.println("localTime : " + localTime); // 12:00
	}
	
	/**
	 * title : LocalDateTime에 시간대를 추가하여 ZonedDateTime 인스턴스 생성
	 * ZoneId 클래스 메서드
	 * ZoneId ZoneId.of(String zoneId) : 지역아이디를 입력하여 ZoneId 인스턴스 생성
	 * 
	 * 방법 1 :atZone()
	 * LocalDatetime 인스턴스 메서드
	 * ZonedDateTime atZone(ZoneId zoneId) : LocalDateTime 인스턴스에 시간대를 추가하여 ZonedDateTime 인스턴스 생성
	 * 
	 * 방법 2 : atStartOfDay()
	 * LocalDate 인스턴스 메서드
	 * ZonedDateTime atStartOfDay(ZoneId zoneId) : LocalDate 인스턴스에 시간대를 추가하여 ZonedDateTime 인스턴스 생성
	 * 
	 */
	@Order(3)
	@Test
	void addZoneToLocalDateTimeTest() {
		printMethodName("addZoneToLocalDateTimeTest");
		 
		// 1. ZoneId 클래스와 atZone(ZoneId) 메서드 활용
		LocalDateTime date1 = LocalDateTime.of(2015, 1, 1, 0, 0, 0);
		ZoneId zid = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = date1.atZone(zid);
		
		// 2. ZoneId 클래스와 atStartOfDay(ZoneId) 메서드 활용
		LocalDate date2 = LocalDate.of(2015, 1, 1);
		ZoneId zid2 = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt2 = date2.atStartOfDay(zid2);
		
		System.out.println(zdt);  // 2015-01-01T00:00+09:00[Asia/Seoul]
		System.out.println(zdt2); // 2015-01-01T00:00+09:00[Asia/Seoul]
	}
	
	/**
	 * title : ZoneOffset 클래스
	 * ZoneOffset : UTC로부터 얼마나 떨어져 있는지 표현하는 클래스
	 * 
	 * ZoneOffset 인스턴스 메서드
	 * int get(TemporalField field) : UTC로부터 얼마나 떨어져 있는지 특정 시간단위로 반환함
	 */
	@Order(4)
	@Test
	void ZoneOffsetClassTest() {
		printMethodName("ZoneOffsetClassTest");
		
		ZoneOffset krOffset = ZonedDateTime.now().getOffset();
		int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS); // UTC로부터 얼마나 떨어져 있는지 초단위로 반환
		System.out.println(krOffsetInSec + "초"); // 32400초		
	}
	
	/**
	 * title : ZoneId와 ZoneOffset 비교
	 * ZoneId와 ZoneOffset의 차이점
	 * 1. ZoneDateTime는 ZoneId로 구역을 표현
	 * 2. OffsetDateTime는 ZoneOffset을 사용하여 시간의 차이로 UTC와의 시간차를 표현
	 */
	@Order(5)
	@Test
	void OffsetDateTimeClassTest() {
		printMethodName("OffsetDateTimeClassTest");
		
		// OffsetDateTime : ZonedDatetime에 ZoneOffset을 적용하여 시간대를 시간의 차이로만 구분하는 클래스
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		
		ZoneId zid = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = ZonedDateTime.of(date, time, zid); // ZoneId를 이용한 시간대 표현
		
		ZoneOffset krOffset = ZonedDateTime.now().getOffset();
		OffsetDateTime odt = OffsetDateTime.of(date, time, krOffset); // 단순한 시간의 차이로만 표현
		
		System.out.println("zdt : " + zdt); // zdt : 2022-06-16T18:13:27.532193600+09:00[Asia/Seoul]
		System.out.println("odt : " + odt); // odt : 2022-06-16T18:13:27.532193600+09:00		
	}
	
	/**
	 * title : OffsetDateTime 인스턴스를 얻는 2가지 방법
	 * 방법 1. OffsetDateTime.of() 메서드 
	 * OffsetDateTime = LocalDate + LocalTime + ZoneOffset
	 * 
	 * 방법 2. ZonedDateTime.toOffsetDateTime() 메서드
	 * OffsetDateTime = ZonedDateTime.toOffsetDateTime(); 
	 */
	@Order(6)
	@Test
	void createWayOffsetDateTimeTest() {
		printMethodName("createWayOffsetDateTimeTest");
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		ZoneOffset krOffset = ZonedDateTime.now().getOffset();
		

		// 방법 1. OffsetDateTime = LocalDate + LocalTime + ZoneOffset
		OffsetDateTime odt1 = OffsetDateTime.of(date, time, krOffset);
		
		// 방법 2. OffsetDateTime = ZonedDateTime.toOffsetDateTime();
		ZoneId zid = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = ZonedDateTime.of(date, time, zid);
		OffsetDateTime odt2 = zdt.toOffsetDateTime();
		
		System.out.println("odt1 : " + odt1);
		System.out.println("odt2 : " + odt2);
	}
	
	/**
	 * title : ZonedDateTime 클래스의 변환
	 * ZonedDateTime 인스턴스 메서드
	 * LocalDate toLocalDate()           : ZonedDateTime을 LocalDate로 변환
	 * LocalTime toLocalTime() 			 : ZonedDateTime을 LocalTime로 변환
	 * LocalDateTime toLocalDateTime()   : ZonedDateTime을 LocalDateTime으로 변환
	 * OffsetDateTime toOffsetDateTime() : ZonedDateTime을 OffsetDateTime으로 변환
	 * long toEpochSecond() 			 : ZonedDateTime을 '1970-01-01'부터 경과된 시간을 초로 반환
	 * Instant toInstant()               : ZonedDateTime을 Instant로 변환
	 */
	@Order(7)
	@Test
	void ConvertZonedDateTimeTest() {
		printMethodName("ConvertZonedDateTimeTest");
		
		// ZonedDateTime의 변환
		ZonedDateTime z = ZonedDateTime.now();
		
		System.out.println("toLocalDate()      : " + z.toLocalDate());
		System.out.println("toLocalTime()      : " + z.toLocalTime());
		System.out.println("toLocalDateTime()  : " + z.toLocalDateTime());
		System.out.println("toOffsetDateTime() : " + z.toOffsetDateTime());
		System.out.println("toEpochSecond()    : " + z.toEpochSecond());
		System.out.println("toInstant()        : " + z.toInstant());		
	}
}
