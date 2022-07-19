package gracefulsoul.problems;

public class DeleteOperationForTwoStrings {

	// https://leetcode.com/submissions/detail/750147526/
	public static void main(String[] args) {
		DeleteOperationForTwoStrings test = new DeleteOperationForTwoStrings();
		System.out.println(test.minDistance("sea", "eat"));
		System.out.println(test.minDistance("leetcode", "etco"));
	}

	public int minDistance(String word1, String word2) {
		int word1Length = word1.length();
		int word2Length = word2.length();
		char[] word1CharArray = word1.toCharArray();
		char[] word2CharArray = word2.toCharArray();
		int dp[][] = new int[word1Length + 1][word2Length + 1];
		for (int i = 0; i <= word1Length; i++) {
			for (int j = 0; j <= word2Length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = (word1CharArray[i - 1] == word2CharArray[j - 1]) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return word1Length + word2Length - (2 * dp[word1Length][word2Length]);
	}

}
