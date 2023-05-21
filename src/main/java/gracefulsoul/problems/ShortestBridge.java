package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

	// https://leetcode.com/problems/shortest-bridge/submissions/954250607/
	public static void main(String[] args) {
		ShortestBridge test = new ShortestBridge();
		System.out.println(test.shortestBridge(new int[][] {
			{ 0, 1 },
			{ 1, 0 }
		}));
		System.out.println(test.shortestBridge(new int[][] {
			{ 0, 1, 0 },
			{ 0, 0, 0 },
			{ 0, 0, 1 }
		}));
		System.out.println(test.shortestBridge(new int[][] {
			{ 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1 }
		}));
	}

	private static final int[][] DIRECTIONS = {
		{ 0, 1 },
		{ 0, -1 },
		{ -1, 0 },
		{ 1, 0 }
	};

	public int shortestBridge(int[][] grid) {
		int length = grid.length;
		boolean found = false;
		Queue<int[]> queue = new LinkedList<>();
		int level = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (grid[i][j] == 1 && !found) {
					this.dfs(grid, i, j);
					found = true;
				}
				if (found && grid[i][j] == 1) {
					queue.add(new int[] { i, j });
				}
			}
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] pos = queue.poll();
				for (int i = 0; i < 4; i++) {
					int x = pos[0] + DIRECTIONS[i][0];
					int y = pos[1] + DIRECTIONS[i][1];
					if (x < 0 || x >= length || y < 0 || y >= length) {
						continue;
					}
					if (grid[x][y] == 2) {
						return level;
					} else if (grid[x][y] == 1) {
						continue;
					} else if (grid[x][y] == 0) {
						grid[x][y] = 1;
						queue.add(new int[] { x, y });
					}
				}
			}
			level++;
		}
		return -1;

	}

	public void dfs(int[][] grid, int i, int j) {
		int length = grid.length;
		grid[i][j] = 2;
		if (i - 1 >= 0 && grid[i - 1][j] == 1) {
			this.dfs(grid, i - 1, j);
		}
		if (i + 1 < length && grid[i + 1][j] == 1) {
			this.dfs(grid, i + 1, j);
		}
		if (j - 1 >= 0 && grid[i][j - 1] == 1) {
			this.dfs(grid, i, j - 1);
		}
		if (j + 1 < length && grid[i][j + 1] == 1) {
			this.dfs(grid, i, j + 1);
		}
	}

}
