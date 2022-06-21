package ch10.ex_26_dateTimeFormatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {
	
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : DateTimeFormatter 날짜 형식 방법
	 * 
	 * DateTimeFormatter 클래스 메서드
	 * String DateTimeFormatter.사전정의된형식.format(LocalDate localDate) 
	 *  : localDate 인스턴스를 사전정의된 형식으로 형식화하여 문자열로 반환
	 * 
	 * LocalDate 인스턴스 메서드
	 * String format(DateTimeFormatter dateTimeFormatter)
	 *  : LocalDate 인스턴스를 dateTimeFormatter 인스턴스에 맞게 형식화하여 문자열로 반환
	 * 
	 * DateTimeFormatter에 상수로 정의된 형식
	 * - https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
	 */
	@Order(1)
	@Test
	void DateTimeFormmaterPredefinedFormattersTest() {
		printMethodName("DateTimeFormmaterPredefinedFormattersTest");
		
		LocalDate date = LocalDate.of(2015, 1, 1);
		
		// 날짜 형식 방법 1 : DateTimeFormatter.format() 메서드
		String yyyymmdd = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
		
		// 날짜 형식 방법 2 : LocalDate.format() 메서드 
		String yyyymmdd2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		
		System.out.println(yyyymmdd);  // 2015-01-01
		System.out.println(yyyymmdd2); // 2015-01-01
	}
	
	/**
	 * title : 로케일에 종속된 형식화
	 * DateTimeFormatter 클래스의 ofLocalizedDate(), ofLocalizedTime(), ofLocalizedDateTime()
	 * 클래스 메서드는 로케일(locale)에 종속적인 포맷터를 생성합니다.
	 * 
	 * DateTimeFormatter 클래스 메서드
	 * DateTimeFormatter DateTimeFormatter.ofLocalizedDate(FormatStyle dateStyle)
	 * DateTimeFormatter DateTimeFormatter.ofLocalizedTime(FormatStyle dateStyle)
	 * DateTimeFormatter DateTimeFormatter.ofLocalizedDateTime(FormatStyle dateStyle)
	 * 
	 * FormatStyle에 정의된 상수와 출력 예
	 * FormStyle 날짜                   시간
	 * FULL      2015년 11월 28일 토요일   N/A
	 * LONG      2015년 11월 28일 (토)   오후 9시 15분 13초
	 * MEDIUM    2015. 11. 28         오후 9:15:13 
	 * SHORT     15. 11. 28           오후 9:15
	 */
	@Order(2)
	@Test
	void localeTest() {
		printMethodName("localeTest");
		LocalDate date = LocalDate.of(2015, 1, 1);
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		String shortFormat = formatter.format(date);
		
		System.out.println(shortFormat); // 15. 1. 1.
	}
	
	/**
	 * title : 출력형식 직접 정의하기 - ofPattern() 메서드
	 * DateTimeFormatter 클래스 메서드
	 * DateTimeFormatter DateTimeFormatter.ofPattern(String pattern)
	 *  : 날짜와 시간에 대한 형식화를 직접 설정하여 DateTimeFormatter 인스턴스 반환
	 *  
	 * DateTimeFormatter의 패턴에 사용되는 기호 목록
	 * - https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
	 */
	@Order(3)
	@Test
	void ofPatternMethodTest() {
		printMethodName("ofPatternMethodTest");
		
		ZonedDateTime zdateTime = ZonedDateTime.now();
		
		String[] patternArr = {
				"yyyy-MM-dd HH:mm:ss",
				"''yy년 MMM dd일 E요일",
				"yyyy-MM-dd HH:mm:ss.SSS Z VV",
				"yyyy-MM-dd hh:mm:ss a",
				"오늘은 올 해의 D번째 날입니다.",
				"오늘은 이 달의 d번째 날입니다.",
				"오늘은 올 해의 w번째 주입니다.",
				"오늘은 이 달의 W번째 주입니다.",
				"오늘은 이 달의 W번째 E요일입니다."
		};
		

		for(String p : patternArr) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(p);
			System.out.println(zdateTime.format(formatter));
		}
//		2022-06-21 13:11:55
//		'22년 6월 21일 화요일
//		2022-06-21 13:11:55.699 +0900 Asia/Seoul
//		2022-06-21 01:11:55 오후
//		오늘은 올 해의 172번째 날입니다.
//		오늘은 이 달의 21번째 날입니다.
//		오늘은 올 해의 26번째 주입니다.
//		오늘은 이 달의 4번째 주입니다.
//		오늘은 이 달의 4번째 화요일입니다.
	}
	
	/**
	 * title : 문자열을 날짜와 시간으로 파싱하기
	 * LocalDateTime 인스턴스 메서드
	 * static LocalDateTime parse(CharSequence text) : 기본적인 형식으로 파싱
	 * static LocalDateTime parse(CharSequence text, DateTimeFormatter formatter) : 지정된 형식으로 파싱
	 * 
	 * LocalDate, LocalTime도 parse() 메서드 사용가능함
	 */
	@Order(4)
	@Test
	void DateTimeFormatterPasingTest() {
		printMethodName("DateTimeFormatterPasingTest");
		
		// DateTimeFormmater에 상수로 정의된 형식 사용
		LocalDate date = LocalDate.parse("2016-01-02", DateTimeFormatter.ISO_LOCAL_DATE);
		
		// 자주 사용되는 기본적인 형식의 문자열은 ISO_LOCAL_DATE와 같은 형식화 상수를 사용하지 않고도 파싱이 가능함
		LocalDate newDate         = LocalDate.parse("2001-01-01");
		LocalTime newTime         = LocalTime.parse("23:59:59");
		LocalDateTime newDateTime = LocalDateTime.parse("2001-01-01T23:59:59");
				
		System.out.println("date        : " + date);        // 2016-01-02
		System.out.println("newDate     : " + newDate);     // 2001-01-01 
		System.out.println("newTime     : " + newTime);     // 23:59:59
		System.out.println("newDateTime : " + newDateTime); // 2001-01-01T23:59:59
	}
}
