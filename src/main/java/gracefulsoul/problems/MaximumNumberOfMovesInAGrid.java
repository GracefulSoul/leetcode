package gracefulsoul.problems;

public class MaximumNumberOfMovesInAGrid {

	// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/submissions/1437136330/
	public static void main(String[] args) {
		MaximumNumberOfMovesInAGrid test = new MaximumNumberOfMovesInAGrid();
		System.out.println(test.maxMoves(new int[][] {
			{ 2, 4, 3, 5 },
			{ 5, 4, 9, 3 },
			{ 3, 4, 2, 11 },
			{ 10, 9, 13, 15 }
		}));
		System.out.println(test.maxMoves(new int[][] {
			{ 3, 2, 4 },
			{ 2, 1, 9 },
			{ 1, 1, 7 }
		}));
	}

	public int maxMoves(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int[][] dp = new int[row][col];
		int result = 0;
		for (int j = col - 2; j >= 0; j--) {
			for (int i = 0; i < row; i++) {
				int num = grid[i][j];
				if (i - 1 > -1 && grid[i - 1][j + 1] > num) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + 1);
				}
				if (grid[i][j + 1] > num) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
				}
				if (i + 1 < row && grid[i + 1][j + 1] > num) {
					dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1] + 1);
				}
			}
		}
		for (int i = 0; i < row; i++) {
			result = Math.max(result, dp[i][0]);
		}
		return result;
	}

}
