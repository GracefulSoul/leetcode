package gracefulsoul.problems;

public class NumberOfEnclaves {

	// https://leetcode.com/problems/number-of-enclaves/submissions/1140038238/
	public static void main(String[] args) {
		NumberOfEnclaves test = new NumberOfEnclaves();
		System.out.println(test.numEnclaves(new int[][] {
			{ 0, 0, 0, 0 },
			{ 1, 0, 1, 0 },
			{ 0, 1, 1, 0 },
			{ 0, 0, 0, 0 }
		}));
		System.out.println(test.numEnclaves(new int[][] {
			{ 0, 1, 1, 0 },
			{ 0, 0, 1, 0 },
			{ 0, 0, 1, 0 },
			{ 0, 0, 0, 0 }
		}));
	}

	public int numEnclaves(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int result = 0;
		for (int i = 0; i < row; i++) {
			this.dfs(grid, i, 0);
			this.dfs(grid, i, col - 1);
		}
		for (int j = 0; j < col; j++) {
			this.dfs(grid, 0, j);
			this.dfs(grid, row - 1, j);
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					result++;
				}
			}
		}
		return result;
	}

	private void dfs(int grid[][], int i, int j) {
		if (0 <= i && i <= grid.length - 1 && 0 <= j && j <= grid[i].length - 1 && grid[i][j] == 1) {
			grid[i][j] = 0;
			this.dfs(grid, i + 1, j);
			this.dfs(grid, i - 1, j);
			this.dfs(grid, i, j + 1);
			this.dfs(grid, i, j - 1);
		}
	}

}
