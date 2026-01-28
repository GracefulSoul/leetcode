package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumCostPathWithTeleportations {

	// https://leetcode.com/problems/minimum-cost-path-with-teleportations/submissions/1899714001/
	public static void main(String[] args) {
		MinimumCostPathWithTeleportations test = new MinimumCostPathWithTeleportations();
		System.out.println(test.minCost(new int[][] {
			{ 1, 3, 3 },
			{ 2, 5, 4 },
			{ 4, 3, 5 }
		}, 2));
		System.out.println(test.minCost(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 4 }
		}, 1));
	}

	public int minCost(int[][] grid, int k) {
		int rows = grid.length;
		int cols = grid[0].length;
		int max = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				max = Math.max(max, grid[i][j]);
			}
		}
		int[][] dp = new int[rows][cols];
		int[] temp = new int[max + 1];
		int[] best = new int[max + 1];
		Arrays.fill(temp, Integer.MAX_VALUE);
		temp[grid[rows - 1][cols - 1]] = 0;
		for (int i = cols - 2; i >= 0; i--) {
			int row = rows - 1;
			dp[row][i] = dp[row][i + 1] + grid[row][i + 1];
			temp[grid[row][i]] = Math.min(temp[grid[row][i]], dp[row][i]);
		}
		for (int i = rows - 2; i >= 0; i--) {
			int col = cols - 1;
			dp[i][col] = dp[i + 1][col] + grid[i + 1][col];
			temp[grid[i][col]] = Math.min(temp[grid[i][col]], dp[i][col]);
			for (int j = col - 1; j >= 0; j--) {
				dp[i][j] = Math.min(dp[i + 1][j] + grid[i + 1][j], dp[i][j + 1] + grid[i][j + 1]);
				temp[grid[i][j]] = Math.min(temp[grid[i][j]], dp[i][j]);
			}
		}
		while (0 < k--) {
			best[0] = temp[0];
			for (int i = 1; i <= max; i++) {
				best[i] = Math.min(best[i - 1], temp[i]);
			}
			for (int i = cols - 2; i >= 0; i--) {
				int row = rows - 1;
				dp[row][i] = Math.min(best[grid[row][i]], dp[row][i + 1] + grid[row][i + 1]);
				temp[grid[row][i]] = Math.min(temp[grid[row][i]], dp[row][i]);
			}
			for (int i = rows - 2; i >= 0; i--) {
				int col = cols - 1;
				dp[i][col] = Math.min(best[grid[i][col]], dp[i + 1][col] + grid[i + 1][col]);
				temp[grid[i][col]] = Math.min(temp[grid[i][col]], dp[i][col]);
				for (int j = cols - 2; j >= 0; j--) {
					dp[i][j] = Math.min(Math.min(dp[i + 1][j] + grid[i + 1][j], dp[i][j + 1] + grid[i][j + 1]), best[grid[i][j]]);
					temp[grid[i][j]] = Math.min(temp[grid[i][j]], dp[i][j]);
				}
			}
		}
		return dp[0][0];
	}

}
