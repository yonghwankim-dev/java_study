package ch10.ex_05_calendar5;

import java.util.Calendar;

public class CalendarEx5 {

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		
		date.set(2015, Calendar.JANUARY, 31); // 2015�� 1�� 31��
		System.out.println(toString(date));
		date.roll(Calendar.MONTH, 1);
		// roll�� ���Ͽ� 2���� ����Ǿ��µ� ������ ���� ������ ������ ������ 2���� 28�ϱ��� �ֱ� ������ ���� �����
		// add�� ���������� �ٸ� �Ͽ� ������ ��
		System.out.println(toString(date));	

	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "�� " 
	        + (date.get(Calendar.MONTH)+1) + "�� "
	        + date.get(Calendar.DATE) + "�� ";
	}

}
