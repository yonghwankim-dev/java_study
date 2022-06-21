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
	 * �޷¾� ����
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
					System.out.println("�߸��� �Է��Դϴ�.");
				}
			}
		}catch(IOException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		}	
	}
	
	/**
	 * �޷��� �����
	 * �⺻�� : ���� �⵵�� ��
	 */
	private void showCalendar() {
		showCalendar(this.date);
	}
	
	/**
	 * �޷��� �����
	 * @param date LocalDate �ν��Ͻ�
	 */
	private void showCalendar(LocalDate date) {
		showCalendar(date.getYear(), date.getMonthValue());
	}
		
	/**
	 * Ư�� �⵵/���� �޷��� ���
	 * @param year �⵵
	 * @param month ��
	 */
	private void showCalendar(int year, int month) {
		LocalDate startDate = LocalDate.of(year, month, 1); // �⵵/���� 1��
		LocalDate endDate   = startDate.with(TemporalAdjusters.firstDayOfNextMonth()); // �⵵/���� ������ 1��		
		// 1���� ���� ���� �Ͽ��Ϸ� ��¥ ����
		LocalDate firstSundayOfFirstWeekInMonth = startDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
		LocalDate curDate = firstSundayOfFirstWeekInMonth;
		// ������ ���� ���� ����Ϸ� ��¥ ����
		LocalDate lastSaturdayOfLastWeekInMonth = endDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).plusDays(1);
		
		int dayOfMonth = 0;
		int i = 1;
		
		System.out.println("         [" + year + "�� " + month + "��]");
		System.out.println("  ��  ��   ȭ   ��   ��  ��   ��");
	
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
	 * ���� �޷� �̵�
	 */
	private void previous() {
		setDate(date.minusMonths(1));
		
		showCalendar();
	}
	
	/**
	 * ���� �޷� �̵�
	 */
	private void next() {
		setDate(date.plusMonths(1));
		
		showCalendar();
	}
	
	/**
	 * ���α׷� ����
	 */
	private void exit() {
		System.out.println("�޷��� �����մϴ�.");
		System.exit(0);
	}
	
	/**
	 * �޴� ���
	 */
	private void showMenu() {
		System.out.println("�޴�");
		System.out.println("1.    �޷� �˻�");
		System.out.println("2.    ������ ����");
		System.out.println("3.    ������ ����");
		System.out.println("exit. ����");
	}
	
	/**
	 * �޴� ��ȣ �Է�
	 * @return �޴���ȣ
	 * @throws IOException 
	 */
	private String inputMenu(BufferedReader br) throws IOException {
		System.out.print("�޴� �Է� : ");
		return br.readLine();
	}
	
	/**
	 * �޴� ���� Ȯ��
	 * @param in �Է¹��� ��ȣ
	 * @return true:��ȿ, false:��ȿ���� ����
	 */
	private boolean checkMenuRange(String in) {
		return in.equals("1") 
			|| in.equals("2") 
			|| in.equals("3") 
			|| in.equals("exit") ? true : false;
	}
	
	/**
	 * �Է¹��� ��ȣ�� ���� ���� ����
	 * @param n �Է¹��� ��ȣ
	 * @return true: ���񽺼���, false: ���񽺽���
	 * @throws IOException 
	 */
	private void process(String n, BufferedReader br) throws IOException{
		LocalDate inLocalDate = null;
		String[] yearAndMonth = null;
		int year  = 0;
		int month = 0;
		if(n.equals("1")) {
			System.out.print("�⵵/�� �Է� (ex 2015 6) : ");
			yearAndMonth = br.readLine().split(" ");
			
			try {
				year = Integer.parseInt(yearAndMonth[0]);
				month = Integer.parseInt(yearAndMonth[1]);
				
				inLocalDate = LocalDate.of(year, month, 1);
				showCalendar(inLocalDate);
			}catch (NumberFormatException e) {
				System.out.println("�߸��� �⵵ �Ǵ� �����Դϴ�.");
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
