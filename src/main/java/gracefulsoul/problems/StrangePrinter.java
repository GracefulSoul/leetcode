package gracefulsoul.problems;

public class StrangePrinter {

	// https://leetcode.com/submissions/detail/802475396/
	public static void main(String[] args) {
		StrangePrinter test = new StrangePrinter();
		System.out.println(test.strangePrinter("aaabbb"));
		System.out.println(test.strangePrinter("aba"));
	}

	public int strangePrinter(String s) {
		int length = s.length();
		int[][] dp = new int[length][length];
		for (int idx = 0; idx < length; idx++) {
			dp[idx][idx] = 1;
			if (idx + 1 < length) {
				dp[idx][idx + 1] = s.charAt(idx) == s.charAt(idx + 1) ? 1 : 2;
			}
		}
		for (int l = 3; l <= length; l++) {
			for (int i = 0; i <= length - l; i++) {
				int j = i + l - 1;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
				}
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j]--;
				}
			}
		}
		return dp[0][length - 1];
	}

}
