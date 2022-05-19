package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class DiagonalTraverse {

	// https://leetcode.com/submissions/detail/702681885/
	public static void main(String[] args) {
		DiagonalTraverse test = new DiagonalTraverse();
		PrintUtil.print(test.findDiagonalOrder(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
		}));
		PrintUtil.print(test.findDiagonalOrder(new int[][] {
			{ 1, 2 },
			{ 3, 4 }
		}));
	}

	public int[] findDiagonalOrder(int[][] mat) {
		int row = 0;
		int col = 0;
		int rowLength = mat.length;
		int colLength = mat[0].length;
		int size = rowLength * colLength;
		int[] result = new int[size];
		for (int idx = 0; idx < result.length; idx++) {
			result[idx] = mat[row][col];
			if ((row + col) % 2 == 0) {
				if (col == colLength - 1) {
					row++;
				} else if (row == 0) {
					col++;
				} else {
					row--;
					col++;
				}
			} else {
				if (row == rowLength - 1) {
					col++;
				} else if (col == 0) {
					row++;
				} else {
					row++;
					col--;
				}
			}
		}
		return result;
	}

}
