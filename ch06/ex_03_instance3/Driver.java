package ch06.ex_03_instance3;

/**
 * tv2 = tv1
 * tv1이 가리키고 있는 주소를 tv2가 가리키게 함
 * 
 * 기존 tv2가 가리키고 있는 객체는 가비지 컬렉터에 의해 제거됨
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
		
		tv2 = tv1;	// tv2가 tv1이 가리키고 있는 객체를 가리킴

		System.out.println("tv1의 현재 채널 : " + tv1.channel);
		System.out.println("tv2의 현재 채널 : " + tv2.channel);
	}

}
