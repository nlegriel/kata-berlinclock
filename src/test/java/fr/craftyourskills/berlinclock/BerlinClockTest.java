package fr.craftyourskills.berlinclock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Index.atIndex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BerlinClockTest {

	@Test
	@DisplayName("should have off for odd seconds")
	void oddSeconds() {
		assertThat(BerlinClock.display("11:45:11")).contains("O", atIndex(0));
		assertThat(BerlinClock.display("11:34:15")).contains("O", atIndex(0));
	}

	@Test
	@DisplayName("should have off for even seconds")
	void evenSeconds() {
		assertThat(BerlinClock.display("21:45:10")).contains("Y", atIndex(0));
		assertThat(BerlinClock.display("08:45:12")).contains("Y", atIndex(0));
	}

	@Test
	@DisplayName("should create hours row")
	void hours() {
		assertThat(BerlinClock.display("00:45:10")).contains("OOOO", atIndex(1));
		assertThat(BerlinClock.display("04:45:10")).contains("OOOO", atIndex(1));
		assertThat(BerlinClock.display("05:35:10")).contains("ROOO", atIndex(1));
		assertThat(BerlinClock.display("07:35:10")).contains("ROOO", atIndex(1));
		assertThat(BerlinClock.display("10:45:10")).contains("RROO", atIndex(1));
		assertThat(BerlinClock.display("12:45:10")).contains("RROO", atIndex(1));
		assertThat(BerlinClock.display("15:45:12")).contains("RRRO", atIndex(1));
		assertThat(BerlinClock.display("16:45:12")).contains("RRRO", atIndex(1));
		assertThat(BerlinClock.display("20:45:10")).contains("RRRR", atIndex(1));
		assertThat(BerlinClock.display("21:45:10")).contains("RRRR", atIndex(1));
	}

	@Test
	@DisplayName("should create unit hours row")
	void unitHours() {
		assertThat(BerlinClock.display("00:45:10")).contains("OOOO", atIndex(2));
		assertThat(BerlinClock.display("01:45:10")).contains("ROOO", atIndex(2));
		assertThat(BerlinClock.display("02:45:10")).contains("RROO", atIndex(2));
		assertThat(BerlinClock.display("03:45:10")).contains("RRRO", atIndex(2));
		assertThat(BerlinClock.display("04:45:10")).contains("RRRR", atIndex(2));
		assertThat(BerlinClock.display("05:45:10")).contains("OOOO", atIndex(2));
	}

	@Test
	@DisplayName("should create unit minutes row")
	void unitMinutes() {
		assertThat(BerlinClock.display("00:00:10")).contains("OOOO", atIndex(4));
		assertThat(BerlinClock.display("01:01:10")).contains("YOOO", atIndex(4));
		assertThat(BerlinClock.display("02:02:10")).contains("YYOO", atIndex(4));
		assertThat(BerlinClock.display("03:03:10")).contains("YYYO", atIndex(4));
		assertThat(BerlinClock.display("04:04:10")).contains("YYYY", atIndex(4));
		assertThat(BerlinClock.display("05:05:10")).contains("OOOO", atIndex(4));
	}
}
