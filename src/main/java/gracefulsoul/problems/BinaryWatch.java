package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

	// https://leetcode.com/problems/binary-watch/submissions/1921693601/
	public static void main(String[] args) {
		BinaryWatch test = new BinaryWatch();
		System.out.println(test.readBinaryWatch(1));
		System.out.println(test.readBinaryWatch(9));
	}

	public List<String> readBinaryWatch(int turnedOn) {
		List<String> times = new ArrayList<>();
		for (int hour = 0; hour < 12; hour++) {
			for (int minute = 0; minute < 60; minute++) {
				if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
					times.add(hour + ":" + (minute / 10) + (minute % 10));
				}
			}
		}
		return times;
	}

}
