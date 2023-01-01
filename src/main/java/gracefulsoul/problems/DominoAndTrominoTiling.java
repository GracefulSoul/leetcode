package gracefulsoul.problems;

public class DominoAndTrominoTiling {

	// https://leetcode.com/problems/domino-and-tromino-tiling/submissions/868964529/
	public static void main(String[] args) {
		DominoAndTrominoTiling test = new DominoAndTrominoTiling();
		System.out.println(test.numTilings(3));
		System.out.println(test.numTilings(1));
	}

	public int numTilings(int n) {
		if (n < 3) {
			return n;
		}
		long[] dp = new long[n + 1];
		long mod = 1000000007;
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < n + 1; i++) {
			dp[i] = (2 * dp[i - 1] + dp[i - 3]) % mod;
		}
		return (int) dp[n];
	}

}
