package ch10.ex_15_simpleDateFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ȭ�����κ��� ��¥�� �Է¹޾Ƽ� ����(today)���� �ð����̸� ���ϴ� ����
 *
 */
public class DateFormatEx4 {

	public static void main(String[] args) {
		final String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Date inDate = null;
		
		System.out.print("��¥�� " + pattern + "�� ���·� �Է����ּ���. (�Է¿�:2015/12/31)");
		while(true) {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
				inDate = df.parse(br.readLine());
				break;
			} catch (ParseException | IOException e) {
				System.out.println("��¥�� " + pattern + "�� ���·� �ٽ� �Է����ּ���. (�Է¿�:2015/12/31)");
			}	
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(inDate);
		Calendar today = Calendar.getInstance();
		long day = Math.abs((cal.getTimeInMillis() - today.getTimeInMillis()) / (60*60*1000));
		System.out.println("�Է��Ͻ� ��¥�� ����� " + day + "�ð� ���̰� �ֽ��ϴ�."); 
		
		
	}

}
