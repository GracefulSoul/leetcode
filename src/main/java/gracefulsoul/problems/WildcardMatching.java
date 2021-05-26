package gracefulsoul.problems;

public class WildcardMatching {

	// https://leetcode.com/submissions/detail/498352383/
	public static void main(String[] args) {
		WildcardMatching test = new WildcardMatching();
		System.out.println(test.isMatch("aa", "a"));
		System.out.println(test.isMatch("aa", "*"));
		System.out.println(test.isMatch("cb", "?a"));
		System.out.println(test.isMatch("adceb", "*a*b"));
		System.out.println(test.isMatch("acdcb", "a*c?b"));
	}

	public boolean isMatch(String s, String p) {
		boolean[][] dp = this.initDp(s, p);
		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < p.length() + 1; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[s.length()][p.length()];
	}
	
	private boolean[][] initDp(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int idx = 1; idx < p.length() + 1; idx++) {
			if (p.charAt(idx - 1) == '*') {
				dp[0][idx] = dp[0][idx - 1];
			}
		}
		return dp;
	}

}
