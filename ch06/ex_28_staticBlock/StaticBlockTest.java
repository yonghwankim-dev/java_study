package ch06.ex_28_staticBlock;

import java.util.Arrays;

/**
 * 초기화 블럭
 * - 명시적 초기화를 통해 배열 arr 생성
 * - 클래스 초기화를 통해서 배열의 각 요소들에 랜덤한 값을 생성
 *
 */
public class StaticBlockTest {
	static int[] arr = new int[10];
	
	static 
	{
		for(int i = 0; i < arr.length; i++)
		{
			// 1~10사이의 값을 저장
			arr[i] = (int) (Math.random() * 10) + 1;
		}
	}
	
	public static void main(String[] args)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
	}
}
