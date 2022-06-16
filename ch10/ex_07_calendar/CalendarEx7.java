package ch10.ex_07_calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class CalendarEx7 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("년 월 입력(ex 2015 11) : ");
		String[] str;
		
		try {
			str = br.readLine().split(" ");
		} catch (IOException e) {
			System.out.println("입력이 잘못되었습니다.");
			return;
		}
		int year = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int START_DAY_OF_WEEK = 0; // 주의 시작 요일
		int END_DAY = 0;
		
		Calendar sDay = Calendar.getInstance(); // 시작일
		Calendar eDay = Calendar.getInstance(); // 끝일
		
		// 월의 경우 0~11 사이의 값을 가지므로 1을 빼주어야 한다.
		// 예를 들어 2015년 11월 1일은 sDay.set(2015, 10, 1); 과 같이 설정해주어야 한다.
		sDay.set(year, month - 1, 1);
		// 입력월의 말일로 설정한다.
		eDay.set(year, month - 1, sDay.getActualMaximum(Calendar.DATE));
		
		// 1일이 속한 주의 일요일로 날짜 설정
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
		
		// 말일이 속한 주의 토요일로 날짜 설정
		eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK));
		
		System.out.println("     " + year + "년 " + month + "월");
		System.out.println(" SU MO TU WE TH FR SA");
		
		// 시작일부터 마지막일까지 (sDay <= eDay) 1일씩 증가시키면서 일(Calendar.DATE) 출력
		for(int n = 1; sDay.before(eDay) || sDay.equals(eDay); sDay.add(Calendar.DATE, 1)) {
			int day = sDay.get(Calendar.DATE);
			System.out.print((day < 10) ? "  " + day : " " + day);
			if(n % 7 == 0) {
				System.out.println(); // 7일을 찍고 나서 줄을 바꾼다.
			}
			n++;
		}
	}

}
