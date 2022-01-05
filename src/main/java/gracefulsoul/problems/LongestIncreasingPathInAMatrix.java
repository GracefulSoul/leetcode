package gracefulsoul.problems;

public class LongestIncreasingPathInAMatrix {

	// https://leetcode.com/submissions/detail/613476659/
	public static void main(String[] args) {
		LongestIncreasingPathInAMatrix test = new LongestIncreasingPathInAMatrix();
		System.out.println(test.longestIncreasingPath(new int[][] {
			new int[] { 9, 9, 4 },
			new int[] { 6, 6, 8 },
			new int[] { 2, 1, 1 }
		}));
		System.out.println(test.longestIncreasingPath(new int[][] {
			new int[] { 3, 4, 5 },
			new int[] { 3, 2, 6 },
			new int[] { 2, 2, 1 }
		}));
		System.out.println(test.longestIncreasingPath(new int[][] {
			new int[] { 1 }
		}));
	}

	public int longestIncreasingPath(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] table = new int[row][col];
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result = Math.max(result, this.recursive(matrix, table, i, j, row, col));
			}
		}
		return result;
	}

	private int recursive(int[][] matrix, int[][] table, int i, int j, int row, int col) {
		if (table[i][j] > 0) {
			return table[i][j];
		}
		int num = matrix[i][j];
		int result = 0;
		if (i - 1 >= 0 && matrix[i - 1][j] > num) {
			result = Math.max(result, this.recursive(matrix, table, i - 1, j, row, col));
		}
		if (i + 1 < row && matrix[i + 1][j] > num) {
			result = Math.max(result, this.recursive(matrix, table, i + 1, j, row, col));
		}
		if (j - 1 >= 0 && matrix[i][j - 1] > num) {
			result = Math.max(result, this.recursive(matrix, table, i, j - 1, row, col));
		}
		if (j + 1 < col && matrix[i][j + 1] > num) {
			result = Math.max(result, this.recursive(matrix, table, i, j + 1, row, col));
		}
		table[i][j] = ++result;
		return result;
	}

}
