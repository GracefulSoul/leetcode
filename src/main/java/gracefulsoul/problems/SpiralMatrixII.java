package gracefulsoul.problems;

import java.util.Arrays;

public class SpiralMatrixII {

	// https://leetcode.com/submissions/detail/504715101/
	public static void main(String[] args) {
		SpiralMatrixII test = new SpiralMatrixII();
		print(test.generateMatrix(3));
		print(test.generateMatrix(1));
	}

	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int row = 0;
		int col = 0;
		int rowMax = n - 1;
		int colMax = n - 1;
		int num = 1;
		while (num <= n * n) {
			for (int idx = col; idx <= colMax && num <= n * n; idx++) {
				result[row][idx] = num++;
			}
			for (int idx = row + 1; idx <= rowMax - 1 && num <= n * n; idx++) {
				result[idx][colMax] = num++;
			}
			for (int idx = colMax; idx >= col && num <= n * n; idx--) {
				result[rowMax][idx] = num++;
			}
			for (int idx = rowMax - 1; idx >= row + 1 && num <= n * n; idx--) {
				result[idx][col] = num++;
			}
			row++;
			col++;
			rowMax--;
			colMax--;
		}
		return result;
	}

	private static void print(int[][] matrix) {
		for (int[] array : matrix) {
			System.out.println(Arrays.toString(array));
		}
	}

}
