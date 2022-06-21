package toy.toy_06_calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class CalendarController {
	
	private LocalDate date;
	
	public CalendarController() {
		this(LocalDate.now());
	}

	private CalendarController(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * 달력앱 시작
	 */
	public void start() {
		String in = null;
		
		showCalendar();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while(true) {
				showMenu();
				in = inputMenu(br);
				if(checkMenuRange(in)) {
					process(in, br);
				}else {
					System.out.println("잘못된 입력입니다.");
				}
			}
		}catch(IOException e) {
			System.out.println("잘못된 입력입니다.");
		}	
	}
	
	/**
	 * 달력을 출력함
	 * 기본값 : 현재 년도와 월
	 */
	private void showCalendar() {
		showCalendar(this.date);
	}
	
	/**
	 * 달력을 출력함
	 * @param date LocalDate 인스턴스
	 */
	private void showCalendar(LocalDate date) {
		showCalendar(date.getYear(), date.getMonthValue());
	}
		
	/**
	 * 특정 년도/월의 달력을 출력
	 * @param year 년도
	 * @param month 월
	 */
	private void showCalendar(int year, int month) {
		LocalDate startDate = LocalDate.of(year, month, 1); // 년도/월의 1일
		LocalDate endDate   = startDate.with(TemporalAdjusters.firstDayOfNextMonth()); // 년도/월의 다음달 1일		
		// 1일이 속한 주의 일요일로 날짜 설정
		LocalDate firstSundayOfFirstWeekInMonth = startDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
		LocalDate curDate = firstSundayOfFirstWeekInMonth;
		// 말일이 속한 주의 토요일로 날짜 설정
		LocalDate lastSaturdayOfLastWeekInMonth = endDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).plusDays(1);
		
		int dayOfMonth = 0;
		int i = 1;
		
		System.out.println("         [" + year + "년 " + month + "월]");
		System.out.println("  일  월   화   수   목  금   토");
	
		while(!curDate.isEqual(lastSaturdayOfLastWeekInMonth)) {
			dayOfMonth = curDate.getDayOfMonth();
			System.out.print((dayOfMonth < 10) ? "  " + dayOfMonth : " " + dayOfMonth);
			System.out.print(" ");
			if(i % 7 == 0) {
				System.out.println();
			}
			
			curDate = curDate.plus(1, ChronoUnit.DAYS);
			i++;
		}
		System.out.println();
	}
	
	/**
	 * 이전 달로 이동
	 */
	private void previous() {
		setDate(date.minusMonths(1));
		
		showCalendar();
	}
	
	/**
	 * 다음 달로 이동
	 */
	private void next() {
		setDate(date.plusMonths(1));
		
		showCalendar();
	}
	
	/**
	 * 프로그램 종료
	 */
	private void exit() {
		System.out.println("달력을 종료합니다.");
		System.exit(0);
	}
	
	/**
	 * 메뉴 출력
	 */
	private void showMenu() {
		System.out.println("메뉴");
		System.out.println("1.    달력 검색");
		System.out.println("2.    이전달 보기");
		System.out.println("3.    다음달 보기");
		System.out.println("exit. 종료");
	}
	
	/**
	 * 메뉴 번호 입력
	 * @return 메뉴번호
	 * @throws IOException 
	 */
	private String inputMenu(BufferedReader br) throws IOException {
		System.out.print("메뉴 입력 : ");
		return br.readLine();
	}
	
	/**
	 * 메뉴 범위 확인
	 * @param in 입력받은 번호
	 * @return true:유효, false:유효하지 않음
	 */
	private boolean checkMenuRange(String in) {
		return in.equals("1") 
			|| in.equals("2") 
			|| in.equals("3") 
			|| in.equals("exit") ? true : false;
	}
	
	/**
	 * 입력받은 번호에 대한 서비스 수행
	 * @param n 입력받은 번호
	 * @return true: 서비스성공, false: 서비스실패
	 * @throws IOException 
	 */
	private void process(String n, BufferedReader br) throws IOException{
		LocalDate inLocalDate = null;
		String[] yearAndMonth = null;
		int year  = 0;
		int month = 0;
		if(n.equals("1")) {
			System.out.print("년도/월 입력 (ex 2015 6) : ");
			yearAndMonth = br.readLine().split(" ");
			
			try {
				year = Integer.parseInt(yearAndMonth[0]);
				month = Integer.parseInt(yearAndMonth[1]);
				
				inLocalDate = LocalDate.of(year, month, 1);
				showCalendar(inLocalDate);
			}catch (NumberFormatException e) {
				System.out.println("잘못된 년도 또는 월일입니다.");
			}			
		}
		else if(n.equals("2")) {
			previous();
		}
		else if(n.equals("3")) {
			next();
		}else if(n.equals("exit")) {
			exit();
		}	
	}
	
	private void setDate(LocalDate date) {
		this.date = date;
	}	
}
