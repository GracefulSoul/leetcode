package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class CyclicallyRotatingAGrid {

	// https://leetcode.com/problems/cyclically-rotating-a-grid/submissions/1998518707/
	public static void main(String[] args) {
		CyclicallyRotatingAGrid test = new CyclicallyRotatingAGrid();
		PrintUtil.print(test.rotateGrid(new int[][] {
			{ 40, 10 },
			{ 30, 20 }
		}, 1));
		PrintUtil.print(test.rotateGrid(new int[][] {
			{ 1, 2, 3, 4 },
			{ 5, 6, 7, 8 },
			{ 9, 10, 11, 12 },
			{ 13, 14, 15, 16 }
		}, 2));
	}

	public int[][] rotateGrid(int[][] grid, int k) {
		int[] row = new int[] { 0, grid.length - 1 };
		int[] col = new int[] { 0, grid[0].length - 1 };
		while (row[0] < row[1] && col[0] < col[1]) {
			for (int i = 0; i < k % (((row[1] - row[0]) * 2) + ((col[1] - col[0]) * 2)); i++) {
				int temp = grid[row[0]][col[0]];
				for (int j = col[0]; j < col[1]; j++) {
					grid[row[0]][j] = grid[row[0]][j + 1];
				}
				for (int j = row[0]; j < row[1]; j++) {
					grid[j][col[1]] = grid[j + 1][col[1]];
				}
				for (int j = col[1]; j > col[0]; j--) {
					grid[row[1]][j] = grid[row[1]][j - 1];
				}
				for (int j = row[1]; j > row[0]; j--) {
					grid[j][col[0]] = grid[j - 1][col[0]];
				}
				grid[row[0] + 1][col[0]] = temp;
			}
			row[0]++;
			row[1]--;
			col[0]++;
			col[1]--;
		}
		return grid;
	}

}
