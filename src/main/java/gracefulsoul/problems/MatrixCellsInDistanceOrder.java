package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class MatrixCellsInDistanceOrder {

	// https://leetcode.com/problems/matrix-cells-in-distance-order/submissions/1158150449/
	public static void main(String[] args) {
		MatrixCellsInDistanceOrder test = new MatrixCellsInDistanceOrder();
		PrintUtil.print(test.allCellsDistOrder(1, 2, 0, 0));
		PrintUtil.print(test.allCellsDistOrder(2, 2, 0, 1));
		PrintUtil.print(test.allCellsDistOrder(2, 3, 1, 2));
	}

	public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
		int[][] result = new int[rows * cols][];
		result[0] = new int[] { rCenter, cCenter };
		int index = 1;
		int max = Math.max(rCenter, rows - rCenter - 1) + Math.max(cCenter, cols - cCenter - 1);
		for (int i = 1; i <= max; i++) {
			int row = rCenter - i;
			int col = cCenter;
			for (int j = i; j > 0; j--) {
				if (row >= 0 && col >= 0) {
					result[index++] = new int[] { row, col };
				}
				row++;
				col--;
			}
			for (int j = i; j > 0; j--) {
				if (row < rows && col >= 0) {
					result[index++] = new int[] { row, col };
				}
				row++;
				col++;
			}
			for (int j = i; j > 0; j--) {
				if (row < rows && col < cols) {
					result[index++] = new int[] { row, col };
				}
				row--;
				col++;
			}
			for (int j = i; j > 0; j--) {
				if (row >= 0 && col < cols) {
					result[index++] = new int[] { row, col };
				}
				row--;
				col--;
			}
		}
		return result;
	}

}
