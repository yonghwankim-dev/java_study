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
	 * title : LocalDateTime �ν��Ͻ� ����
	 * ��� 1 : of(), now()�� �̿��� ���
	 * LocalDateTime.of(int year, int months, int days, int hours, int minutes, int seconds) 
	 *  : Ư�� ��¥ �� �ð��� ����� LocalDateTime �ν��Ͻ� ����
	 * LocalDateTime.now() : ���� �ð��� ������ LocalDateTime �ν��Ͻ� ����
	 * 
	 * ��� 2 : LocalDate �ν��Ͻ��� LocalTime �ν��Ͻ��� �̿��� ���
	 * LocalDateTime.of(LocalDate localDate, LocalTime localTime) 
	 *  : LocalDate �ν��Ͻ��� ��¥�� LocalTime �ν��Ͻ��� �ð��� �����Ͽ� LocalDateTime �ν��Ͻ� ����
	 *  
	 * ��� 3 : atTime �޼���
	 * LocalDate �ν��Ͻ� �޼��� 
	 * LocalDateTime atTime(LocalTime localTime)
	 * LocalDateTime atTime(int hours, int minutes, int seconds)
	 * 
	 * ��� 4 : atDate �޼���
	 * LocalTime �ν��Ͻ� �޼���
	 * LocalDateTime atDate(LocalDate localDate)
	 * 
	 * ��� 5 : atStartOfDay()
	 * LocalDate �ν��Ͻ� �޼���
	 * LocalDateTime atStartOfDay() : LocalDate�� LocalDateTime���� ��ȯ�ϰ� ��/��/�ʴ� 0:0:0���� ����
	 */
	@Order(1)
	@Test
	void localDateTimeCreateTest() {
		printMethodName("localDateTimeCreateTest");
		
		// 1. of(), now()�� �̿��Ͽ� LocalDateTime �ν��Ͻ� ����
		LocalDateTime dateTime = LocalDateTime.of(2015, 12, 31, 12, 34, 56);
		LocalDateTime today    = LocalDateTime.now();
				
		// 2. LocalDate�� LocalTime�� �̿��Ͽ� LocalDateTime �ν��Ͻ� ����
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
	 * title : LocalDateTime�� LocalDate, LoocalTime���� ��ȯ
	 * LocalDateTime �ν��Ͻ� �޼���
	 * - LocalDate toLocalDate() : LocalDateTime�� LocalDate�� ��ȯ
	 * - LocalTime toLocalTime() : LocalDateTime�� LocalTime���� ��ȯ
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
	 * title : LocalDateTime�� �ð��븦 �߰��Ͽ� ZonedDateTime �ν��Ͻ� ����
	 * ZoneId Ŭ���� �޼���
	 * ZoneId ZoneId.of(String zoneId) : �������̵� �Է��Ͽ� ZoneId �ν��Ͻ� ����
	 * 
	 * ��� 1 :atZone()
	 * LocalDatetime �ν��Ͻ� �޼���
	 * ZonedDateTime atZone(ZoneId zoneId) : LocalDateTime �ν��Ͻ��� �ð��븦 �߰��Ͽ� ZonedDateTime �ν��Ͻ� ����
	 * 
	 * ��� 2 : atStartOfDay()
	 * LocalDate �ν��Ͻ� �޼���
	 * ZonedDateTime atStartOfDay(ZoneId zoneId) : LocalDate �ν��Ͻ��� �ð��븦 �߰��Ͽ� ZonedDateTime �ν��Ͻ� ����
	 * 
	 */
	@Order(3)
	@Test
	void addZoneToLocalDateTimeTest() {
		printMethodName("addZoneToLocalDateTimeTest");
		 
		// 1. ZoneId Ŭ������ atZone(ZoneId) �޼��� Ȱ��
		LocalDateTime date1 = LocalDateTime.of(2015, 1, 1, 0, 0, 0);
		ZoneId zid = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = date1.atZone(zid);
		
		// 2. ZoneId Ŭ������ atStartOfDay(ZoneId) �޼��� Ȱ��
		LocalDate date2 = LocalDate.of(2015, 1, 1);
		ZoneId zid2 = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt2 = date2.atStartOfDay(zid2);
		
		System.out.println(zdt);  // 2015-01-01T00:00+09:00[Asia/Seoul]
		System.out.println(zdt2); // 2015-01-01T00:00+09:00[Asia/Seoul]
	}
	
	/**
	 * title : ZoneOffset Ŭ����
	 * ZoneOffset : UTC�κ��� �󸶳� ������ �ִ��� ǥ���ϴ� Ŭ����
	 * 
	 * ZoneOffset �ν��Ͻ� �޼���
	 * int get(TemporalField field) : UTC�κ��� �󸶳� ������ �ִ��� Ư�� �ð������� ��ȯ��
	 */
	@Order(4)
	@Test
	void ZoneOffsetClassTest() {
		printMethodName("ZoneOffsetClassTest");
		
		ZoneOffset krOffset = ZonedDateTime.now().getOffset();
		int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS); // UTC�κ��� �󸶳� ������ �ִ��� �ʴ����� ��ȯ
		System.out.println(krOffsetInSec + "��"); // 32400��		
	}
	
	/**
	 * title : ZoneId�� ZoneOffset ��
	 * ZoneId�� ZoneOffset�� ������
	 * 1. ZoneDateTime�� ZoneId�� ������ ǥ��
	 * 2. OffsetDateTime�� ZoneOffset�� ����Ͽ� �ð��� ���̷� UTC���� �ð����� ǥ��
	 */
	@Order(5)
	@Test
	void OffsetDateTimeClassTest() {
		printMethodName("OffsetDateTimeClassTest");
		
		// OffsetDateTime : ZonedDatetime�� ZoneOffset�� �����Ͽ� �ð��븦 �ð��� ���̷θ� �����ϴ� Ŭ����
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		
		ZoneId zid = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = ZonedDateTime.of(date, time, zid); // ZoneId�� �̿��� �ð��� ǥ��
		
		ZoneOffset krOffset = ZonedDateTime.now().getOffset();
		OffsetDateTime odt = OffsetDateTime.of(date, time, krOffset); // �ܼ��� �ð��� ���̷θ� ǥ��
		
		System.out.println("zdt : " + zdt); // zdt : 2022-06-16T18:13:27.532193600+09:00[Asia/Seoul]
		System.out.println("odt : " + odt); // odt : 2022-06-16T18:13:27.532193600+09:00		
	}
	
	/**
	 * title : OffsetDateTime �ν��Ͻ��� ��� 2���� ���
	 * ��� 1. OffsetDateTime.of() �޼��� 
	 * OffsetDateTime = LocalDate + LocalTime + ZoneOffset
	 * 
	 * ��� 2. ZonedDateTime.toOffsetDateTime() �޼���
	 * OffsetDateTime = ZonedDateTime.toOffsetDateTime(); 
	 */
	@Order(6)
	@Test
	void createWayOffsetDateTimeTest() {
		printMethodName("createWayOffsetDateTimeTest");
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		ZoneOffset krOffset = ZonedDateTime.now().getOffset();
		

		// ��� 1. OffsetDateTime = LocalDate + LocalTime + ZoneOffset
		OffsetDateTime odt1 = OffsetDateTime.of(date, time, krOffset);
		
		// ��� 2. OffsetDateTime = ZonedDateTime.toOffsetDateTime();
		ZoneId zid = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = ZonedDateTime.of(date, time, zid);
		OffsetDateTime odt2 = zdt.toOffsetDateTime();
		
		System.out.println("odt1 : " + odt1);
		System.out.println("odt2 : " + odt2);
	}
	
	/**
	 * title : ZonedDateTime Ŭ������ ��ȯ
	 * ZonedDateTime �ν��Ͻ� �޼���
	 * LocalDate toLocalDate()           : ZonedDateTime�� LocalDate�� ��ȯ
	 * LocalTime toLocalTime() 			 : ZonedDateTime�� LocalTime�� ��ȯ
	 * LocalDateTime toLocalDateTime()   : ZonedDateTime�� LocalDateTime���� ��ȯ
	 * OffsetDateTime toOffsetDateTime() : ZonedDateTime�� OffsetDateTime���� ��ȯ
	 * long toEpochSecond() 			 : ZonedDateTime�� '1970-01-01'���� ����� �ð��� �ʷ� ��ȯ
	 * Instant toInstant()               : ZonedDateTime�� Instant�� ��ȯ
	 */
	@Order(7)
	@Test
	void ConvertZonedDateTimeTest() {
		printMethodName("ConvertZonedDateTimeTest");
		
		// ZonedDateTime�� ��ȯ
		ZonedDateTime z = ZonedDateTime.now();
		
		System.out.println("toLocalDate()      : " + z.toLocalDate());
		System.out.println("toLocalTime()      : " + z.toLocalTime());
		System.out.println("toLocalDateTime()  : " + z.toLocalDateTime());
		System.out.println("toOffsetDateTime() : " + z.toOffsetDateTime());
		System.out.println("toEpochSecond()    : " + z.toEpochSecond());
		System.out.println("toInstant()        : " + z.toInstant());		
	}
}
