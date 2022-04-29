package ch07.ex_04_singleInheritance;

/**
 * 단일 상속
 * - 자바는 다중상속을 금지함
 * - 포함하고 싶은 클래스를 멤버 변수로 포함시키고 포함한 클래스의 메서드를
 * 똑같이 선언하고 내용은 포함한 클래스의 메서드를 호출시킴 
 * - VCR 메서드의 내용이 변경되면 TVCR 클래스의 메서드들 역시
 * 변경된 내용이 적용되는 결과를 얻을 수 있음
 */
public class TVCR extends TV{
	VCR vcr = new VCR();
	
	public void play() {
		vcr.play();
	}
	public void stop() {
		vcr.stop();
	}
	public void rew() {
		vcr.rew();
	}
	public void ff() {
		vcr.ff();
	}
}
