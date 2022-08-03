package ch10.ex_25_time_Period_Duration;


import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDurationTest {
	
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : Period.between() �޼���
	 * Period.between(LocalDate date1, LocalDate date2)
	 * - �� ��¥���� ���̸� ����Ͽ� Period �ν��Ͻ��� �����մϴ�.
	 * 
	 * Period.getYears()  : �⵵�� ����
	 * Period.getMonths() : ���� ����
	 * Period.getDays()   : ���ڸ� ���� 
	 */
	@Test
	void PeriodBetweenMethodTest() {
		printMethodName("PeriodBetweenMethodTest");
		
		LocalDate date1 = LocalDate.of(2014, 1, 1);
		LocalDate date2 = LocalDate.of(2015, 12, 31);
		
		Period pe = Period.between(date1, date2);

		System.out.println("date1=" + date1);
		System.out.println("date2=" + date2);
		System.out.println("pe=" + pe); // P1Y11M30D : 1�� 11�� 30�� ����
		
		// ��/��/�� �ʵ带 �����ϴ� ��� 1 : getYears(), getMonths(), getDays() �޼��� ȣ��
		System.out.println("YEAR=" + pe.getYears());
		System.out.println("MONTH=" + pe.getMonths());
		System.out.println("DAY=" + pe.getDays());
		
		// ��/��/�� �ʵ带 �����ϴ� ��� 2 : get(TemporalUnit) �޼��� ȣ��
		System.out.println("YEAR=" + pe.get(ChronoUnit.YEARS));
		System.out.println("MONTH=" + pe.get(ChronoUnit.MONTHS));
		System.out.println("DAY=" + pe.get(ChronoUnit.DAYS));
	}
	
	/**
	 * title : Duration.between �޼���
	 * Duration.between(LocalTime time1, LocalTime time2)
	 * - �� �ð����� ���̸� ����Ͽ� Duration �ν��Ͻ��� �����մϴ�.
	 * 
	 * Duration Ŭ���� Ư¡
	 * 1. Period Ŭ�����ʹ� �޸� �ð������� ��(getSeconds() / getNano())�ۿ� ����
	 */
	@Test
	void DurationBetweenMethodTest() {
		printMethodName("DurationBetweenMethodTest");
		
		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(12, 23, 56); // 12�ð� 23�� 56��
		
		Duration du = Duration.between(time1, time2);
		
		System.out.println("time1=" + time1); // 00:00
		System.out.println("time2=" + time2); // 12:23:56
		System.out.println("du=" + du);       // PT12H23M56S : 12�ð� 23�� 56�� ����
		
		// ��/������ �ʵ带 �����ϴ� ��� 1 : getSeconds(), getNano() �޼��� ȣ��
		System.out.println("SECONDS=" + du.getSeconds());
		System.out.println("NANOS=" + du.getNano());
		
		// ��/������ �ʵ带 �����ϴ� ��� 2 : get(TemporalUnit) �޼��� ȣ��
		System.out.println("SECONDS=" + du.get(ChronoUnit.SECONDS));
		System.out.println("NANOS=" + du.get(ChronoUnit.NANOS));		
	}
	
	/**
	 * title : Period�� Duration Ŭ������ �ð����� Ȯ��
	 * - List<TemporalUnit> Period.getUnits() : Period �ν��Ͻ��� ������ �ִ� �ð������� ����Ʈ ���·� ��ȯ��
	 * - List<TemporalUnit> Duration.getUnits() : Duration �ν��Ͻ��� ������ �ִ� �ð� ������ ����Ʈ ���·� ��ȯ��
	 * 
	 * Period�� Duration �ð� ���� Ư¡
	 * - Period Ŭ������ �ð� ������ ��/��/���� ������ �ֱ� ������ getYears(), getMonths(),
	 * getDays()�� ���� �޼��带 ȣ���Ͽ� ��/��/�ϸ��� ������ �� ����
	 * - �ݸ� Duration Ŭ������ �ð� ������ ��/������ ���� ������ �ֱ� ������ getHours(),
	 * getMinutes()�� ���� �޼��带 ȣ���� �� ����
	 */
	@Test
	void PeriodAndDurationUnitsCheckTest() {
		printMethodName("PeriodAndDurationUnitsCheckTest");
		
		LocalDate date1 = LocalDate.of(2014, 1, 1);
		LocalDate date2 = LocalDate.of(2015, 12, 31);
		Period pe = Period.between(date1, date2);
		
		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(12, 23, 56);
		Duration du = Duration.between(time1, time2);
		
		// Period�� Duration ���� Ȯ��
		System.out.println("Period Unit   : " + pe.getUnits()); // [Years, Months, Days]
		System.out.println("Duration Unit : " + du.getUnits()); // [Seconds, Nanos]
	}
	
	/**
	 * title : Duration �ν��Ͻ��� ��/��/��/������ ���
	 * ��� ��� 1 : getSeconds(), getNano() �޼��带 ���� ��/��/��/������ ���
	 * ��� ��� 2 : Duration �ν��Ͻ��� LocalTime �ν��Ͻ��� ��ȯ�Ͽ� get �޼��� ȣ�� 
	 */
	@Test
	void DurationCalHourMinuteTest() {
		printMethodName("DurationCalHourMinuteTest");
		
		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(12, 23, 56); // 12�ð� 23�� 56��
		Duration du = Duration.between(time1, time2);
		
		// Duration �ν��Ͻ��� ��/��/��/������ ��� ��� 1 : 
		// Duration.getSeconds(), Duration.getNano()�� Ȱ���� ��/��/��/������ ���
		long hour = du.getSeconds() / 3600;
		long min  = (du.getSeconds() - hour*3600) / 60;
		long sec  = (du.getSeconds() - hour*3600 - min*60) % 60;
		int nano  = du.getNano();
		System.out.printf("%02d:%02d:%02d.000%d\n", hour, min, sec, nano); // 12:23:56.0000
		
		// Duration �ν��Ͻ��� ��/��/��/������ ��� ��� 2 :
		// Duration �ν��Ͻ��� LocalTime���� ��ȯ�Ͽ� get �޼��带 ȣ��
		LocalTime tmpTime = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
		System.out.println("HOUR=" + tmpTime.getHour());
		System.out.println("MINUTE=" + tmpTime.getMinute());
		System.out.println("SECOND=" + tmpTime.getSecond());
		System.out.println("NANO=" + tmpTime.getNano());
	}
	
	/**
	 * title : LocalDate.until(ChrnoLocalDate endDateExclusive) �޼���
	 * - Period.between() �޼��� ���Ұ� ����� ������
	 * - Period.between()�� LocalDate.until() �������� between()�� ����(static) �޼����̰�
	 * until()�� �ν��Ͻ� �޼�����
	 * - �ι�° ���ڿ� ��¥����(TemporalUnit)�� �����Ͽ� ��� ��¥ ������������ ����� �� ����
	 */
	@Test
	void PeriodUntilMethodTest() {
		printMethodName("PeriodUntilMethodTest");
		
		LocalDate today = LocalDate.of(2022, 06, 20);
		LocalDate birthday = LocalDate.of(2022, 11, 07);
		
		Period p1 = today.until(birthday);
		System.out.println(p1); // P4M18D(4��+18��)
		
		long dday = today.until(birthday, ChronoUnit.DAYS);
		System.out.println(dday); // 140	
	}
	
	/**
	 * title : LocalTime.until() �޼���
	 * - LocalTime.until(Temporal endExclusive, TemporalUnit unit)
	 * LocalTime �ν��Ͻ����� �ð� ���̸� ����մϴ�.
	 */
	@Test
	void DurationUntilMethodTest() {
		printMethodName("DurationUntilMethodTest");
		
		LocalTime time1 = LocalTime.of(12, 0, 0);
		LocalTime time2 = LocalTime.of(3, 0, 0);
		
		// LocalTime.until() �޼��� ���
		long sec = time1.until(time2, ChronoUnit.SECONDS);
		
		System.out.println(sec); // -32400��
	}
	
	/**
	 * title : Period.of() �޼���
	 * Period.of(int years, int months, int days) : Ư�� ��/��/���� �����Ͽ� Period �ν��Ͻ� ����
	 * Period.ofYears(int years)                  : Ư�� �⵵�� �����Ͽ� Period �ν��Ͻ� ����
	 * Period.ofMonths(int months)                : Ư�� ���� �����Ͽ� Period �ν��Ͻ� ����
	 * Period.ofWeeks(int weeks)                  : Ư�� n�ָ� �����Ͽ� Period �ν��Ͻ� ����, 1��=7��
	 * Period.ofDays(int days)                    : Ư�� ���� �����Ͽ� Period �ν��Ͻ� ����
	 */
	@Test
	void PeriodOfMethodTest() {
		printMethodName("PeriodOfMethodTest");
		
		Period p1y12m31d = Period.of(1, 12, 31); // 1�� 12���� 31�� ����
		Period p1y = Period.ofYears(1);          // 1�� ����
		Period p1m = Period.ofMonths(1);         // 1�� ����
		Period p7d = Period.ofWeeks(1);          // ������ ����
		Period p30d = Period.ofDays(30);         // 30�� ����
		System.out.println(p1y12m31d);			 // P1Y12M31D
		System.out.println(p1y);				 // P1Y
		System.out.println(p1m);				 // P1M
		System.out.println(p7d);				 // P7D
		System.out.println(p30d);				 // P30D		
	}
	
	/**
	 * title : Duration.of() �޼���
	 * Duration.of(long amount, TemporalUnit unit) : Ư�� �ð�������ŭ ���̸� ������ Duration �ν��Ͻ� ����
	 * Duration.ofDays(long days)                  : days�ϸ�ŭ ���̸� ������ Duration �ν��Ͻ� ����
	 * Duration.ofHours(long hours)                : hours�ð���ŭ ���̸� ������ Duration �ν��Ͻ� ����
	 * Duration.ofMinutes(long minuts)             : minutes�и�ŭ ���̸� ������ Duration �ν��Ͻ� ����
	 * Duration.ofSeconds(long seconds)            : seconds�ʸ�ŭ ���̸� ������ Duration �ν��Ͻ� ����
	 * Duration.ofNanos(long nanos)                : nanos�ʸ�ŭ ���̸� ������ Duration �ν��Ͻ� ����
	 */
	@Test
	void DurationOfMethodTest() {
		printMethodName("DurationOfMethodTest");
		
		// Duration.of() �޼��� ��� ��� 1 : Duration.of(long amount, TemporalUnit unit) ȣ��
		Duration pt1m = Duration.of(60, ChronoUnit.SECONDS); // 60��
		
		// Duration.of() �޼��� ��� ��� 2 : ofXXX() ȣ��
		Duration pt168h = Duration.ofDays(7);    // 7��
		Duration pt7h = Duration.ofHours(7);     // 7�ð�
		Duration pt7m = Duration.ofMinutes(7);   // 7��
		Duration pt7s = Duration.ofSeconds(7);   // 7��
		Duration pt7nano = Duration.ofNanos(7);  // 7������
		
		System.out.println(pt1m);    // PT1M 
		System.out.println(pt168h);  // PT168H
		System.out.println(pt7h);    // PT7H
		System.out.println(pt7m);    // PT7M
		System.out.println(pt7s);    // PT7S
		System.out.println(pt7nano); // PT0.000000007S
	}

	/**
	 * title : Period.with() �޼���
	 * Period withYears(int years)   : Period �ν��Ͻ��� �⵵ �ʵ常 ����
	 * Period withMonths(int months) : Period �ν��Ͻ��� �� �ʵ常�� ����
	 * Period withDays(int days)     : Period �ν��Ͻ��� ���� �ʵ常�� ���� 
	 */
	@Test
	void PeriodWithMethodTest() {
		printMethodName("PeriodWithMethodTest");
		
		Period pe = Period.of(1, 6, 10);
		Period periodWithYear2  = pe.withYears(2);
		Period periodWithMonth1 = pe.withMonths(1);
		Period periodWithDay1   = pe.withDays(1);

		System.out.println(pe);					// P1Y6M10D
		System.out.println(periodWithYear2);    // P2Y6M10D
		System.out.println(periodWithMonth1);   // P1Y1M10D
		System.out.println(periodWithDay1);     // P1Y6M1D
	}
	
	/**
	 * title : Duration.with() �޼���
	 * Duration withSeconds(int seconds) : Duration �ν��Ͻ��� �� �ʵ常�� ����
	 * Duration withNanos(int nanos)     : Duration �ν��Ͻ��� ������ �ʵ常�� ����
	 */
	@Test
	void DurationWithMethodTest() {
		printMethodName("DurationWithMethodTest");
		
		Duration du = Duration.of(120, ChronoUnit.SECONDS);
		
		Duration durationWithSecond60 = du.withSeconds(60);
		Duration durationWithNano60   = du.withNanos(60);
		
		System.out.println(du);					  // PT2M
		System.out.println(durationWithSecond60); // PT1M
		System.out.println(durationWithNano60);   // PT2M0.00000006S
	}
	
	/**
	 *title : Period Ŭ���� ��Ģ���� �޼���
	 * Period minus(TemporalAmount amountToSuctract) : Ư�� ��¥������ŭ ���� 
	 * Period minusYears(long yearsToSuctract)       : Ư�� �⵵����ŭ ����
	 * Period minusMonths(long monthsToSubtract)     : Ư�� ����ŭ ����
	 * Period minusDays(long daysToSubtract)         : Ư�� ���ڸ�ŭ ����
	 * Period multipliedBy(int scaler)               : scaler ����ŭ ��¥�� ����    
	 */
	@Test
	void PeriodArithmeticOperationMethodTest() {
		printMethodName("PeriodArithmeticOperationMethodTest");
		
		Period pe = Period.of(1, 6, 10);
		
		pe = pe.minusYears(1).multipliedBy(2); // 1���� ���� 2�踦 ����
		System.out.println(pe);
	}
	
	/**
	 * title : Duration Ŭ���� ��Ģ���� �޼���
	 * Duration plus(Duration duration) : Duration �ν��Ͻ���ŭ ���̸� ����
	 * Duration plus(long amountToAdd, TemporalUnit unit) : Ư�� �ð�������ŭ ����
	 * Duration plusHours(long hoursToAdd)                : �ð� ����
	 * Duration plusMinutes(long minutsToAdd)             : �� ����
	 * Duration plusSeconds(long secondsToAdd)            : �� ����
	 * Duration plusMillis(long millisToAdd)              : �и��� ����
	 * Duration plusNanos(long nanosToAdd)                : ������ ����
	 * Duration multipliedBy(int scaler)                  : scaler��ŭ ����
	 * Duration divideBy(long divisor)                    : divisor��ŭ ����
	 */
	@Test
	void DurationArithmeticOperationMethodTest() {
		printMethodName("PeriodAndDurationIsZeroAndIsNegativeMethodTest");
		
		Duration du = Duration.of(120, ChronoUnit.SECONDS);
		
		du = du.plus(Duration.of(1, ChronoUnit.HOURS));
		du = du.plus(1, ChronoUnit.HOURS);
		du = du.plusHours(1);
		du = du.plusMinutes(1);
		du = du.plusSeconds(1);
		du = du.plusMillis(1);
		du = du.plusNanos(1);
		du = du.multipliedBy(1);
		du = du.dividedBy(1);
		System.out.println(du);
	}
	
	/**
	 * title : Period, Duration�� isZero(), isNegative() �޼���
	 * boolean isZero() : �� ��¥�� ���̰� 0���� �˻�
	 * boolean isNegative() : �������� �˻� 
	 */
	@Test
	void PeriodAndDurationIsZeroAndIsNegativeMethodTest() {
		printMethodName("PeriodAndDurationIsZeroAndIsNegativeMethodTest");
		
		LocalDate today = LocalDate.of(2022, 06, 20);
		LocalDate birthday = LocalDate.of(2022, 11, 07);
		boolean sameDate = Period.between(today, birthday).isZero(); 
		
		LocalTime time1 = LocalTime.of(12, 0, 0);
		LocalTime time2 = LocalTime.of(3, 0, 0);
		boolean sameTime = Duration.between(time1, time2).isNegative(); 
		System.out.println(sameDate); // false
		System.out.println(sameTime); // true
	}
	
	/**
	 * title : Period.normalized() �޼���
	 * Period normalized() : ���� ���� 12�� �ѱ��� �ʰ� �⵵�� �Ѱ��ִ� ���
	 */
	@Test
	void PeriodNormalizedMethodTest() {
		printMethodName("PeriodNormalizedMethodTest");
		
		Period pe1 = Period.of(1, 13, 32);
		Period pe2 = Period.of(1, 13, 32).normalized();
		
		System.out.println(pe1); // P1Y13M32D
		System.out.println(pe2); // P2Y1M32D
	}
	
	/**
	 * title : Period & Duration �ٸ� ������ ��ȯ
	 * Period �ν��Ͻ� �޼���
	 * long toTotalMonths() : ������� �������� ��ȯ�ؼ� ��ȯ (�� ������ ����)
	 * 
	 * Duration �ν��Ͻ� �޼���
	 * long toDays()        : �ϴ����� ��ȯ�ؼ� ��ȯ
	 * long toHours()       : �ð� ������ ��ȯ�ؼ� ��ȯ
	 * long toMinutes()     : �� ������ ��ȯ�ؼ� ��ȯ
	 * long toMillis()      : �и��� ������ ��ȯ�ؼ� ��ȯ
	 * long toNanos()       : ������ ������ ��ȯ�ؼ� ��ȯ
	 */
	@Test
	void PeriodAndDurationToMethodTest() {
		printMethodName("PeriodAndDurationToMethodTest");
		
		Period pe = Period.of(1, 6, 30);	// 1�� 6���� 30�� ����
		long months = pe.toTotalMonths();
		
		Duration du = Duration.of(1, ChronoUnit.DAYS);
		long days = du.toDays();
		long hours = du.toHours();
		long minutes = du.toMinutes();
		long seconds = du.getSeconds();
		long millis = du.toMillis();
		long nanos = du.toNanos();
		
		System.out.println("months : " + months +"����");
		System.out.println("days : " + days + "��");
		System.out.println("hours : " + hours + "�ð�");
		System.out.println("minutes : " + minutes + "��");
		System.out.println("seconds : " + seconds + "��");
		System.out.println("millis : " + millis + "�и���");
		System.out.println("nanos : " + nanos);		
	}
	
	/**
	 * title : LocalDate �ν��Ͻ����� toEpochDay() �޼��带 �̿��� ��¥ ���� ���
	 * LocalDate �ν��ͽ� �޼���
	 * long toEpochDay() : '1970-01-01'���� LocalDate �ν��Ͻ��� ��¥������ ���ڸ� ��� ��ȯ
	 */
	@Test
	void LocalDateToEpochDayMethodTest() {
		printMethodName("LocalDateToEpochDayMethodTest");
		
		LocalDate date1 = LocalDate.of(2015, 1, 1);
		LocalDate date2 = LocalDate.of(2017, 1, 1);
		
		long period = date2.toEpochDay() - date1.toEpochDay();
		
		System.out.printf("%s�� %s�� ���̴� %d��\n", date1, date2, period);
	}
}

