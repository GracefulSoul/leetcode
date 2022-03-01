package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

	// https://leetcode.com/submissions/detail/651040839/
	public static void main(String[] args) {
		BinaryWatch test = new BinaryWatch();
		System.out.println(test.readBinaryWatch(1));
		System.out.println(test.readBinaryWatch(9));
	}

	public List<String> readBinaryWatch(int turnedOn) {
		List<String> times = new ArrayList<>();
		for (int hour = 0; hour < 12; hour++) {
			for (int minute = 0; minute < 60; minute++) {
				int bits = Integer.bitCount(hour) + Integer.bitCount(minute);
				if (bits == turnedOn) {
					times.add(this.getTime(hour, minute));
				}
			}
		}
		return times;
	}

	private String getTime(int hour, int minute) {
		return new StringBuilder().append(hour).append(":").append(minute / 10).append(minute % 10).toString();
	}

}
