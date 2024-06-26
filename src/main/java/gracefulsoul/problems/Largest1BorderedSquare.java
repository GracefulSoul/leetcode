package gracefulsoul.problems;

public class Largest1BorderedSquare {

	// https://leetcode.com/problems/largest-1-bordered-square/submissions/1299805720/
	public static void main(String[] args) {
		Largest1BorderedSquare test = new Largest1BorderedSquare();
		System.out.println(test.largest1BorderedSquare(new int[][] {
			{ 1, 1, 1 },
			{ 1, 0, 1 },
			{ 1, 1, 1 }
		}));
		System.out.println(test.largest1BorderedSquare(new int[][] {
			{ 1, 1, 0, 0 }
		}));
	}

	public int largest1BorderedSquare(int[][] grid) {
		int result = 0;
		int row = grid.length;
		int col = grid[0].length;
		int[][] rowDp = new int[row + 1][col + 1];
		int[][] colDp = new int[row + 1][col + 1];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (grid[i - 1][j - 1] == 0) {
					continue;
				}
				rowDp[i][j] = rowDp[i - 1][j] + 1;
				colDp[i][j] = colDp[i][j - 1] + 1;
				for (int k = Math.min(rowDp[i][j], colDp[i][j]); k >= 1; k--) {
					if (rowDp[i][j + 1 - k] >= k && colDp[i + 1 - k][j] >= k) {
						result = Math.max(result, k * k);
						break;
					}
				}
			}
		}
		return result;
	}

}
