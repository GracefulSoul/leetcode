package gracefulsoul.problems;

public class ShortestCommonSupersequence {

	// https://leetcode.com/problems/shortest-common-supersequence/submissions/1239755784/
	public static void main(String[] args) {
		ShortestCommonSupersequence test = new ShortestCommonSupersequence();
		System.out.println(test.shortestCommonSupersequence("abac", "cab"));
		System.out.println(test.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));
	}

	public String shortestCommonSupersequence(String str1, String str2) {
		int row = str1.length();
		int col = str2.length();
		char[] str1CharArray = str1.toCharArray();
		char[] str2CharArray = str2.toCharArray();
		int[][] dp = new int[row + 1][col + 1];
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (str1CharArray[i] == str2CharArray[j]) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = 0; i < row || j < col;) {
			if (i < row ^ j < col) {
				sb.append(i < row ? str1CharArray[i++] : str2CharArray[j++]);
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
