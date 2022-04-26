package ch06.ex_02_instance2;

/**
 * 같은 클래스 타입의 객체이지만
 * tv1과 tv2 참조변수는 서로 다른 객체를 가리키기
 * 때문에 channel 값이 서로 다른 값을 가집니다.
 *
 */
public class Driver {

	public static void main(String[] args) {
		TV tv1 = new TV();
		TV tv2 = new TV();
		
		System.out.println("tv1의 현재 채널 : " + tv1.channel);
		System.out.println("tv2의 현재 채널 : " + tv2.channel);
		
		tv1.channel = 5;
		tv2.channel = 7; 
		
		System.out.println("tv1의 현재 채널 : " + tv1.channel);
		System.out.println("tv2의 현재 채널 : " + tv2.channel);

	}

}
