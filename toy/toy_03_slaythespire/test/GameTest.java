package toy.toy_03_slaythespire.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import toy.toy_03_slaythespire.Game;
import toy.toy_03_slaythespire.unit.Hero;

class GameTest {

	private Game game;
	
	@BeforeEach
	void setup() {
		game = new Game(new Hero(80));
	}
	
	@Test
	void drawTest() {
		game.play();
	}
}
