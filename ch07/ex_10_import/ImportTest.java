package ch07.ex_10_import;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * import�� ����	
 */
public class ImportTest {
	public static void main(String[] args)
	{
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss a");
		
		System.out.println("���� ��¥�� " + date.format(today));
		System.out.println("���� �ð��� " + time.format(today));
	}
}
