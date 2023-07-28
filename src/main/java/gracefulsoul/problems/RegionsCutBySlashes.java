package gracefulsoul.problems;

public class RegionsCutBySlashes {

	// https://leetcode.com/problems/regions-cut-by-slashes/submissions/1006081526/
	public static void main(String[] args) {
		RegionsCutBySlashes test = new RegionsCutBySlashes();
		System.out.println(test.regionsBySlashes(new String[] { " /", "/ " }));
		System.out.println(test.regionsBySlashes(new String[] { " /", "  " }));
		System.out.println(test.regionsBySlashes(new String[] { "/\\", "\\/" }));
	}

	public int regionsBySlashes(String[] grid) {
		int length = grid.length;
		int size = length * 3;
		int regions = 0;
		int[][] dp = new int[size][size];
		for (int i = 0; i < length; i++) {
			int row = i * 3;
			for (int j = 0; j < length; j++) {
				int col = j * 3;
				if (grid[i].charAt(j) == '/') {
					dp[row][col + 2] = dp[row + 1][col + 1] = dp[row + 2][col] = 1;
				} else if (grid[i].charAt(j) == '\\') {
					dp[row][col] = dp[row + 1][col + 1] = dp[row + 2][col + 2] = 1;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				regions += this.dfs(dp, i, j) > 0 ? 1 : 0;
			}
		}
		return regions;
	}

	private int dfs(int[][] dp, int i, int j) {
		if (Math.min(i, j) < 0 || dp.length <= Math.max(i, j) || dp[i][j] != 0) {
			return 0;
		} else {
			dp[i][j] = 1;
			return 1 + this.dfs(dp, i - 1, j) + this.dfs(dp, i, j - 1) + this.dfs(dp, i + 1, j) + this.dfs(dp, i, j + 1);
		}
	}

}
