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
	 * title TemporalAdjusters Ŭ������ �޼��� �׽�Ʈ
	 * TemporalAdjusters Ŭ������ ���� �޼ҵ�
	 * - TemporalAdjuster firstDayOfNextMonth()            : �������� ù��
	 * - TemporalAdjuster firstDayOfMonth()                : �̹����� ù��
	 * - TemporalAdjuster lastDayOfMonth()                 : �̹����� ��������
	 * - TemporalAdjuster firstInMonth(DayOfWeek)          : �� ���� ù��° ����
	 * - TemporalAdjuster lastInMonth(DayOfWeek)           : �� ���� ������ ����
	 * - TemporalAdjuster previous(DayOfWeek)              : ������ ����
	 * - TemporalAdjuster previousOrSame(DayOfWeek)        : ������ ���� (���� ����)
	 * - TemporalAdjuster next(DayOfWeek)                  : ������ ����
	 * - TemporalAdjuster nextOrSame(DayOfWeek)            : ������ ���� (���� ����)
	 * - TemporalAdjuster dayOfWeekInMonth(int, DayOfWeek) : �̹����� n��° ����
	 */
	@Test
	void temporalAdjustersClassTest() {
		LocalDate today = LocalDate.of(2022, 06, 20);
		LocalDate date = today.with(new DayAfterTomorrow()); // TemporalAdjusters ���� ����
		
		p(today);
		p(date);
		p(today.with(TemporalAdjusters.firstDayOfNextMonth())); 		    // �������� ù��
		p(today.with(TemporalAdjusters.firstDayOfMonth()));                 // �̴��� ù��
		p(today.with(TemporalAdjusters.lastDayOfMonth()));                  // �̴��� ��������
		p(today.with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY)));   // �� ���� ù��° ȭ����
		p(today.with(TemporalAdjusters.lastInMonth(DayOfWeek.TUESDAY)));    // �� ���� ������ ȭ����
		p(today.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY)));       // ���� �ֱ� ������ ȭ����
		p(today.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY))); // ������ �����Ͽ� ���� �ֱ� ������ ȭ����
		p(today.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));			// ���� �ֱ� ������ ȭ����
		p(today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));     // ������ �����Ͽ� ���� �ֱ� ������ ȭ����
		p(today.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.TUESDAY))); // �� ���� 4��° ȭ����		
	}
	
}
