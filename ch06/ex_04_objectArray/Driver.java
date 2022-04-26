package ch06.ex_04_objectArray;

/**
 * 객체 배열은 참조변수들을 하나로 묶은 참조변수배열
 * 각각의 원소에 대해서 객체를 생성하여야함 
 */
public class Driver {

	public static void main(String[] args) {
		// 객체 배열 선언
		TV[] tvArr = new TV[3];
		
		// 객체 배열의 각각의 원소에 객체 생성
		for(int i = 0; i < 3; i++)
		{
			tvArr[i] = new TV();
			tvArr[i].channel = i+10;
		}
		
		// 객체 배열의 각각의 원소의 메서드 수행
		for(int i = 0; i < 3; i++)
		{
			tvArr[i].channelUp();
			System.out.printf("tvArr[%d].channel = %d\n", i,tvArr[i].channel);
		}
		
	}

}
