package gracefulsoul.problems;

public class MinCostClimbingStairs {

	// https://leetcode.com/submissions/detail/853663482/
	public static void main(String[] args) {
		MinCostClimbingStairs test = new MinCostClimbingStairs();
		System.out.println(test.minCostClimbingStairs(new int[] { 10, 15, 20 }));
		System.out.println(test.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
	}

	public int minCostClimbingStairs(int[] cost) {
		int length = cost.length;
		int[] dp = new int[length];
		dp[0] = cost[0];
		dp[1] = cost[1];
		for (int idx = 2; idx < length; idx++) {
			dp[idx] = Math.min(dp[idx - 1], dp[idx - 2]) + cost[idx];
		}
		return Math.min(dp[length - 1], dp[length - 2]);
	}

}
