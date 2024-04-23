package gracefulsoul.problems;

public class ShortestCommonSupersequence {

	// https://leetcode.com/problems/shortest-common-supersequence/submissions/1239768789/
	public static void main(String[] args) {
		ShortestCommonSupersequence test = new ShortestCommonSupersequence();
		System.out.println(test.shortestCommonSupersequence("abac", "cab"));
		System.out.println(test.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));
	}

	public String shortestCommonSupersequence(String str1, String str2) {
		int str1Length = str1.length();
		int str2Length = str2.length();
		char[] str1CharArray = str1.toCharArray();
		char[] str2CharArray = str2.toCharArray();
		int[][] dp = new int[str1Length + 1][str2Length + 1];
		for (int i = str1Length - 1; i >= 0; i--) {
			for (int j = str2Length - 1; j >= 0; j--) {
				if (str1CharArray[i] == str2CharArray[j]) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = 0; i < str1Length || j < str2Length;) {
			if (i < str1Length ^ j < str2Length) {
				sb.append(i < str1Length ? str1CharArray[i++] : str2CharArray[j++]);
			} else if (str1CharArray[i] == str2CharArray[j]) {
				sb.append(str1CharArray[i++]);
				++j;
			} else {
				sb.append(dp[i + 1][j] > dp[i][j + 1] ? str1CharArray[i++] : str2CharArray[j++]);
			}
		}
		return sb.toString();
	}

}
