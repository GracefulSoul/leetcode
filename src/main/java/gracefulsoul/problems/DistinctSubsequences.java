package gracefulsoul.problems;

public class DistinctSubsequences {

	// https://leetcode.com/submissions/detail/533736857/
	public static void main(String[] args) {
		DistinctSubsequences test = new DistinctSubsequences();
		System.out.println(test.numDistinct("rabbbit", "rabbit"));
		System.out.println(test.numDistinct("babgbag", "bag"));
	}

	public int numDistinct(String s, String t) {
		int[][] dp = this.initDp(s.length(), t.length());
		for (int j = 1; j < t.length() + 1; j++) {
			for (int i = 1; i < s.length() + 1; i++) {
				dp[i][j] = dp[i - 1][j];
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		return dp[s.length()][t.length()];
	}

	private int[][] initDp(int row, int col) {
		int[][] dp = new int[row + 1][col + 1];
		for (int i = 0; i < row + 1; i++) {
			dp[i][0] = 1;
		}
		return dp;
	}

}
