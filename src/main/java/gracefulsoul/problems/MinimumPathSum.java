package gracefulsoul.problems;

public class MinimumPathSum {

	// https://leetcode.com/submissions/detail/508070444/
	public static void main(String[] args) {
		MinimumPathSum test = new MinimumPathSum();
		System.out.println(test.minPathSum(new int[][] {
			new int[] { 1, 3, 1 },
			new int[] { 1, 5, 1 },
			new int[] { 4, 2, 1 }
		}));
		System.out.println(test.minPathSum(new int[][] {
			new int[] { 1, 2, 3 },
			new int[] { 4, 5, 6 }
		}));
	}

	public int minPathSum(int[][] grid) {
		int[] dp = this.getDp(grid);
		for (int i = 1; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (j == 0) {
					dp[j] += grid[i][j];
				} else {
					dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
				}
			}
		}
		return dp[grid[0].length - 1];
	}

	private int[] getDp(int[][] grid) {
		int[] dp = new int[grid[0].length];
		dp[0] = grid[0][0];
		for (int j = 1; j < grid[0].length; j++) {
			dp[j] = dp[j - 1] + grid[0][j];
		}
		return dp;
	}

}
