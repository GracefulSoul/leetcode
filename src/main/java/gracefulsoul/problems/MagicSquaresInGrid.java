package gracefulsoul.problems;

public class MagicSquaresInGrid {

	// https://leetcode.com/problems/magic-squares-in-grid/submissions/898391158/
	public static void main(String[] args) {
		MagicSquaresInGrid test = new MagicSquaresInGrid();
		System.out.println(test.numMagicSquaresInside(new int[][] {
			{ 4, 3, 8, 4 },
			{ 9, 5, 1, 9 },
			{ 2, 7, 6, 2 }
		}));
		System.out.println(test.numMagicSquaresInside(new int[][] {
			{ 8 }
		}));
	}

	public int numMagicSquaresInside(int[][] grid) {
		int result = 0;
		for (int i = 0; i <  grid.length - 2; i++) {
			for (int j = 0; j < grid[0].length - 2; j++) {
				if (this.isMagicSquare(grid, i, j)) {
					result++;
				}
			}
		}
		return result;
	}

	private boolean isMagicSquare(int[][] grid, int row, int col) {
		boolean[] visited = new boolean[10];
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (grid[i][j] < 1 || grid[i][j] > 9 || visited[grid[i][j]]) {
					return false;
				}
				visited[grid[i][j]] = true;
			}
		}
		int sum = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
		if (sum != grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col]) {
			return false;
		}
		for (int i = 0; i < 3; i++) {
			if (sum != grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] ||
					sum != grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i]) {
				return false;
			}
		}
		return true;
	}

}
