package ch07.ex_04_singleInheritance;

public class VCR {
	boolean power;	// 전원상태(on/off)
	int counter = 0;
	public void power() {
		power = !power;
	}
	public void play() {
		System.out.println("call play");
	}
	public void stop() {
		System.out.println("call stop");
	}
	public void rew() {
		System.out.println("call rew");	
	}
	public void ff() {
		System.out.println("call ff");	
	}
}
