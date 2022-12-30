package gracefulsoul.problems;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {

	// https://leetcode.com/problems/cheapest-flights-within-k-stops/submissions/867834812/
	public static void main(String[] args) {
		CheapestFlightsWithinKStops test = new CheapestFlightsWithinKStops();
		System.out.println(test.findCheapestPrice(4, new int[][] {
			{ 0, 1, 100 },
			{ 1, 2, 100 },
			{ 2, 0, 100 },
			{ 1, 3, 600 },
			{ 2, 3, 200 }
		}, 0, 3, 1));
		System.out.println(test.findCheapestPrice(3, new int[][] {
			{ 0, 1, 100 },
			{ 1, 2, 100 },
			{ 0, 2, 500 }
		}, 0, 2, 1));
		System.out.println(test.findCheapestPrice(3, new int[][] {
			{ 0, 1, 100 },
			{ 1, 2, 100 },
			{ 0, 2, 500 }
		}, 0, 2, 0));
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[src] = 0;
		while (k-- >= 0) {
			if (this.isExistsRoute(flights, dp)) {
				break;
			}
		}
		return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
	}

	private boolean isExistsRoute(int[][] flights, int[] dp) {
		int[] temp = Arrays.copyOf(dp, dp.length);
		boolean result = true;
		for (int[] flight : flights) {
			int src = flight[0];
			int dst = flight[1];
			int cost = flight[2];
			if (temp[src] < Integer.MAX_VALUE && dp[dst] > dp[src] + cost) {
				dp[dst] = cost + temp[src];
				result = false;
			}
		}
		return result;
	}

}
