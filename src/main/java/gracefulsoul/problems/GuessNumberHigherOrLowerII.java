package gracefulsoul.problems;

public class GuessNumberHigherOrLowerII {

	// https://leetcode.com/submissions/detail/634106744/
	public static void main(String[] args) {
		GuessNumberHigherOrLowerII test = new GuessNumberHigherOrLowerII();
		System.out.println(test.getMoneyAmount(10));
		System.out.println(test.getMoneyAmount(1));
		System.out.println(test.getMoneyAmount(2));
	}

	public int getMoneyAmount(int n) {
		int[][] dp = new int[n + 1][n + 1];
		return this.recursive(dp, 1, n);
	}

	private int recursive(int[][] dp, int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (dp[i][j] > 0) {
			return dp[i][j];
		}
		dp[i][j] = Integer.MAX_VALUE;
		int init = (i + j) / 2;
		for (int k = init; k < j; ++k) {
			int low = this.recursive(dp, i, k - 1);
			int high = this.recursive(dp, k + 1, j);
			dp[i][j] = Math.min(dp[i][j], k + Math.max(low, high));
			if (low >= high) {
				break;
			}
		}
		return dp[i][j];
	}

}
