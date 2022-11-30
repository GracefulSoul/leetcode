package gracefulsoul.problems;

public class CherryPickup {

	// https://leetcode.com/submissions/detail/852024130/
	public static void main(String[] args) {
		CherryPickup test = new CherryPickup();
		System.out.println(test.cherryPickup(new int[][] {
			{ 0, 1, -1 },
			{ 1, 0, -1 },
			{ 1, 1, 1 }
		}));
		System.out.println(test.cherryPickup(new int[][] {
			{ 1, 1, -1 },
			{ 1, -1, 1 },
			{ -1, 1, 1 }
		}));
	}

	public int cherryPickup(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int[][][] dp = new int[row][col][row];
		int dead = -(row + col) * 3;
		if (grid[0][0] == 1) {
			dp[0][0][0] = 1;
		}
		for (int j = 1; j < col; j++) {
			dp[0][j][0] = (grid[0][j] == -1 ? dead : dp[0][j - 1][0] + grid[0][j]);
		}
		for (int i = 1; i < row; i++) {
			if (grid[i][0] == -1) {
				for (int k = i; k >= 0; k--) {
					dp[i][0][k] = dead;
				}
			} else {
				for (int k = i, ks = Math.max(0, i - col + 1); k >= ks; k--) {
					if (grid[k][i - k] == -1) {
						dp[i][0][k] = dead;
					} else if (k == i) {
						dp[i][0][i] = grid[i][0] + dp[i - 1][0][i - 1];
					} else if (k == 0) {
						dp[i][0][k] = grid[i][0] + grid[k][i - k] + dp[i - 1][0][k];
					} else {
						dp[i][0][k] = grid[i][0] + grid[k][i - k] + Math.max(dp[i - 1][0][k - 1], dp[i - 1][0][k]);
					}
				}
			}
			for (int j = 1; j < col; j++) {
				if (grid[i][j] == -1) {
					for (int k = i; k >= 0; k--) {
						dp[i][j][k] = dead;
					}
				} else {
					for (int ks = i - 1, k = Math.max(0, i + j - col + 1); k <= ks; k++) {
						if (grid[i][j] == -1 || grid[k][i + j - k] == -1) {
							dp[i][j][k] = dead;
						} else if (k == 0) {
							dp[i][j][k] = grid[i][j] + grid[k][i + j - k] + Math.max(dp[i - 1][j][k], dp[i][j - 1][k]);
						} else {
							dp[i][j][k] = grid[i][j] + grid[k][i + j - k] + Math.max(dp[i - 1][j][k - 1], Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k - 1], dp[i][j - 1][k])));
						}
					}
					if (grid[i][j] == -1) {
						dp[i][j][i] = dead;
					} else if (j == 0) {
						dp[i][j][i] = grid[i][j] + dp[i - 1][j][i - 1];
					} else {
						dp[i][j][i] = grid[i][j] + Math.max(dp[i - 1][j][i - 1], Math.max(dp[i][j - 1][i - 1], dp[i][j - 1][i]));
					}
				}
			}
		}
		return Math.max(0, dp[row - 1][col - 1][row - 1]);
	}
    
}
