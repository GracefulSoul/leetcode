package gracefulsoul.problems;

public class RegularExpressionMatching {

	// https://leetcode.com/submissions/detail/481648922/
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("mississippi", "mis*is*p*."));
	}

	public static boolean isMatch(String s, String p) {
		if (isBlank(p)) {
			return isBlank(s);
		}
		boolean[][] dp = initDp(s, p);
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

	private static boolean isBlank(String s) {
		return s == null || s.length() == 0;
	}

	private static boolean[][] initDp(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i < p.length(); i+=2) {
			dp[0][i + 1] = p.charAt(i) == '*' && dp[0][i - 1];
		}
		return dp;
	}

}
