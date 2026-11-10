package gracefulsoul.problems;

public class ClimbingStairsII {

	// https://leetcode.com/problems/climbing-stairs-ii/submissions/2193080004/
	public static void main(String[] args) {
		ClimbingStairsII test = new ClimbingStairsII();
		System.out.println(test.climbStairs(4, new int[] { 1, 2, 3, 4 }));
		System.out.println(test.climbStairs(4, new int[] { 5, 1, 6, 2 }));
		System.out.println(test.climbStairs(3, new int[] { 9, 8, 3 }));
	}

	public int climbStairs(int n, int[] costs) {
		int[] dp = new int[3];
		for (int i = 0, j; i < costs.length; i++) {
			int cost = costs[i];
			j = Math.min(Math.min(dp[0] + 9, dp[1] + 4), dp[2] + 1) + cost;
			dp[0] = dp[1];
			dp[1] = dp[2];
			dp[2] = j;
		}
		return dp[2];
	}

}
