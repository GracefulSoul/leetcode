package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ColoringABorder {

	// https://leetcode.com/problems/coloring-a-border/submissions/1165340389/
	public static void main(String[] args) {
		ColoringABorder test = new ColoringABorder();
		PrintUtil.print(test.colorBorder(new int[][] {
			{ 1, 1 },
			{ 1, 2 }
		}, 0, 0, 3));
		PrintUtil.print(test.colorBorder(new int[][] {
			{ 1, 2, 2 },
			{ 2, 3, 2 }
		}, 0, 1, 3));
		PrintUtil.print(test.colorBorder(new int[][] {
			{ 1, 1, 1 },
			{ 1, 1, 1 },
			{ 1, 1, 1 }
		}, 1, 1, 2));
	}

	public int[][] colorBorder(int[][] grid, int row, int col, int color) {
		int rows = grid.length;
		int cols = grid[0].length;
		if (grid[row][col] != color) {
			this.dfs(grid, row, col, color, grid[row][col], new boolean[rows][cols], rows, cols);
		}
		return grid;
	}

	private void dfs(int[][] grid, int row, int col, int color, int value, boolean[][] visited, int rows, int cols) {
		if (row < 0 || rows <= row || col < 0 || cols <= col || grid[row][col] != value || visited[row][col]) {
			return;
		}
		visited[row][col] = true;
		boolean border = false;
		if (row == 0 || col == 0 || col == cols - 1 || row == rows - 1 || grid[row + 1][col] != value
				|| grid[row - 1][col] != value || grid[row][col - 1] != value || grid[row][col + 1] != value) {
			border = true;
		}
		this.dfs(grid, row + 1, col, color, value, visited, rows, cols);
		this.dfs(grid, row - 1, col, color, value, visited, rows, cols);
		this.dfs(grid, row, col + 1, color, value, visited, rows, cols);
		this.dfs(grid, row, col - 1, color, value, visited, rows, cols);
		if (border) {
			grid[row][col] = color;
		}
	}

}
