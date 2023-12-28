package gracefulsoul.problems;

public class StringCompressionII {

	// https://leetcode.com/problems/string-compression-ii/submissions/1130165800/
	public static void main(String[] args) {
		StringCompressionII test = new StringCompressionII();
		System.out.println(test.getLengthOfOptimalCompression("aaabcccd", 2));
		System.out.println(test.getLengthOfOptimalCompression("aabbaa", 2));
		System.out.println(test.getLengthOfOptimalCompression("aaaaaaaaaaa", 0));
	}

	public int getLengthOfOptimalCompression(String s, int k) {
		char[] charArray = s.toCharArray();
		int length = s.length();
		int[][] dp = new int[110][110];
		for (int i = 0; i <= length; i++) {
			for (int j = 0; j <= length; j++) {
				dp[i][j] = 9999;
			}
		}
		dp[0][0] = 0;
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j <= k; j++) {
				int count = 0;
				int delete = 0;
				for (int l = i; l >= 1; l--) {
					if (charArray[l - 1] == charArray[i - 1]) {
						count++;
					} else {
						delete++;
					}
					if (j - delete >= 0) {
						dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - delete] + 1 + (count >= 100 ? 3 : count >= 10 ? 2 : count >= 2 ? 1 : 0));
					}
				}
				if (j > 0) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
				}
			}
		}
		return dp[length][k];
	}

}
