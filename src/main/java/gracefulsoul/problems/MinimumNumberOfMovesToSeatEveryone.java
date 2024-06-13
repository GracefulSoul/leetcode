package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {

	// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/submissions/1286834289/
	public static void main(String[] args) {
		MinimumNumberOfMovesToSeatEveryone test = new MinimumNumberOfMovesToSeatEveryone();
		System.out.println(test.minMovesToSeat(new int[] { 3, 1, 5 }, new int[] { 2, 7, 4 }));
		System.out.println(test.minMovesToSeat(new int[] { 4, 1, 5, 9 }, new int[] { 1, 3, 2, 6 }));
		System.out.println(test.minMovesToSeat(new int[] { 2, 2, 6, 6 }, new int[] { 1, 3, 2, 6 }));
	}

	public int minMovesToSeat(int[] seats, int[] students) {
		Arrays.sort(seats);
		Arrays.sort(students);
		int result = 0;
		for (int i = 0; i < seats.length; i++) {
			result += Math.abs(seats[i] - students[i]);
		}
		return result;
	}

}
