package gracefulsoul.problems;

public class DominoAndTrominoTiling {

	// https://leetcode.com/problems/domino-and-tromino-tiling/submissions/868975974/
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
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int idx = 3; idx < n + 1; idx++) {
			dp[idx] = (2 * dp[idx - 1] + dp[idx - 3]) % 1000000007;
		}
		return (int) dp[n];
	}

}
