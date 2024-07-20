package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class FindValidMatrixGivenRowAndColumnSums {

	// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/submissions/1327287831/
	public static void main(String[] args) {
		FindValidMatrixGivenRowAndColumnSums test = new FindValidMatrixGivenRowAndColumnSums();
		PrintUtil.print(test.restoreMatrix(new int[] { 3, 8 }, new int[] { 4, 7 }));
		PrintUtil.print(test.restoreMatrix(new int[] { 5, 7, 10 }, new int[] { 8, 6, 8 }));
	}

	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int row = rowSum.length;
		int col = colSum.length;
		int[][] result = new int[row][col];
		for (int i = 0, j = 0; i < row && j < col;) {
			int num = result[i][j] = Math.min(rowSum[i], colSum[j]);
			if ((rowSum[i] -= num) == 0) {
				i++;
			}
			if ((colSum[j] -= num) == 0) {
				j++;
			}
		}
		return result;
	}

}
