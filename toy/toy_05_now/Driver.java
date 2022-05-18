package toy.toy_05_now;

import java.time.LocalDateTime;

// title : now
// content : 오늘 날짜(년,월,일,시,분,초)를 1초 간격으로 출력함

public class Driver {

	
	public static void main(String[] args) {
		Now now = new Now("yyyy년 MM월 dd일 EEEE hh시 mm분 ss초");
		
		NowThread t1 = new NowThread(now);
		
		t1.run();	// ex) 2022년 01월 10일 월요일 05시 54분 26초
	}

}
