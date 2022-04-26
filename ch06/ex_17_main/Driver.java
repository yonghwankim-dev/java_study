package ch06.ex_17_main;


/**
 * main 메서드 재귀호출
 * main 메서드 역시 재귀호출이 가능함
 * 탈출조건이 없이 때문에 stackoverflow 에러 발생
 */
public class Driver {
	
	public static void main(String[] args) {
		main(null);	// 재귀 호출
	}
}
