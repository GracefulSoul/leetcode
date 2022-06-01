package gracefulsoul.problems;

public class LongestPalindromicSubsequence {

	// https://leetcode.com/submissions/detail/711659468/
	public static void main(String[] args) {
		LongestPalindromicSubsequence test = new LongestPalindromicSubsequence();
		System.out.println(test.longestPalindromeSubseq("bbbab"));
		System.out.println(test.longestPalindromeSubseq("cbbd"));
	}

	public int longestPalindromeSubseq(String s) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int max = 0;
		int[] dp = new int[length];
		for (int j = 0; j < length; j++) {
			dp[j] = 1;
			max = 0;
			for (int i = j - 1; i >= 0; i--) {
				int len = dp[i];
				if (charArray[i] == charArray[j]) {
					dp[i] = 2 + max;
				}
				max = Math.max(max, len);
			}
		}
		for (int len : dp) {
			max = Math.max(max, len);
		}
		return max;
	}

}
