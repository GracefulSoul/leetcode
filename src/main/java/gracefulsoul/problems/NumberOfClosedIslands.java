package gracefulsoul.problems;

public class NumberOfClosedIslands {

	// https://leetcode.com/problems/number-of-closed-islands/submissions/1604578140/
	public static void main(String[] args) {
		NumberOfClosedIslands test = new NumberOfClosedIslands();
		System.out.println(test.closedIsland(new int[][] {
			{ 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 1, 0, 0, 0, 0, 1, 1, 0 },
			{ 1, 0, 1, 0, 1, 1, 1, 0 },
			{ 1, 0, 0, 0, 0, 1, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0 }
		}));
		System.out.println(test.closedIsland(new int[][] {
			{ 0, 0, 1, 0, 0 },
			{ 0, 1, 0, 1, 0 },
			{ 0, 1, 1, 1, 0 }
		}));
	}

	public int closedIsland(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 0 && this.dfs(grid, row, col, i, j)) {
					count++;
				}
			}
		}
		return count;
	}

	private boolean dfs(int[][] grid, int row, int col, int i, int j) {
		if (i < 0 || row <= i || j < 0 || col <= j) {
			return false;
		} else if (grid[i][j] == 1) {
			return true;
		} else {
			grid[i][j] = 1;
			boolean left = this.dfs(grid, row, col, i, j - 1);
			boolean top = this.dfs(grid, row, col, i - 1, j);
			boolean right = this.dfs(grid, row, col, i, j + 1);
			boolean bottom = this.dfs(grid, row, col, i + 1, j);
			return left && right && top && bottom;
		}
	}

}
