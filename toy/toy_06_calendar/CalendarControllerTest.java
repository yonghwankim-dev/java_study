package toy.toy_06_calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalendarControllerTest {
	private CalendarController c;
	
	@BeforeEach
	void setUp() {
		this.c = new CalendarController();
	}
	
	@Test
	void test() {
		c.start();
	}
}
