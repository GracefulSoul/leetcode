package gracefulsoul.problems;

public class FindAllPossibleStableBinaryArraysI {

	// https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/submissions/1943780379/
	public static void main(String[] args) {
		FindAllPossibleStableBinaryArraysI test = new FindAllPossibleStableBinaryArraysI();
		System.out.println(test.numberOfStableArrays(1, 1, 2));
		System.out.println(test.numberOfStableArrays(1, 2, 1));
		System.out.println(test.numberOfStableArrays(3, 3, 2));
	}

	public int numberOfStableArrays(int zero, int one, int limit) {
		int mod = 1000000007;
		int[][][] dp = new int[zero + 1][one + 1][2];
		for (int i = 1; i <= Math.min(zero, limit); i++) {
			dp[i][0][0] = 1;
		}
		for (int j = 1; j <= Math.min(one, limit); j++) {
			dp[0][j][1] = 1;
		}
		for (int i = 1; i <= zero; i++) {
			for (int j = 1; j <= one; j++) {
				dp[i][j][0] = dp[i - 1][j][1];
				dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][0]) % mod;
				if (i - limit - 1 >= 0) {
					dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + mod) % mod;
				}
				dp[i][j][1] = dp[i][j - 1][0];
				dp[i][j][1] = (dp[i][j][1] + dp[i][j - 1][1]) % mod;
				if (j - limit - 1 >= 0) {
					dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + mod) % mod;
				}
			}
		}
		return (dp[zero][one][1] + dp[zero][one][0]) % mod;
	}

}
