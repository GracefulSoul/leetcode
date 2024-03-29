package gracefulsoul.problems;

public class NumberOfIncreasingPathsInAGrid {

	// https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/submissions/973652653/
	public static void main(String[] args) {
		NumberOfIncreasingPathsInAGrid test = new NumberOfIncreasingPathsInAGrid();
		System.out.println(test.countPaths(new int[][] {
			{ 1, 1 },
			{ 3, 4 }
		}));
		System.out.println(test.countPaths(new int[][] {
			{ 1 },
			{ 2 }
		}));
	}

	private int mod = 1000000007;
	private int[][] directions = new int[][] {
		{ 1, 0 },
		{ 0, -1 },
		{ -1, 0 },
		{ 0, 1 }
	};

	public int countPaths(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int count = 0;
		int[][] dp = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				count = (count + this.getCount(grid, dp, row, col, i, j, 0)) % this.mod;
			}
		}
		return count;
	}

	private int getCount(int[][] grid, int[][] dp, int row, int col, int i, int j, int prev) {
		if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] <= prev) {
			return 0;
		} else if (dp[i][j] != 0) {
			return dp[i][j];
		} else {
			int count = 1;
			for (int[] direction : this.directions) {
				count = (count + this.getCount(grid, dp, row, col, i + direction[0], j + direction[1], grid[i][j])) % this.mod;
			}
			dp[i][j] = count;
			return count;
		}
	}

}
