package ch10.ex_12_simpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatEx1 {

	public static void main(String[] args) {
		Date today = new Date();
		
		SimpleDateFormat[] sdfs = new SimpleDateFormat[9];
		
		sdfs[0] = new SimpleDateFormat("yyyy-MM-dd");
		sdfs[1] = new SimpleDateFormat("``yy�� MMM dd�� E����");
		sdfs[2] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdfs[3] = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		sdfs[4] = new SimpleDateFormat("������ �� ���� D��° ���Դϴ�.");
		sdfs[5] = new SimpleDateFormat("������ �� ���� d��° ���Դϴ�.");
		sdfs[6] = new SimpleDateFormat("������ �� ���� w��° ���Դϴ�.");
		sdfs[7] = new SimpleDateFormat("������ �� ���� W��° ���Դϴ�.");
		sdfs[8] = new SimpleDateFormat("������ �� ���� F��° E�����Դϴ�.");
		
		for(SimpleDateFormat sdf : sdfs) {
			System.out.println(sdf.format(today));
		}
		
	}

}
