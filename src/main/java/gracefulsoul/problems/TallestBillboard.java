package gracefulsoul.problems;

public class TallestBillboard {

	// https://leetcode.com/problems/tallest-billboard/submissions/978215265/
	public static void main(String[] args) {
		TallestBillboard test = new TallestBillboard();
		System.out.println(test.tallestBillboard(new int[] { 1, 2, 3, 6 }));
		System.out.println(test.tallestBillboard(new int[] { 1, 2, 3, 4, 5, 6 }));
		System.out.println(test.tallestBillboard(new int[] { 1, 2 }));
	}

	public int tallestBillboard(int[] rods) {
		int length = rods.length;
		int sum = 0;
		for (int rod : rods) {
			sum += rod;
		}
		int[][] dp = new int[length + 1][sum + 1];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j <= sum; j++) {
				if (dp[i][j] < j) {
					continue;
				}
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
				int k = j + rods[i];
				dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][j] + rods[i]);
				k = Math.abs(j - rods[i]);
				dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][j] + rods[i]);
			}
		}
		return dp[length][0] / 2;
	}

}
