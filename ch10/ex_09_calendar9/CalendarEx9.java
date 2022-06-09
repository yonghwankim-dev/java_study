package ch10.ex_09_calendar9;

import java.util.Calendar;

public class CalendarEx9 {
	public static final int[] endOfMonth = {31, 28, 31, 30, 31, 30,
			                                31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) {
		System.out.println("2014. 5. 31 : " + getDayOfWeek(2014, 5, 31));
		System.out.println("2012. 6. 1  : " + getDayOfWeek(2012, 6, 1));
		System.out.println("2014. 5. 1 - 014.4.28 : " + dayDiff(2014,5,1,2014,4,28));
		System.out.println("2015. 6. 29 : " + convertDateToDay(2015, 6, 29));
		System.out.println("735778 : " + convertDayToDate(735778));
		
	}
	

	// �� ��¥���� ���̸� �ϴ����� ��ȯ
	public static int dayDiff(int y1, int m1, int d1, int y2, int m2, int d2) {
		return convertDateToDay(y1, m1, d1) - convertDateToDay(y2, m2, d2);
	}

	// ������ ��¥�� ������ ��ȯ
	public static int getDayOfWeek(int year, int month, int day) {
		// 1~7�� ���� ��ȯ��. 1: �Ͽ���, 2: ������, ... , 7: �����
		return convertDateToDay(year, month, day) % 7 + 1;
	}
	
	// ���� ��/��/�Ϸ� ��ȯ
	public static String convertDayToDate(int day) {
		int year = 1;
		int month = 0;
		
		while(true) {
			int aYear = isLeapYear(year) ? 366 : 365;
			if(day > aYear) {
				day -= aYear;
				year++;
			}else {
				break;
			}
		}
		
		while(true) {
			int endDay = endOfMonth[month];
			// �����̰� ������ ���ԵǾ� ������, 1���� ���Ѵ�.
			if(isLeapYear(year) && month == 1) {
				endDay++;
			}
			
			if(day > endDay) {
				day -= endDay;
				month++;
			}else {
				break;
			}
		}
		
		return year + "-" + (month + 1) + "-" + day;
	}
	
	// ��/��/���� �Ϸ� ��ȯ
	public static int convertDateToDay(int year, int month, int day) {
		int numOfLeapYear = 0; // ������ ��
		
		// ���⵵������ ������ ���� ���Ѵ�.
		for(int i=1;i < year;i++) {
			if(isLeapYear(i)) {
				numOfLeapYear++;
			}
		}
		
		// ���⵵������ �ϼ��� ���Ѵ�.
		int toLastYearDaySum = (year - 1) * 365 + numOfLeapYear;
		
		// ������ ���� �������� �ϼ� ���
		int thisYearDaySum = 0;
		
		// ���� �������� �ϼ� ���
		for(int i = 0; i < month-1; i++) {
			thisYearDaySum += endOfMonth[i];
		}
		// �����̰�, 2���� ���ԵǾ� ������ 1���� ������Ŵ
		if(month > 2 && isLeapYear(year)) {
			thisYearDaySum++;
		}
		
		thisYearDaySum += day;
		
		
		return toLastYearDaySum + thisYearDaySum;
	}

	// �������� �˻�
	public static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
	}
	
	
}
