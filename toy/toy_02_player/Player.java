package toy.toy_02_player;

public abstract class Player {
	boolean pause;	// ���/�Ͻ�����
	int currentPos;	// ���� ����ǰ� �ִ� ��ġ
	
	Player(){
		pause = false;
		currentPos = 0;
	}
	
	// ������ ��ġ(pos)���� ����� �����ϴ� ����� �����ϵ��� �ۼ��Ǿ����
	abstract void play(int pos);	// �߻� �޼���
	
	// ����� ��� ���ߴ� ����� �����ϵ��� �ۼ��Ǿ����
	abstract void stop(); // �߻� �޼���
	
	// ���� ��ġ���� ��� ����
	void play() {
		play(currentPos);
	}
	
	// ���� ��ġ���� ���� �Ǵ� ����
	void pause() {
		if(pause) {	// pause�� true�̸� play
			pause = false;
			play(currentPos);
		}
		else {		// pause�� false�̸� stop
			pause = true;
			stop();
		}
	}
}
