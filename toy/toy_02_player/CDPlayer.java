package toy.toy_02_player;

public class CDPlayer extends Player{

	int currentTrack;	// 현재 재생중인 트랙
	
	static class Shutdown implements Runnable{
		CDPlayer player;
		
		public Shutdown(CDPlayer player) {
			this.player = player;
		}
		
		@Override
		public void run() {
			player.stop();
		}
	}

	
	@Override
	void play(int pos) {
		Runtime runtime = Runtime.getRuntime();
		
		currentTrack = pos;
		
		runtime.addShutdownHook(new Thread(new Shutdown(this)));
		
		while(true) {
			try {
				System.out.printf("currentTrack : %d\n", currentTrack);
				nextTrack();
				
				if(currentTrack == 101) {
					System.out.println("재생이 완료되었습니다.");
					currentTrack = 0;
					break;
				}
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				stop();
				break;
			}
		}
	}

	@Override
	void stop() {
		System.out.println("재생 정지");
	}

	void nextTrack() {
		currentTrack++;
	}
	
	void preTrack() {
		if(currentTrack > 1) {
			currentTrack--;
		}
	}
}
