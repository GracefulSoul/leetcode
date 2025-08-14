package gracefulsoul.problems;

public class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {

	// https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/submissions/1734952616/
	public static void main(String[] args) {
		MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix test = new MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix();
		System.out.println(test.minFlips(new int[][] {
			{ 0, 0 },
			{ 0, 1 }
		}));
		System.out.println(test.minFlips(new int[][] {
			{ 0 }
		}));
		System.out.println(test.minFlips(new int[][] {
			{ 1, 0, 0 },
			{ 1, 0, 0 }
		}));
	}

	private static final int[][] DIRECTIONS = {
		{ -1, 0 },
		{ 0, -1 },
		{ 0, 0 },
		{ 0, 1 },
		{ 1, 0 }
	};

	public int minFlips(int[][] mat) {
		int result = this.getCount(mat, 0, 0);
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private int getCount(int[][] mat, int col, int count) {
		if (col < mat[0].length) {
			this.flip(mat, 0, col);
			int result = this.getCount(mat, col + 1, count + 1);
			this.flip(mat, 0, col);
			return Math.min(result, this.getCount(mat, col + 1, count));
		} else {
			int rows = mat.length;
			int cols = mat[0].length;
			int[][] clone = new int[rows][];
			for (int i = 0; i < rows; i++) {
				clone[i] = mat[i].clone();
			}
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (clone[i - 1][j] == 1) {
						this.flip(clone, i, j);
						count++;
					}
				}
			}
			for (int i = 0; i < cols; i++) {
				if (clone[rows - 1][i] == 1) {
					return Integer.MAX_VALUE;
				}
			}
			return count;
		}
	}

	private void flip(int[][] mat, int i, int j) {
		int rows = mat.length;
		int cols = mat[0].length;
		for (int[] direction : DIRECTIONS) {
			int x = i + direction[0];
			int y = j + direction[1];
			if (0 <= x && x < rows && 0 <= y && y < cols) {
				mat[x][y] ^= 1;
			}
		}
	}

}
