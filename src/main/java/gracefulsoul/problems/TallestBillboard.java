package gracefulsoul.problems;

public class TallestBillboard {

	// https://leetcode.com/problems/tallest-billboard/submissions/978211296/
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
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j <= sum; j++) {
				if (dp[i - 1][j] < j) {
					continue;
				}
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
				int k = j + rods[i - 1];
				dp[i][k] = Math.max(dp[i][k], dp[i - 1][j] + rods[i - 1]);
				k = Math.abs(j - rods[i - 1]);
				dp[i][k] = Math.max(dp[i][k], dp[i - 1][j] + rods[i - 1]);
			}
		}
		return dp[length][0] / 2;
	}

}
