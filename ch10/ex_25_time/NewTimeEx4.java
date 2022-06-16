package ch10.ex_25_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

class DayAfterTomorrow implements TemporalAdjuster{

	@Override
	public Temporal adjustInto(Temporal temporal) {
		return temporal.plus(2, ChronoUnit.DAYS);
	}
}

public class NewTimeEx4 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate date = today.with(new DayAfterTomorrow());
		
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
	
	public static void p(Object obj) {
		System.out.println(obj);
	}
}
