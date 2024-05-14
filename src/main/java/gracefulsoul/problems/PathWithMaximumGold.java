package gracefulsoul.problems;

public class PathWithMaximumGold {

	// https://leetcode.com/problems/path-with-maximum-gold/submissions/1257811967/
	public static void main(String[] args) {
		PathWithMaximumGold test = new PathWithMaximumGold();
		System.out.println(test.getMaximumGold(new int[][] {
			{ 0, 6, 0 },
			{ 5, 8, 7 },
			{ 0, 9, 0 }
		}));
		System.out.println(test.getMaximumGold(new int[][] {
			{ 1, 0, 7 },
			{ 2, 0, 6 },
			{ 3, 4, 5 },
			{ 0, 3, 0 },
			{ 9, 0, 20 }
		}));
	}

	public int getMaximumGold(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int result = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result = Math.max(result, this.getMaximumGold(grid, row, col, i, j, 0));
			}
		}
		return result;
	}

	private int getMaximumGold(int[][] grid, int row, int col, int i, int j, int sum) {
		if (grid[i][j] == 0) {
			return sum;
		} else {
			int max = 0;
			int curr = grid[i][j];
			grid[i][j] = 0;
			if (i < row - 1) {
				max = Math.max(max, this.getMaximumGold(grid, row, col, i + 1, j, sum));
			}
			if (j < col - 1) {
				max = Math.max(max, this.getMaximumGold(grid, row, col, i, j + 1, sum));
			}
			if (i > 0) {
				max = Math.max(max, this.getMaximumGold(grid, row, col, i - 1, j, sum));
			}
			if (j > 0) {
				max = Math.max(max, this.getMaximumGold(grid, row, col, i, j - 1, sum));
			}
			grid[i][j] = curr;
			max += curr;
			return max;
		}
	}

}
