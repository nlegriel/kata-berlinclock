package fr.craftyourskills.berlinclock;

import java.util.ArrayList;
import java.util.List;

public class BerlinClock {

	private static final String OFF = "O";
	private static final String RED = "R";
	private static final String YELLOW = "Y";

	public static List<String> display(String time) {
		List<String> result = new ArrayList<>();

		setSeconsRow(time, result);
		set5HoursRow(time, result);
		setUnitHours(time, result);
		setUnitMinutes(time, result);

		return result;
	}

	private static void setSeconsRow(String time, List<String> result) {
		if (isEvenSeconds(time)) {
			result.add(YELLOW);
		} else {
			result.add(OFF);
		}
	}

	private static void set5HoursRow(String time, List<String> result) {
		String pattern = OFF.repeat(4);

		int hours = getHours(time);

		for (int i = 0; i < hours / 5; i++) {
			pattern = pattern.replaceFirst(OFF, RED);
		}

		result.add(pattern);
	}

	private static void setUnitHours(String time, List<String> result) {
		String pattern = OFF.repeat(4);

		int hours = getHours(time);

		for (int i = 0; i < hours % 5; i++) {
			pattern = pattern.replaceFirst(OFF, RED);
		}

		result.add(pattern);
	}

	private static void setUnitMinutes(String time, List<String> result) {
		String pattern = OFF.repeat(4);

		int minutes = getMinutes(time);

		for (int i = 0; i < minutes % 5; i++) {
			pattern = pattern.replaceFirst(OFF, YELLOW);
		}

		result.add("");
		result.add(pattern);
	}

	private static boolean isEvenSeconds(String time) {
		return getSeconds(time) % 2 == 0;
	}

	private static int getHours(String time) {
		return Integer.parseInt(time.split(":")[0]);
	}

	private static int getMinutes(String time) {
		return Integer.parseInt(time.split(":")[1]);
	}

	private static int getSeconds(String time) {
		return Integer.parseInt(time.split(":")[2]);
	}
}
