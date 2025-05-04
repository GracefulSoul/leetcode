package gracefulsoul.problems;

public class ScrambleString {

	// https://leetcode.com/problems/scramble-string/submissions/1625138031/
	public static void main(String[] args) {
		ScrambleString test = new ScrambleString();
		System.out.println(test.isScramble("great", "rgeat"));
		System.out.println(test.isScramble("abcde", "caebd"));
		System.out.println(test.isScramble("a", "a"));
	}

	public boolean isScramble(String s1, String s2) {
		int length = s1.length();
		boolean[][][] dp = new boolean[length][length][length + 1];
		for (int k = 1; k <= length; k++) {
			for (int i = 0; i + k <= length; i++) {
				for (int j = 0; j + k <= length; j++) {
					if (k == 1) {
						dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
					} else {
						for (int l = 1; l < k && !dp[i][j][k]; ++l) {
							dp[i][j][k] = (dp[i][j][l] && dp[i + l][j + l][k - l]) || (dp[i][j + k - l][l] && dp[i + l][j][k - l]);
						}
					}
				}
			}
		}
		return dp[0][0][length];
	}

}
