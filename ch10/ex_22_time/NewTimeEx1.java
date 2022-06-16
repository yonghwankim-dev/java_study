package ch10.ex_22_time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewTimeEx1 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();  // ���� ��¥
		LocalTime now = LocalTime.now();	// ���� �ð�
		
		LocalDate birthDate = LocalDate.of(1998, 12, 31);	// 1998�� 12�� 31��
		LocalTime birthTime = LocalTime.of(23, 59, 59);		// 23�� 59�� 59��
		
		System.out.println("today=" + today);
		System.out.println("now=" + now);
		System.out.println("birthDate=" + birthDate);
		System.out.println("birthTime=" + birthTime);
		
		System.out.println(birthDate.withYear(2000));			// 2000-12-31
		System.out.println(birthDate.plusDays(1));				// 1999-01-01
		System.out.println(birthDate.plus(1, ChronoUnit.DAYS)); // 1999-01-01
		
		// 23:59:59 -> 23:00
		System.out.println(birthTime.truncatedTo(ChronoUnit.HOURS));
		
		// Ư�� ChornoField�� ������ �˾Ƴ��� ���
		System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range()); // 1-24
		System.out.println(ChronoField.HOUR_OF_DAY.range());	   // 0-23
	}
}
