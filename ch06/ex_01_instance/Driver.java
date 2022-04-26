package ch06.ex_01_instance;

public class Driver {

	public static void main(String[] args) {
		TV tv = new TV();
		
		tv.color = "red";
		tv.channel = 10;
		tv.power = true;
		
		System.out.println("현재 채널 : " + tv.channel);

	}

}
