package gracefulsoul.problems;

public class FindAllPossibleStableBinaryArraysI {

	// https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/submissions/1942806470/
	public static void main(String[] args) {
		FindAllPossibleStableBinaryArraysI test = new FindAllPossibleStableBinaryArraysI();
		System.out.println(test.numberOfStableArrays(1, 1, 2));
		System.out.println(test.numberOfStableArrays(1, 2, 1));
		System.out.println(test.numberOfStableArrays(3, 3, 2));
	}

	public int numberOfStableArrays(int zero, int one, int limit) {
		int mod = 1000000007;
		int[][][] dp = new int[one + 1][zero + 1][2];
		for (int i = 1; i <= Math.min(one, limit); i++) {
			dp[i][0][1] = 1;
		}
		for (int j = 1; j <= Math.min(zero, limit); j++) {
			dp[0][j][0] = 1;
		}
		for (int i = 1; i <= one; i++) {
			for (int j = 1; j <= zero; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				dp[i][j][0] = dp[i][j - 1][1];
				dp[i][j][0] = (dp[i][j][0] + dp[i][j - 1][0]) % mod;
				if (j - limit - 1 >= 0) {
					dp[i][j][0] = (dp[i][j][0] - dp[i][j - limit - 1][1] + mod) % mod;
				}
				dp[i][j][1] = dp[i - 1][j][0];
				dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j][1]) % mod;
				if (i - limit - 1 >= 0) {
					dp[i][j][1] = (dp[i][j][1] - dp[i - limit - 1][j][0] + mod) % mod;
				}
			}
		}
		return (dp[one][zero][0] + dp[one][zero][1]) % mod;
	}

}
