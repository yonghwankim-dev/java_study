package ch15.ex_06_PrintStream;

import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class PrintStreamTest {
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : PrintStream 사용
	 * System 클래스의 out 멤버는 PrintStream 인스턴스임
	 * 
	 * printf() : 메서드에 형식화를 수행하여 출력할 수 있음
	 * 
	 * 메서드의 정수의 출력에 사용될 수 있는 옵션, 결과(int i=65)
	 * %d   : 10진수 , 65
	 * %o   : 8진수  , 101
	 * %x   : 16진수 , 41
	 * %c   : 문자   , A
	 * %s   : 문자열  , 65
	 * %5d  : 5자리 숫자. 빈자리는 공백으로 채운다. , '   '65
	 * %-5d : 5자리 숫자. 빈자리는 공백으로 채운다. (왼쪽 정렬), 65'   '
	 * %05d : 5자리 숫자. 빈자리는 0으로 채운다., 00065
	 * 
	 * 문자열의 출력에 사용될 수 있는 옵션, 결과(String str = "ABC")
	 * %s   : 문자열, ABC
	 * %5s  : 5자리 문자열. 빈자리는 공백으로 채운다., '  'ABC
	 * %-5s : 5자리 문자열. 빈자리는 공백으로 채운다., ABC'  '
	 * 
	 * 실수의 출력에 사용될 수 있는 옵션, 결과(float f = 1234.56789f)
	 * %e     : 지수형태표현 , 1.234568e+03
	 * %f     : 10진수    , 1234.56789
	 * %3.1f  : 출력될 자리수를 최소 3자리(소수점포함), 소수점 이하 1자리(2번째 자리에서 반올림), 1234.6
	 * %8.1f  : 소수점이상 최소 6자리, 소주점 이하 1자리.
	 * 출력될 자리수를 최소 8자리(소수점 포함)을 확보한다. 빈자리는 공백으로 채워진다.(오른쪽 정렬), '  '1234.6
	 * %08.1f : 소수점이상 최소 6자리. 소주점 이하 1자리
	 * 출력될 자리수를 최소 8자리(소수점포함)을 확보한다. 빈자리는 0으로 채워진다., 001234.6
	 * %-8.1f : 소수점이상 최소 6자리. 소수점 이하 1자리.
	 * 출력될 자리수를 최소 8자리(소수점포함)을 확보한다. 빈자리는 공백으로 채워진다.(왼쪽 정렬), 1234.6'  '
	 * 
	 * 특수문자를 출력하는 옵션
	 * \t     : 탭(tab)
	 * %n     : 줄바꿈 문자(new line)
	 * %%     : %
	 * 
	 * 날짜와 시간의 출력에 사용될 수 있는 옵션
	 * %tR, %tH:%tM     : 시분(24시간) , 21:05
	 * %tT, %tH:%tM:%tS : 시분초(24시간), 21:05:33
	 * %tD, %tm/%td/%ty : 월일년       , 11/16/15
	 * %tF, %tY-%tm-%td : 년월일       , 2015-11-16
	 * 
	 * '숫자$'를 옵션앞에 붙여줌으로써 출력된 매개변수를 지정해줄수 있음
	 */
	@Order(1)
	@Test
	void printStreamTest() {
		int i   = 65;
		float f = 1234.56789f;
		Date d  = new Date();
		
		System.out.printf("문자 %c의 코드는 %d\n", i, i);
		System.out.printf("%d는 8진수로 %o, 16진수로 %x\n", i, i, i);
		System.out.printf("%3d%3d%3d\n", 100, 90, 80);
		System.out.println();
		
		System.out.printf("123456789012345678901234567890\n");
		System.out.printf("%s%-5s%5s%n", "123", "123", "123");
		System.out.println();
		
		System.out.printf("%-8.1f%8.1f %e%n", f, f, f);
		System.out.println();
		
		System.out.printf("오늘은 %tY년 %tm월 %td일입니다.\n", d, d, d);
		System.out.printf("오늘은 %tH시 %tM분 %tS초입니다.\n", d, d, d);
		System.out.printf("지금은 %1$tH시 %1$tM분 %1$tS초입니다.\n", d);
	}
	
}
