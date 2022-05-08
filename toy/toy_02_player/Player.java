package toy.toy_02_player;

public abstract class Player {
	boolean pause;	// 재생/일시정지
	int currentPos;	// 현재 재생되고 있는 위치
	
	Player(){
		pause = false;
		currentPos = 0;
	}
	
	// 지정된 위치(pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야함
	abstract void play(int pos);	// 추상 메서드
	
	// 재생을 즉시 멈추는 기능을 수행하도록 작성되어야함
	abstract void stop(); // 추상 메서드
	
	// 현재 위치에서 재생 시작
	void play() {
		play(currentPos);
	}
	
	// 현재 위치에서 시작 또는 중지
	void pause() {
		if(pause) {	// pause가 true이면 play
			pause = false;
			play(currentPos);
		}
		else {		// pause가 false이면 stop
			pause = true;
			stop();
		}
	}
}
