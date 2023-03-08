package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class TransposeMatrix {

	// https://leetcode.com/problems/transpose-matrix/submissions/911411264/
	public static void main(String[] args) {
		TransposeMatrix test = new TransposeMatrix();
		PrintUtil.print(test.transpose(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
		}));
		PrintUtil.print(test.transpose(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 }
		}));
	}

	public int[][] transpose(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] result = new int[col][row];
		for (int j = 0; j < col; j++) {
			for (int i = 0; i < row; i++) {
				result[j][i] = matrix[i][j];
			}
		}
		return result;
	}

}
