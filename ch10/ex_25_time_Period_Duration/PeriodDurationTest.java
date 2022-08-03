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
	 * title : Period.between() 메서드
	 * Period.between(LocalDate date1, LocalDate date2)
	 * - 두 날짜간의 차이를 계산하여 Period 인스턴스를 생성합니다.
	 * 
	 * Period.getYears()  : 년도를 추출
	 * Period.getMonths() : 월을 추출
	 * Period.getDays()   : 일자를 추출 
	 */
	@Test
	void PeriodBetweenMethodTest() {
		printMethodName("PeriodBetweenMethodTest");
		
		LocalDate date1 = LocalDate.of(2014, 1, 1);
		LocalDate date2 = LocalDate.of(2015, 12, 31);
		
		Period pe = Period.between(date1, date2);

		System.out.println("date1=" + date1);
		System.out.println("date2=" + date2);
		System.out.println("pe=" + pe); // P1Y11M30D : 1년 11월 30일 차이
		
		// 년/월/일 필드를 추출하는 방법 1 : getYears(), getMonths(), getDays() 메서드 호출
		System.out.println("YEAR=" + pe.getYears());
		System.out.println("MONTH=" + pe.getMonths());
		System.out.println("DAY=" + pe.getDays());
		
		// 년/월/일 필드를 추출하는 방법 2 : get(TemporalUnit) 메서드 호출
		System.out.println("YEAR=" + pe.get(ChronoUnit.YEARS));
		System.out.println("MONTH=" + pe.get(ChronoUnit.MONTHS));
		System.out.println("DAY=" + pe.get(ChronoUnit.DAYS));
	}
	
	/**
	 * title : Duration.between 메서드
	 * Duration.between(LocalTime time1, LocalTime time2)
	 * - 두 시간간의 차이를 계산하여 Duration 인스턴스로 생성합니다.
	 * 
	 * Duration 클래스 특징
	 * 1. Period 클래스와는 달리 시간단위가 초(getSeconds() / getNano())밖에 없음
	 */
	@Test
	void DurationBetweenMethodTest() {
		printMethodName("DurationBetweenMethodTest");
		
		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(12, 23, 56); // 12시간 23분 56초
		
		Duration du = Duration.between(time1, time2);
		
		System.out.println("time1=" + time1); // 00:00
		System.out.println("time2=" + time2); // 12:23:56
		System.out.println("du=" + du);       // PT12H23M56S : 12시간 23분 56초 차이
		
		// 초/나노초 필드를 추출하는 방법 1 : getSeconds(), getNano() 메서드 호출
		System.out.println("SECONDS=" + du.getSeconds());
		System.out.println("NANOS=" + du.getNano());
		
		// 초/나노초 필드를 추출하는 방법 2 : get(TemporalUnit) 메서드 호출
		System.out.println("SECONDS=" + du.get(ChronoUnit.SECONDS));
		System.out.println("NANOS=" + du.get(ChronoUnit.NANOS));		
	}
	
	/**
	 * title : Period와 Duration 클래스의 시간단위 확인
	 * - List<TemporalUnit> Period.getUnits() : Period 인스턴스가 가지고 있는 시간단위를 리스트 형태로 반환함
	 * - List<TemporalUnit> Duration.getUnits() : Duration 인스턴스가 가지고 있는 시간 단위를 리스트 형태로 반환함
	 * 
	 * Period와 Duration 시간 단위 특징
	 * - Period 클래스의 시간 단위는 년/월/일을 가지고 있기 때문에 getYears(), getMonths(),
	 * getDays()와 같은 메서드를 호출하여 년/월/일만을 추출할 수 있음
	 * - 반면 Duration 클래스의 시간 단위는 초/나노초 만을 가지고 있기 때문에 getHours(),
	 * getMinutes()과 같은 메서드를 호출할 수 없음
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
		
		// Period와 Duration 단위 확인
		System.out.println("Period Unit   : " + pe.getUnits()); // [Years, Months, Days]
		System.out.println("Duration Unit : " + du.getUnits()); // [Seconds, Nanos]
	}
	
	/**
	 * title : Duration 인스턴스의 시/분/초/나노초 계산
	 * 계산 방법 1 : getSeconds(), getNano() 메서드를 통한 시/분/초/나노초 계산
	 * 계산 방법 2 : Duration 인스턴스를 LocalTime 인스턴스로 변환하여 get 메서드 호출 
	 */
	@Test
	void DurationCalHourMinuteTest() {
		printMethodName("DurationCalHourMinuteTest");
		
		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(12, 23, 56); // 12시간 23분 56초
		Duration du = Duration.between(time1, time2);
		
		// Duration 인스턴스의 시/분/초/나노초 계산 방법 1 : 
		// Duration.getSeconds(), Duration.getNano()를 활용한 시/분/초/나노초 계산
		long hour = du.getSeconds() / 3600;
		long min  = (du.getSeconds() - hour*3600) / 60;
		long sec  = (du.getSeconds() - hour*3600 - min*60) % 60;
		int nano  = du.getNano();
		System.out.printf("%02d:%02d:%02d.000%d\n", hour, min, sec, nano); // 12:23:56.0000
		
		// Duration 인스턴스의 시/분/초/나노초 계산 방법 2 :
		// Duration 인스턴스를 LocalTime으로 변환하여 get 메서드를 호출
		LocalTime tmpTime = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
		System.out.println("HOUR=" + tmpTime.getHour());
		System.out.println("MINUTE=" + tmpTime.getMinute());
		System.out.println("SECOND=" + tmpTime.getSecond());
		System.out.println("NANO=" + tmpTime.getNano());
	}
	
	/**
	 * title : LocalDate.until(ChrnoLocalDate endDateExclusive) 메서드
	 * - Period.between() 메서드 역할과 기능이 동일함
	 * - Period.between()과 LocalDate.until() 차이점은 between()은 정적(static) 메서드이고
	 * until()는 인스턴스 메서드임
	 * - 두번째 인자에 날짜단위(TemporalUnit)를 전달하여 어느 날짜 단위차이인지 계산할 수 있음
	 */
	@Test
	void PeriodUntilMethodTest() {
		printMethodName("PeriodUntilMethodTest");
		
		LocalDate today = LocalDate.of(2022, 06, 20);
		LocalDate birthday = LocalDate.of(2022, 11, 07);
		
		Period p1 = today.until(birthday);
		System.out.println(p1); // P4M18D(4달+18일)
		
		long dday = today.until(birthday, ChronoUnit.DAYS);
		System.out.println(dday); // 140	
	}
	
	/**
	 * title : LocalTime.until() 메서드
	 * - LocalTime.until(Temporal endExclusive, TemporalUnit unit)
	 * LocalTime 인스턴스간의 시간 차이를 계산합니다.
	 */
	@Test
	void DurationUntilMethodTest() {
		printMethodName("DurationUntilMethodTest");
		
		LocalTime time1 = LocalTime.of(12, 0, 0);
		LocalTime time2 = LocalTime.of(3, 0, 0);
		
		// LocalTime.until() 메서드 사용
		long sec = time1.until(time2, ChronoUnit.SECONDS);
		
		System.out.println(sec); // -32400초
	}
	
	/**
	 * title : Period.of() 메서드
	 * Period.of(int years, int months, int days) : 특정 년/월/일을 설정하여 Period 인스턴스 생성
	 * Period.ofYears(int years)                  : 특정 년도를 설정하여 Period 인스턴스 생성
	 * Period.ofMonths(int months)                : 특정 월을 설정하여 Period 인스턴스 생성
	 * Period.ofWeeks(int weeks)                  : 특정 n주를 설정하여 Period 인스턴스 생성, 1주=7일
	 * Period.ofDays(int days)                    : 특정 일을 설정하여 Period 인스턴스 생성
	 */
	@Test
	void PeriodOfMethodTest() {
		printMethodName("PeriodOfMethodTest");
		
		Period p1y12m31d = Period.of(1, 12, 31); // 1년 12개월 31일 차이
		Period p1y = Period.ofYears(1);          // 1년 차이
		Period p1m = Period.ofMonths(1);         // 1달 차이
		Period p7d = Period.ofWeeks(1);          // 일주일 차이
		Period p30d = Period.ofDays(30);         // 30일 차이
		System.out.println(p1y12m31d);			 // P1Y12M31D
		System.out.println(p1y);				 // P1Y
		System.out.println(p1m);				 // P1M
		System.out.println(p7d);				 // P7D
		System.out.println(p30d);				 // P30D		
	}
	
	/**
	 * title : Duration.of() 메서드
	 * Duration.of(long amount, TemporalUnit unit) : 특정 시간단위만큼 차이를 가지는 Duration 인스턴스 생성
	 * Duration.ofDays(long days)                  : days일만큼 차이를 가지는 Duration 인스턴스 생성
	 * Duration.ofHours(long hours)                : hours시간만큼 차이를 가지는 Duration 인스턴스 생성
	 * Duration.ofMinutes(long minuts)             : minutes분만큼 차이를 가지는 Duration 인스턴스 생성
	 * Duration.ofSeconds(long seconds)            : seconds초만큼 차이를 가지는 Duration 인스턴스 생성
	 * Duration.ofNanos(long nanos)                : nanos초만큼 차이를 가지는 Duration 인스턴스 생성
	 */
	@Test
	void DurationOfMethodTest() {
		printMethodName("DurationOfMethodTest");
		
		// Duration.of() 메서드 사용 방법 1 : Duration.of(long amount, TemporalUnit unit) 호출
		Duration pt1m = Duration.of(60, ChronoUnit.SECONDS); // 60초
		
		// Duration.of() 메서드 사용 방법 2 : ofXXX() 호출
		Duration pt168h = Duration.ofDays(7);    // 7일
		Duration pt7h = Duration.ofHours(7);     // 7시간
		Duration pt7m = Duration.ofMinutes(7);   // 7분
		Duration pt7s = Duration.ofSeconds(7);   // 7초
		Duration pt7nano = Duration.ofNanos(7);  // 7나노초
		
		System.out.println(pt1m);    // PT1M 
		System.out.println(pt168h);  // PT168H
		System.out.println(pt7h);    // PT7H
		System.out.println(pt7m);    // PT7M
		System.out.println(pt7s);    // PT7S
		System.out.println(pt7nano); // PT0.000000007S
	}

	/**
	 * title : Period.with() 메서드
	 * Period withYears(int years)   : Period 인스턴스의 년도 필드만 변경
	 * Period withMonths(int months) : Period 인스턴스의 월 필드만을 변경
	 * Period withDays(int days)     : Period 인스턴스의 일자 필드만을 변경 
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
	 * title : Duration.with() 메서드
	 * Duration withSeconds(int seconds) : Duration 인스턴스의 초 필드만을 변경
	 * Duration withNanos(int nanos)     : Duration 인스턴스의 나노초 필드만을 변경
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
	 *title : Period 클래스 사칙연산 메서드
	 * Period minus(TemporalAmount amountToSuctract) : 특정 날짜단위만큼 차감 
	 * Period minusYears(long yearsToSuctract)       : 특정 년도수만큼 차감
	 * Period minusMonths(long monthsToSubtract)     : 특정 월만큼 차감
	 * Period minusDays(long daysToSubtract)         : 특정 일자만큼 차감
	 * Period multipliedBy(int scaler)               : scaler 수만큼 날짜를 곱함    
	 */
	@Test
	void PeriodArithmeticOperationMethodTest() {
		printMethodName("PeriodArithmeticOperationMethodTest");
		
		Period pe = Period.of(1, 6, 10);
		
		pe = pe.minusYears(1).multipliedBy(2); // 1년을 빼고 2배를 곱함
		System.out.println(pe);
	}
	
	/**
	 * title : Duration 클래스 사칙연산 메서드
	 * Duration plus(Duration duration) : Duration 인스턴스만큼 차이를 누적
	 * Duration plus(long amountToAdd, TemporalUnit unit) : 특정 시간단위만큼 누적
	 * Duration plusHours(long hoursToAdd)                : 시간 누적
	 * Duration plusMinutes(long minutsToAdd)             : 분 누적
	 * Duration plusSeconds(long secondsToAdd)            : 초 누적
	 * Duration plusMillis(long millisToAdd)              : 밀리초 누적
	 * Duration plusNanos(long nanosToAdd)                : 나노초 누적
	 * Duration multipliedBy(int scaler)                  : scaler만큼 곱함
	 * Duration divideBy(long divisor)                    : divisor만큼 나눔
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
	 * title : Period, Duration의 isZero(), isNegative() 메서드
	 * boolean isZero() : 두 날짜의 차이가 0인지 검사
	 * boolean isNegative() : 음수인지 검사 
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
	 * title : Period.normalized() 메서드
	 * Period normalized() : 월의 값이 12를 넘기지 않고 년도로 넘겨주는 기능
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
	 * title : Period & Duration 다른 단위로 변환
	 * Period 인스턴스 메서드
	 * long toTotalMonths() : 년월일을 월단위로 변환해서 반환 (일 단위는 무시)
	 * 
	 * Duration 인스턴스 메서드
	 * long toDays()        : 일단위로 변환해서 반환
	 * long toHours()       : 시간 단위로 변환해서 반환
	 * long toMinutes()     : 분 단위로 변환해서 반환
	 * long toMillis()      : 밀리초 단위로 변환해서 반환
	 * long toNanos()       : 나노초 단위로 변환해서 반환
	 */
	@Test
	void PeriodAndDurationToMethodTest() {
		printMethodName("PeriodAndDurationToMethodTest");
		
		Period pe = Period.of(1, 6, 30);	// 1년 6개월 30일 차이
		long months = pe.toTotalMonths();
		
		Duration du = Duration.of(1, ChronoUnit.DAYS);
		long days = du.toDays();
		long hours = du.toHours();
		long minutes = du.toMinutes();
		long seconds = du.getSeconds();
		long millis = du.toMillis();
		long nanos = du.toNanos();
		
		System.out.println("months : " + months +"개월");
		System.out.println("days : " + days + "일");
		System.out.println("hours : " + hours + "시간");
		System.out.println("minutes : " + minutes + "분");
		System.out.println("seconds : " + seconds + "초");
		System.out.println("millis : " + millis + "밀리초");
		System.out.println("nanos : " + nanos);		
	}
	
	/**
	 * title : LocalDate 인스턴스간의 toEpochDay() 메서드를 이용한 날짜 차이 계산
	 * LocalDate 인스터스 메서드
	 * long toEpochDay() : '1970-01-01'부터 LocalDate 인스턴스의 날짜까지를 일자를 세어서 반환
	 */
	@Test
	void LocalDateToEpochDayMethodTest() {
		printMethodName("LocalDateToEpochDayMethodTest");
		
		LocalDate date1 = LocalDate.of(2015, 1, 1);
		LocalDate date2 = LocalDate.of(2017, 1, 1);
		
		long period = date2.toEpochDay() - date1.toEpochDay();
		
		System.out.printf("%s과 %s의 차이는 %d일\n", date1, date2, period);
	}
}

