package ch10.ex_22_time_LocalDate_LocalTime;

import java.time.Instant;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class InstantTest {

	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : Instant 인스턴스 생성
	 * Instant 클래스
	 * - 에포크 타임('1970-01-01 00:00:00 UTC')부터 경과된 시간을 나노초 단위로 표현하는 클래스
	 *  
	 * Instant 클래스의 클래스 메서드
	 * Instant Instant.now()                              : 에포크 타임부터 현재시간까지 경과된 시간을 반환
	 * Instant Instant.ofEpochSecond(long epochSecond)    : epochSecond 정수를 입력받아 인스턴스 생성
	 * Instant Instant.ofEpochSecond(long epochSecond,    : 에포크 타임초, 에포크 타임 나노초를 입력받아 인스턴스 생성
	 *                               long nanoAdjustment)
	 */
	@Order(1)
	@Test
	void InstantClassTest() {
		printMethodName("InstantClassTest");
		
		Instant now = Instant.now();
		Instant now2 = Instant.ofEpochSecond(now.getEpochSecond());
		Instant now3 = Instant.ofEpochSecond(now.getEpochSecond(), now.getNano());
		
		System.out.println(now);  // 2022-06-16T08:00:18.794332300Z
		System.out.println(now2); // 2022-06-16T08:00:18Z
		System.out.println(now3); // 2022-06-16T08:00:18.794332300Z		
	}
	
}
