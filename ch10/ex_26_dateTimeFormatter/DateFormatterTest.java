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
	 * title : DateTimeFormatter ��¥ ���� ���
	 * 
	 * DateTimeFormatter Ŭ���� �޼���
	 * String DateTimeFormatter.�������ǵ�����.format(LocalDate localDate) 
	 *  : localDate �ν��Ͻ��� �������ǵ� �������� ����ȭ�Ͽ� ���ڿ��� ��ȯ
	 * 
	 * LocalDate �ν��Ͻ� �޼���
	 * String format(DateTimeFormatter dateTimeFormatter)
	 *  : LocalDate �ν��Ͻ��� dateTimeFormatter �ν��Ͻ��� �°� ����ȭ�Ͽ� ���ڿ��� ��ȯ
	 * 
	 * DateTimeFormatter�� ����� ���ǵ� ����
	 * - https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
	 */
	@Order(1)
	@Test
	void DateTimeFormmaterPredefinedFormattersTest() {
		printMethodName("DateTimeFormmaterPredefinedFormattersTest");
		
		LocalDate date = LocalDate.of(2015, 1, 1);
		
		// ��¥ ���� ��� 1 : DateTimeFormatter.format() �޼���
		String yyyymmdd = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
		
		// ��¥ ���� ��� 2 : LocalDate.format() �޼��� 
		String yyyymmdd2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		
		System.out.println(yyyymmdd);  // 2015-01-01
		System.out.println(yyyymmdd2); // 2015-01-01
	}
	
	/**
	 * title : �����Ͽ� ���ӵ� ����ȭ
	 * DateTimeFormatter Ŭ������ ofLocalizedDate(), ofLocalizedTime(), ofLocalizedDateTime()
	 * Ŭ���� �޼���� ������(locale)�� �������� �����͸� �����մϴ�.
	 * 
	 * DateTimeFormatter Ŭ���� �޼���
	 * DateTimeFormatter DateTimeFormatter.ofLocalizedDate(FormatStyle dateStyle)
	 * DateTimeFormatter DateTimeFormatter.ofLocalizedTime(FormatStyle dateStyle)
	 * DateTimeFormatter DateTimeFormatter.ofLocalizedDateTime(FormatStyle dateStyle)
	 * 
	 * FormatStyle�� ���ǵ� ����� ��� ��
	 * FormStyle ��¥                   �ð�
	 * FULL      2015�� 11�� 28�� �����   N/A
	 * LONG      2015�� 11�� 28�� (��)   ���� 9�� 15�� 13��
	 * MEDIUM    2015. 11. 28         ���� 9:15:13 
	 * SHORT     15. 11. 28           ���� 9:15
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
	 * title : ������� ���� �����ϱ� - ofPattern() �޼���
	 * DateTimeFormatter Ŭ���� �޼���
	 * DateTimeFormatter DateTimeFormatter.ofPattern(String pattern)
	 *  : ��¥�� �ð��� ���� ����ȭ�� ���� �����Ͽ� DateTimeFormatter �ν��Ͻ� ��ȯ
	 *  
	 * DateTimeFormatter�� ���Ͽ� ���Ǵ� ��ȣ ���
	 * - https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
	 */
	@Order(3)
	@Test
	void ofPatternMethodTest() {
		printMethodName("ofPatternMethodTest");
		
		ZonedDateTime zdateTime = ZonedDateTime.now();
		
		String[] patternArr = {
				"yyyy-MM-dd HH:mm:ss",
				"''yy�� MMM dd�� E����",
				"yyyy-MM-dd HH:mm:ss.SSS Z VV",
				"yyyy-MM-dd hh:mm:ss a",
				"������ �� ���� D��° ���Դϴ�.",
				"������ �� ���� d��° ���Դϴ�.",
				"������ �� ���� w��° ���Դϴ�.",
				"������ �� ���� W��° ���Դϴ�.",
				"������ �� ���� W��° E�����Դϴ�."
		};
		

		for(String p : patternArr) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(p);
			System.out.println(zdateTime.format(formatter));
		}
//		2022-06-21 13:11:55
//		'22�� 6�� 21�� ȭ����
//		2022-06-21 13:11:55.699 +0900 Asia/Seoul
//		2022-06-21 01:11:55 ����
//		������ �� ���� 172��° ���Դϴ�.
//		������ �� ���� 21��° ���Դϴ�.
//		������ �� ���� 26��° ���Դϴ�.
//		������ �� ���� 4��° ���Դϴ�.
//		������ �� ���� 4��° ȭ�����Դϴ�.
	}
	
	/**
	 * title : ���ڿ��� ��¥�� �ð����� �Ľ��ϱ�
	 * LocalDateTime �ν��Ͻ� �޼���
	 * static LocalDateTime parse(CharSequence text) : �⺻���� �������� �Ľ�
	 * static LocalDateTime parse(CharSequence text, DateTimeFormatter formatter) : ������ �������� �Ľ�
	 * 
	 * LocalDate, LocalTime�� parse() �޼��� ��밡����
	 */
	@Order(4)
	@Test
	void DateTimeFormatterPasingTest() {
		printMethodName("DateTimeFormatterPasingTest");
		
		// DateTimeFormmater�� ����� ���ǵ� ���� ���
		LocalDate date = LocalDate.parse("2016-01-02", DateTimeFormatter.ISO_LOCAL_DATE);
		
		// ���� ���Ǵ� �⺻���� ������ ���ڿ��� ISO_LOCAL_DATE�� ���� ����ȭ ����� ������� �ʰ� �Ľ��� ������
		LocalDate newDate         = LocalDate.parse("2001-01-01");
		LocalTime newTime         = LocalTime.parse("23:59:59");
		LocalDateTime newDateTime = LocalDateTime.parse("2001-01-01T23:59:59");
				
		System.out.println("date        : " + date);        // 2016-01-02
		System.out.println("newDate     : " + newDate);     // 2001-01-01 
		System.out.println("newTime     : " + newTime);     // 23:59:59
		System.out.println("newDateTime : " + newDateTime); // 2001-01-01T23:59:59
	}
}
