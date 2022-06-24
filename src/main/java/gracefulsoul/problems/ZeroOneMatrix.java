package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ZeroOneMatrix {

	// https://leetcode.com/submissions/detail/730077805/
	public static void main(String[] args) {
		ZeroOneMatrix test = new ZeroOneMatrix();
		PrintUtil.print(test.updateMatrix(new int[][] {
			{ 0, 0, 0 },
			{ 0, 1, 0 },
			{ 0, 0, 0 }
		}));
		PrintUtil.print(test.updateMatrix(new int[][] {
			{ 0, 0, 0 },
			{ 0, 1, 0 },
			{ 1, 1, 1 }
		}));
	}

	public int[][] updateMatrix(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		int distance = row + col;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == 0) {
					continue;
				}
				int top = distance;
				int left = distance;
				if (i - 1 >= 0) {
					top = mat[i - 1][j];
				}
				if (j - 1 >= 0) {
					left = mat[i][j - 1];
				}
				mat[i][j] = Math.min(top, left) + 1;
			}
		}
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (mat[i][j] == 0) {
					continue;
				}
				int bottom = distance;
				int right = distance;
				if (i + 1 < row) {
					bottom = mat[i + 1][j];
				}
				if (j + 1 < col) {
					right = mat[i][j + 1];
				}
				mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
			}
		}
		return mat;
	}

}
