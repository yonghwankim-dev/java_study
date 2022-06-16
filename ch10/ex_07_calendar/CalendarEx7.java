package ch10.ex_07_calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class CalendarEx7 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�� �� �Է�(ex 2015 11) : ");
		String[] str;
		
		try {
			str = br.readLine().split(" ");
		} catch (IOException e) {
			System.out.println("�Է��� �߸��Ǿ����ϴ�.");
			return;
		}
		int year = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int START_DAY_OF_WEEK = 0; // ���� ���� ����
		int END_DAY = 0;
		
		Calendar sDay = Calendar.getInstance(); // ������
		Calendar eDay = Calendar.getInstance(); // ����
		
		// ���� ��� 0~11 ������ ���� �����Ƿ� 1�� ���־�� �Ѵ�.
		// ���� ��� 2015�� 11�� 1���� sDay.set(2015, 10, 1); �� ���� �������־�� �Ѵ�.
		sDay.set(year, month - 1, 1);
		// �Է¿��� ���Ϸ� �����Ѵ�.
		eDay.set(year, month - 1, sDay.getActualMaximum(Calendar.DATE));
		
		// 1���� ���� ���� �Ͽ��Ϸ� ��¥ ����
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
		
		// ������ ���� ���� ����Ϸ� ��¥ ����
		eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK));
		
		System.out.println("     " + year + "�� " + month + "��");
		System.out.println(" SU MO TU WE TH FR SA");
		
		// �����Ϻ��� �������ϱ��� (sDay <= eDay) 1�Ͼ� ������Ű�鼭 ��(Calendar.DATE) ���
		for(int n = 1; sDay.before(eDay) || sDay.equals(eDay); sDay.add(Calendar.DATE, 1)) {
			int day = sDay.get(Calendar.DATE);
			System.out.print((day < 10) ? "  " + day : " " + day);
			if(n % 7 == 0) {
				System.out.println(); // 7���� ��� ���� ���� �ٲ۴�.
			}
			n++;
		}
	}

}
