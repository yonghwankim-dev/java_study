package toy.toy_06_calendar;

import org.junit.Before;
import org.junit.Test;

class CalendarControllerTest {
	private CalendarController c;
	
	@Before
	void setUp() {
		this.c = new CalendarController();
	}
	
	@Test
	void test() {
		c.start();
	}
}
