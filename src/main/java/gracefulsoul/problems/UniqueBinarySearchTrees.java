package gracefulsoul.problems;

public class UniqueBinarySearchTrees {

	// https://leetcode.com/submissions/detail/523342275/
	public static void main(String[] args) {
		UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
		System.out.println(test.numTrees(3));
//		System.out.println(test.numTrees(1));
	}

	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[i - j] * dp[j - 1];
			}
		}
		return dp[n];
	}

}
