package gracefulsoul.problems;

public class MinimumNumberOfDaysToDisconnectIsland {

	// https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/submissions/1351660341/
	public static void main(String[] args) {
		MinimumNumberOfDaysToDisconnectIsland test = new MinimumNumberOfDaysToDisconnectIsland();
		System.out.println(test.minDays(new int[][] {
			{ 0, 1, 1, 0 },
			{ 0, 1, 1, 0 },
			{ 0, 0, 0, 0 }
		}));
		System.out.println(test.minDays(new int[][] {
			{ 1, 1 }
		}));
	}

	public int minDays(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		if (this.getLands(grid, row, col) != 1) {
			return 0;
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					grid[i][j] = 0;
					if (this.getLands(grid, row, col) != 1) {
						return 1;
					}
					grid[i][j] = 1;
				}
			}
		}
		return 2;
	}

	private int getLands(int[][] grid, int row, int col) {
		int result = 0;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!visited[i][j] && grid[i][j] == 1) {
					result++;
					this.dfs(visited, grid, row, col, i, j);
				}
			}
		}
		return result;
	}

	private void dfs(boolean[][] visited, int[][] grid, int row, int col, int i, int j) {
		if (i < 0 || i == row || j < 0 || j == col || visited[i][j] || grid[i][j] == 0) {
			return;
		}
		visited[i][j] = true;
		this.dfs(visited, grid, row, col, i - 1, j);
		this.dfs(visited, grid, row, col, i + 1, j);
		this.dfs(visited, grid, row, col, i, j - 1);
		this.dfs(visited, grid, row, col, i, j + 1);
	}

}
