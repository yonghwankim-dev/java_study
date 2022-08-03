package toy.toy_03_slaythespire.test;

import org.junit.Before;
import org.junit.Test;
import toy.toy_03_slaythespire.Game;
import toy.toy_03_slaythespire.unit.Hero;

class GameTest {

	private Game game;
	
	@Before
	void setup() {
		game = new Game(new Hero(80));
	}
	
	@Test
	void drawTest() {
		game.play();
	}
}
