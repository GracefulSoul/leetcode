package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ReshapeTheMatrix {

	// https://leetcode.com/submissions/detail/745091607/
	public static void main(String[] args) {
		ReshapeTheMatrix test = new ReshapeTheMatrix();
		PrintUtil.print(test.matrixReshape(new int[][] {
			{ 1, 2 },
			{ 3, 4 }
		}, 1, 4));
		PrintUtil.print(test.matrixReshape(new int[][] {
			{ 1, 2 },
			{ 3, 4 }
		}, 2, 4));
	}

	public int[][] matrixReshape(int[][] mat, int r, int c) {
		int row = mat.length;
		int col = mat[0].length;
		if (r * c != row * col) {
			return mat;
		}
		int[][] result = new int[r][c];
		for (int idx = 0; idx < r * c; idx++) {
			result[idx / c][idx % c] = mat[idx / col][idx % col];
		}
		return result;
	}

}
