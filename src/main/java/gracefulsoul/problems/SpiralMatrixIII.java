package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SpiralMatrixIII {

	// https://leetcode.com/problems/spiral-matrix-iii/submissions/922926207/
	public static void main(String[] args) {
		SpiralMatrixIII test = new SpiralMatrixIII();
		PrintUtil.print(test.spiralMatrixIII(1, 4, 0, 0));
		PrintUtil.print(test.spiralMatrixIII(5, 6, 1, 4));
	}

	public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		int[][] result = new int[rows * cols][2];
		int row = 0;
		int col = 1;
		int n = 0;
		for (int j = 0; j < rows * cols; n++) {
			for (int i = 0; i < (n / 2) + 1; i++) {
				if (0 <= rStart && rStart < rows && 0 <= cStart && cStart < cols) {
					result[j++] = new int[] { rStart, cStart };
				}
				rStart += row;
				cStart += col;
			}
			int temp = row;
			row = col;
			col = -temp;
		}
		return result;
	}

}
