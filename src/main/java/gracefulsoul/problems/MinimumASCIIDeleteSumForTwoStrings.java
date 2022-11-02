package gracefulsoul.problems;

public class MinimumASCIIDeleteSumForTwoStrings {

	// https://leetcode.com/submissions/detail/835302563/
	public static void main(String[] args) {
		MinimumASCIIDeleteSumForTwoStrings test = new MinimumASCIIDeleteSumForTwoStrings();
		System.out.println(test.minimumDeleteSum("sea", "eat"));
		System.out.println(test.minimumDeleteSum("delete", "leet"));
	}

	public int minimumDeleteSum(String s1, String s2) {
		int s1Length = s1.length();
		int s2Length = s2.length();
		char[] s1CharArray = s1.toCharArray();
		char[] s2CharArray = s2.toCharArray();
		int s1Sum = 0;
		int s2Sum = 0;
		int[][] dp = new int[s1Length + 1][s2Length + 1];
		dp[0][0] = 0;
		for (int i = 0; i < s1Length; i++) {
			s1Sum += s1CharArray[i];
			for (int j = 0; j < s2Length; j++) {
				if (i == 0) {
					s2Sum += s2CharArray[j];
				}
				dp[i + 1][j + 1] = s1CharArray[i] == s2CharArray[j] ? dp[i][j] + s1CharArray[i] : Math.max(dp[i][j + 1], dp[i + 1][j]);
			}
		}
		return s1Sum + s2Sum - (2 * dp[s1Length][s2Length]);
	}

}
