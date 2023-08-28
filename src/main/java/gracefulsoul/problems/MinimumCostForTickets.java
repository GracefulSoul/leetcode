package gracefulsoul.problems;

public class MinimumCostForTickets {

	// https://leetcode.com/problems/minimum-cost-for-tickets/submissions/1034004373/
	public static void main(String[] args) {
		MinimumCostForTickets test = new MinimumCostForTickets();
		System.out.println(test.mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 }));
		System.out.println(test.mincostTickets(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, new int[] { 2, 7, 15 }));
	}

	public int mincostTickets(int[] days, int[] costs) {
		int last = days[days.length - 1];
		boolean[] planned = new boolean[last + 1];
		for (int day : days) {
			planned[day] = true;
		}
		int[] dp = new int[last + 1];
		for (int i = 1; i <= last; i++) {
			if (!planned[i]) {
				dp[i] = dp[i - 1];
				continue;
			}
			dp[i] = dp[i - 1] + costs[0];
			dp[i] = Math.min(dp[i], dp[Math.max(i - 7, 0)] + costs[1]);
			dp[i] = Math.min(dp[i], dp[Math.max(i - 30, 0)] + costs[2]);
		}
		return dp[last];
	}

}
