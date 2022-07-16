package gracefulsoul.problems;

public class OutOfBoundaryPaths {

	// https://leetcode.com/submissions/detail/748914894/
	public static void main(String[] args) {
		OutOfBoundaryPaths test = new OutOfBoundaryPaths();
		System.out.println(test.findPaths(2, 2, 2, 0, 0));
		System.out.println(test.findPaths(1, 3, 3, 0, 1));
	}

	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int mod = 1000000007;
		int result = 0;
		int[][] grid = new int[m][n];
		grid[startRow][startColumn] = 1;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };
		for (int t = 0; t < maxMove; t++) {
			int[][] temp = new int[m][n];
			for (int r = 0; r < m; r++) {
				for (int c = 0; c < n; c++) {
					if (grid[r][c] == 0) {
						continue;
					}
					for (int k = 0; k < 4; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
							temp[nr][nc] = (temp[nr][nc] + grid[r][c]) % mod;
						} else {
							result = (result + grid[r][c]) % mod;
						}
					}

				}
			}
			grid = temp;
		}
		return result;
	}

}
