package gracefulsoul.problems;

public class LongestIdealSubsequence {

	// https://leetcode.com/problems/longest-ideal-subsequence/submissions/1241538282/
	public static void main(String[] args) {
		LongestIdealSubsequence test = new LongestIdealSubsequence();
		System.out.println(test.longestIdealString("acfgbd", 2));
		System.out.println(test.longestIdealString("abcd", 3));
	}

	public int longestIdealString(String s, int k) {
		int[] dp = new int[26];
		int result = 1;
		for (char c : s.toCharArray()) {
			int i = c - 'a';
			dp[i]++;
			for (int j = Math.max(0, i - k); j <= Math.min(25, i + k); j++) {
				if (i != j) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}
		return result;
	}

}
