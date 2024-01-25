package gracefulsoul.problems;

public class LongestCommonSubsequence {

	// https://leetcode.com/problems/longest-common-subsequence/submissions/1156390889/
	public static void main(String[] args) {
		LongestCommonSubsequence test = new LongestCommonSubsequence();
		System.out.println(test.longestCommonSubsequence("abcde", "ace"));
		System.out.println(test.longestCommonSubsequence("abc", "abc"));
		System.out.println(test.longestCommonSubsequence("abc", "def"));
	}

	public int longestCommonSubsequence(String text1, String text2) {
		char[] text1CharArray = text1.toCharArray();
		char[] text2CharArray = text2.toCharArray();
		int text1Length = text1CharArray.length;
		int text2Length = text2CharArray.length;
		int[][] dp = new int[text1Length + 1][text2Length + 1];
		for (int i = 1; i <= text1Length; i++) {
			for (int j = 1; j <= text2Length; j++) {
				if (text1CharArray[i - 1] == text2CharArray[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[text1Length][text2Length];
	}

}
