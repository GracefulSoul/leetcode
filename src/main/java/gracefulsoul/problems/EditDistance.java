package gracefulsoul.problems;

public class EditDistance {

	// https://leetcode.com/submissions/detail/510925821/
	public static void main(String[] args) {
		EditDistance test = new EditDistance();
		System.out.println(test.minDistance("horse", "ros"));
		System.out.println(test.minDistance("intention", "execution"));
	}

	public int minDistance(String word1, String word2) {
		int[][] dp = this.initDp(word1.length(), word2.length());
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
	
	private int[][] initDp(int len1, int len2) {
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 0; i < len1; i++) {
			dp[i + 1][0] = i + 1;
		}
		for (int j = 0; j < len2; j++) {
			dp[0][j + 1] = j + 1;
		}
		return dp;
	}

}
