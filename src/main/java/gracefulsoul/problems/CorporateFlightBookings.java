package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class CorporateFlightBookings {

	// https://leetcode.com/problems/corporate-flight-bookings/submissions/1263872939/
	public static void main(String[] args) {
		CorporateFlightBookings test = new CorporateFlightBookings();
		PrintUtil.print(test.corpFlightBookings(new int[][] {
			{ 1, 2, 10 },
			{ 2, 3, 20 },
			{ 2, 5, 25 }
		}, 5));
		PrintUtil.print(test.corpFlightBookings(new int[][] {
			{ 1, 2, 10 },
			{ 2, 2, 15 }
		}, 2));
	}

	public int[] corpFlightBookings(int[][] bookings, int n) {
		int[] result = new int[n];
		for (int[] booking : bookings) {
			result[booking[0] - 1] += booking[2];
			if (booking[1] < n) {
				result[booking[1]] -= booking[2];
			}
		}
		for (int i = 1; i < n; i++) {
			result[i] += result[i - 1];
		}
		return result;
	}

}
