package ch10.ex_22_time_LocalDate_LocalTime;

import java.time.Instant;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class InstantTest {

	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : Instant �ν��Ͻ� ����
	 * Instant Ŭ����
	 * - ����ũ Ÿ��('1970-01-01 00:00:00 UTC')���� ����� �ð��� ������ ������ ǥ���ϴ� Ŭ����
	 *  
	 * Instant Ŭ������ Ŭ���� �޼���
	 * Instant Instant.now()                              : ����ũ Ÿ�Ӻ��� ����ð����� ����� �ð��� ��ȯ
	 * Instant Instant.ofEpochSecond(long epochSecond)    : epochSecond ������ �Է¹޾� �ν��Ͻ� ����
	 * Instant Instant.ofEpochSecond(long epochSecond,    : ����ũ Ÿ����, ����ũ Ÿ�� �����ʸ� �Է¹޾� �ν��Ͻ� ����
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
