package ch10.ex_12_simpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatEx1 {

	public static void main(String[] args) {
		Date today = new Date();
		
		SimpleDateFormat[] sdfs = new SimpleDateFormat[9];
		
		sdfs[0] = new SimpleDateFormat("yyyy-MM-dd");
		sdfs[1] = new SimpleDateFormat("``yy년 MMM dd일 E요일");
		sdfs[2] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdfs[3] = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		sdfs[4] = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
		sdfs[5] = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
		sdfs[6] = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
		sdfs[7] = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
		sdfs[8] = new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");
		
		for(SimpleDateFormat sdf : sdfs) {
			System.out.println(sdf.format(today));
		}
		
	}

}
