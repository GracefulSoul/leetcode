package gracefulsoul.problems;

public class RottingOranges {

	// https://leetcode.com/problems/rotting-oranges/submissions/1051571224/
	public static void main(String[] args) {
		RottingOranges test = new RottingOranges();
		System.out.println(test.orangesRotting(new int[][] {
			{ 2, 1, 1 },
			{ 1, 1, 0 },
			{ 0, 1, 1 }
		}));
		System.out.println(test.orangesRotting(new int[][] {
			{ 2, 1, 1 },
			{ 0, 1, 1 },
			{ 1, 0, 1 }
		}));
		System.out.println(test.orangesRotting(new int[][] {
			{ 0, 2 }
		}));
	}

	public int orangesRotting(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					this.dfs(grid, i, j, 2);
				}
			}
		}
		int minutes = 2;
		for (int[] row : grid) {
			for (int col : row) {
				if (col == 1) {
					return -1;
				}
				minutes = Math.max(minutes, col);
			}
		}
		return minutes - 2;
	}

	private void dfs(int[][] grid, int i, int j, int minutes) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 0 && (grid[i][j] == 1 || grid[i][j] >= minutes)) {
			grid[i][j] = minutes;
			this.dfs(grid, i - 1, j, minutes + 1);
			this.dfs(grid, i + 1, j, minutes + 1);
			this.dfs(grid, i, j - 1, minutes + 1);
			this.dfs(grid, i, j + 1, minutes + 1);
		}
	}

}
