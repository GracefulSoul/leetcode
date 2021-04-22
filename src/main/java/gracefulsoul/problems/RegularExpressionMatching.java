package gracefulsoul.problems;

public class RegularExpressionMatching {

	// https://leetcode.com/submissions/detail/481648922/
	public static void main(String[] args) {
		RegularExpressionMatching test = new RegularExpressionMatching();
		System.out.println(test.isMatch("aa", "a"));
		System.out.println(test.isMatch("aa", "a*"));
		System.out.println(test.isMatch("ab", ".*"));
		System.out.println(test.isMatch("aab", "c*a*b"));
		System.out.println(test.isMatch("mississippi", "mis*is*p*."));
	}

	public boolean isMatch(String s, String p) {
		if (this.isBlank(p)) {
			return this.isBlank(s);
		}
		boolean[][] dp = this.initDp(s, p);
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
					dp[i + 1][j + 1] = dp[i][j];
				} else if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}

	private boolean isBlank(String s) {
		return s == null || s.length() == 0;
	}

	private boolean[][] initDp(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i < p.length(); i+=2) {
			dp[0][i + 1] = p.charAt(i) == '*' && dp[0][i - 1];
		}
		return dp;
	}

}
