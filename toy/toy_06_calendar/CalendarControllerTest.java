package toy.toy_06_calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
