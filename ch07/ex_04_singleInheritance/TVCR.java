package ch07.ex_04_singleInheritance;

/**
 * ���� ���
 * - �ڹٴ� ���߻���� ������
 * - �����ϰ� ���� Ŭ������ ��� ������ ���Խ�Ű�� ������ Ŭ������ �޼��带
 * �Ȱ��� �����ϰ� ������ ������ Ŭ������ �޼��带 ȣ���Ŵ 
 * - VCR �޼����� ������ ����Ǹ� TVCR Ŭ������ �޼���� ����
 * ����� ������ ����Ǵ� ����� ���� �� ����
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
