package gracefulsoul.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumCostToMakeAtLeastOneValidPathInAGrid {

	// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/submissions/1512053169/
	public static void main(String[] args) {
		MinimumCostToMakeAtLeastOneValidPathInAGrid test = new MinimumCostToMakeAtLeastOneValidPathInAGrid();
		System.out.println(test.minCost(new int[][] {
			{ 1, 1, 1, 1 },
			{ 2, 2, 2, 2 },
			{ 1, 1, 1, 1 },
			{ 2, 2, 2, 2 }
		}));
		System.out.println(test.minCost(new int[][] {
			{ 1, 1, 3 },
			{ 3, 2, 2 },
			{ 1, 1, 4 }
		}));
		System.out.println(test.minCost(new int[][] {
			{ 1, 2 },
			{ 4, 3 }
		}));
	}

	private static final int[][] DIRECTIONS = new int[][] {
		{ 0, 1 },
		{ 0, -1 },
		{ 1, 0 },
		{ -1, 0 }
	};

	public int minCost(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int cost = 0;
		int[][] dp = new int[row][col];
		for (int i = 0; i < row; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		Queue<int[]> queue = new LinkedList<>();
		this.dfs(grid, 0, 0, dp, cost, queue);
		while (!queue.isEmpty()) {
			cost++;
			for (int i = queue.size(); i > 0; i--) {
				int[] curr = queue.poll();
				for (int[] direction : DIRECTIONS) {
					this.dfs(grid, curr[0] + direction[0], curr[1] + direction[1], dp, cost, queue);
				}
			}
		}
		return dp[row - 1][col - 1];
	}

	private void dfs(int[][] grid, int i, int j, int[][] dp, int cost, Queue<int[]> queue) {
		if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && dp[i][j] == Integer.MAX_VALUE) {
			dp[i][j] = cost;
			queue.offer(new int[] { i, j });
			int next = grid[i][j] - 1;
			this.dfs(grid, i + DIRECTIONS[next][0], j + DIRECTIONS[next][1], dp, cost, queue);
		}
	}

}
