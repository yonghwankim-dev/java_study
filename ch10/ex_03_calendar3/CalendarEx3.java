package ch10.ex_03_calendar3;

import java.util.Calendar;

public class CalendarEx3 {

	public static void main(String[] args) {
		final int[] TIME_UNIT = {3600, 60, 1};	// �ð�����, ū ������ �տ� ����
		final String[] TIME_UNIT_NAME = {"�ð� ", "�� ", "�� "};
		
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		// time1�� 10�� 20�� 30�ʷ� ����
		time1.set(Calendar.HOUR_OF_DAY, 10); 
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);
		
		// time2�� 20�� 30�� 10�ʷ� ����
		time2.set(Calendar.HOUR_OF_DAY, 20);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);
		
		System.out.println("time1 : " + toString(time1));
		System.out.println("time2 : " + toString(time2));
		
		long diff = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000;
		System.out.println("time1�� time2�� ���̴� " + diff + "���Դϴ�.");
		
		String tmp = "";
		for(int i = 0; i < TIME_UNIT.length; i++) {
			tmp += ((diff / TIME_UNIT[i]) + TIME_UNIT_NAME[i]);
			diff %= TIME_UNIT[i];
		}
		System.out.println("time1�� time2�� ���̴� " + tmp + "�Դϴ�.");
	}
	
	public static String toString(Calendar time) {
		return time.get(Calendar.HOUR_OF_DAY) + "�� " 
	         + time.get(Calendar.MINUTE) + "�� " 
			 + time.get(Calendar.SECOND) + "��";
	}

}
