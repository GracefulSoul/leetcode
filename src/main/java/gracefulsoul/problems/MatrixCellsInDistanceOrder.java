package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class MatrixCellsInDistanceOrder {

	// https://leetcode.com/problems/matrix-cells-in-distance-order/submissions/1158141422/
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
			int r = rCenter - i;
			int c = cCenter;
			for (int j = i; j > 0; j--) {
				if (r >= 0 && c >= 0) {
					result[index++] = new int[] { r, c };
				}
				r++;
				c--;
			}
			for (int j = i; j > 0; j--) {
				if (r < rows && c >= 0) {
					result[index++] = new int[] { r, c };
				}
				r++;
				c++;
			}
			for (int j = i; j > 0; j--) {
				if (r < rows && c < cols) {
					result[index++] = new int[] { r, c };
				}
				r--;
				c++;
			}
			for (int j = i; j > 0; j--) {
				if (r >= 0 && c < cols) {
					result[index++] = new int[] { r, c };
				}
				r--;
				c--;
			}
		}
		return result;
	}

}
