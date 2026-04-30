package gracefulsoul.problems;

public class MaximumPathScoreInAGrid {

	// https://leetcode.com/problems/maximum-path-score-in-a-grid/submissions/1991845079/
	public static void main(String[] args) {
		MaximumPathScoreInAGrid test = new MaximumPathScoreInAGrid();
		System.out.println(test.maxPathScore(new int[][] {
			{ 0, 1 },
			{ 2, 0 }
		}, 1));
		System.out.println(test.maxPathScore(new int[][] {
			{ 0, 1 },
			{ 1, 2 }
		}, 1));
	}

	public int maxPathScore(int[][] grid, int k) {
		int rows = grid.length;
		int cols = grid[0].length;
		int[][][] dp = new int[rows][cols][k + 1];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int l = 0; l <= k; l++) {
					dp[i][j][l] = -1;
				}
			}
		}
		int[] score = { 0, 1, 2 };
		int[] cost = { 0, 1, 1 };
		dp[0][0][0] = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int l = 0; l <= k; l++) {
					if (dp[i][j][l] == -1) {
						continue;
					}
					int curr = dp[i][j][l];
					if (i + 1 < rows) {
						int next = l + cost[grid[i + 1][j]];
						if (next <= k) {
							dp[i + 1][j][next] = Math.max(dp[i + 1][j][next], curr + score[grid[i + 1][j]]);
						}
					}
					if (j + 1 < cols) {
						int next = l + cost[grid[i][j + 1]];
						if (next <= k) {
							dp[i][j + 1][next] = Math.max(dp[i][j + 1][next], curr + score[grid[i][j + 1]]);
						}
					}
				}
			}
		}
		int result = -1;
		for (int i = 0; i <= k; i++) {
			result = Math.max(result, dp[rows - 1][cols - 1][i]);
		}
		return result;
	}

}
