package gracefulsoul.problems;

public class PathsInMatrixWhoseSumIsDivisibleByK {

	// https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/submissions/1840110895/
	public static void main(String[] args) {
		PathsInMatrixWhoseSumIsDivisibleByK test = new PathsInMatrixWhoseSumIsDivisibleByK();
		System.out.println(test.numberOfPaths(new int[][] {
			{ 5, 2, 4 },
			{ 3, 0, 5 },
			{ 0, 7, 2 }
		}, 3));
		System.out.println(test.numberOfPaths(new int[][] {
			{ 0, 0 }
		}, 5));
		System.out.println(test.numberOfPaths(new int[][] {
			{ 7, 3, 4, 9 },
			{ 2, 3, 6, 2 },
			{ 2, 3, 7, 0 }
		}, 1));
	}

	public int numberOfPaths(int[][] grid, int k) {
		int rows = grid.length;
		int cols = grid[0].length;
		int mod = 1000000007;
		int[][][] dp = new int[rows][cols][k];
		dp[0][0][grid[0][0] % k] = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int s = 0; s < k; s++) {
					int sum = (s + grid[i][j]) % k;
					if (j > 0) {
						dp[i][j][sum] += dp[i][j - 1][s];
					}
					if (i > 0) {
						dp[i][j][sum] += dp[i - 1][j][s];
					}
					dp[i][j][sum] %= mod;
				}
			}
		}
		return dp[rows - 1][cols - 1][0];
	}

}
